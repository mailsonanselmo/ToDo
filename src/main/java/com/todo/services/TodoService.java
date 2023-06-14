package com.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.domain.Todo;
import com.todo.exceptions.ObjectNotFoundException;
import com.todo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public Todo findById(Integer id) {

		Optional<Todo> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+ id + ", Tipo: " + Todo.class.getName()));

	}

	public List<Todo> findAllOpen() {

		List<Todo> list = repository.findAllOpen();

		return list;

	}

	public List<Todo> findAllClosed() {

		List<Todo> list = repository.findAllClosed();

		return list;
	}

	public List<Todo> findAll() {

		List<Todo> list = repository.findAll();

		return list;
	}
	
	public Todo create(Todo obj) {

		obj.setId(null);
		
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

}