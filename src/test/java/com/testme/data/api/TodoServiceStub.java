package com.testme.data.api;

import java.util.Arrays;
import java.util.List;

/*
 * A Stub is only used for Unit Testing.
 * A sample implementation of TodoService.
 */
public class TodoServiceStub implements TodoService {

	/*
	 * Two main problems using Stubs:
	 * 
	 * 1) Dynamic conditions -
	 * 	when the method needs to return different values for testing, the code
	 * 	starts to get large and difficult to maintain.
	 * 
	 * 2) Service Definition - 
	 * 	if TodoService interface has more than one method, the TodoServiceStub needs
	 *  to have the same methods initialized.
	 *   
	 */
	
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Computer Science", 
							 "Learn Algorithms", 
							 "Learn Spring Boot", 
							 "Learn Data Structures",
							 "Learn Spring MVC",
							 "Learn Java",
							 "Learn HTML",
							 "Learn CSS",
							 "Build 40 HTML/CSS projects",
							 "Build 4 Spring Boot projects",
							 "Build 4 Spring MVC projects");
		
	}
	
	public void deleteTodo(String todo) {}
	
}
