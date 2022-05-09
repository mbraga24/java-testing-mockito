package com.testme.data.api;

import java.util.Arrays;
import java.util.List;

/*
 * A Stub is only used for Unit Testing.
 * A sample implementation of TodoService.
 */
public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Computer Science", 
							 "Learn Algorithms", 
							 "Learn Spring", 
							 "Learn Data Structures",
							 "Learn Spring MVC",
							 "Learn Java",
							 "Learn HTML",
							 "Learn CSS",
							 "Build 40 HTML/CSS projects",
							 "Build 3 Spring projects",
							 "Build 4 Spring MVC projects");
	}
	
}
