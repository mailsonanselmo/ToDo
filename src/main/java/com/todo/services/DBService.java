package com.todo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.todo.domain.Todo;
import com.todo.repository.TodoRepository;

@Service
public class DBService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public void InstanciaBancoDados() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		Todo t1 = new Todo(null, "Todo Spring Boot 2 e Angular 11", "Todo", LocalDateTime.parse("05/06/2023 22:36", formatter), false);
		Todo t2 = new Todo(null, "Todo Spring Boot 2 e Angular 11", "Todo", LocalDateTime.parse("10/06/2023 22:36", formatter), true);
		Todo t3 = new Todo(null, "Todo Spring Boot 2 e Angular 11", "Todo", LocalDateTime.parse("12/06/2023 22:36", formatter), true);
		Todo t4 = new Todo(null, "Todo Spring Boot 2 e Angular 11", "Todo", LocalDateTime.parse("13/06/2023 22:36", formatter), false);
		
		
		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
		
	}


}
