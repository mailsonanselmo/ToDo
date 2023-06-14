package com.todo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todo.domain.Todo;
import com.todo.services.TodoService;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {
	
	@Autowired
	private TodoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id){
		
		Todo obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	
	}
		
	@GetMapping(value = "/open")
	public ResponseEntity <List<Todo>> listOpen(){
		
		List<Todo> list = service.findAllOpen();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/closed")
	public ResponseEntity <List<Todo>> listClosed(){
		
		List<Todo> list = service.findAllClosed();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity <List<Todo>> listAll(){
		
		List<Todo> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity <Todo> create(@RequestBody Todo obj){
		
		obj = service.create(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Todo> delete(@PathVariable Integer id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
		
	}

}
