package com.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.domain.Todo;
import com.todo.repository.TodoRepository;

@Service
public class DBService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public void InstanciaBancoDados() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Todo t1 = new Todo(null, "Todo Spring Boot 2 e Angular 11", "Todo", sdf.parse("10/06/2023"), true);
		Todo t2 = new Todo(null, "Todo Spring Boot 2 e Angular 11", "Todo", sdf.parse("10/06/2023"), true);
		Todo t3 = new Todo(null, "Todo Spring Boot 2 e Angular 11", "Todo", sdf.parse("12/06/2023"), true);
		Todo t4 = new Todo(null, "Todo Spring Boot 2 e Angular 11", "Todo", sdf.parse("13/06/2023"), false);
		
		
		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
		
	}


}
