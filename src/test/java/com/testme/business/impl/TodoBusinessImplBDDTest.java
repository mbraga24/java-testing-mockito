package com.testme.business.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.testme.data.api.TodoService;

/*
 * Behavior Driven Development - BDD
 * 
 * https://en.wikipedia.org/wiki/Behavior-driven_development
 * 
 */
public class TodoBusinessImplBDDTest {
	
	/* 
	 * Dynamically stubbing a method
	 * Making the mock return a specific value on a specific method call.
	 */
	
	@Test
	public void retrieveTodosRelatedToSpringTest_usingBDD() {
		
		// Given - setup 
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Computer Science", 
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
		given(todoServiceMock.retrieveTodos("John")).willReturn(todos);
	
		// When - actual method call
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("John");
		
		// Then - asserts
		assertThat(filteredTodos.size(), is(4));
		// ===> .is() method is part of the hamcrest matchers
	}
	
	@Test
	public void retrieveTodosRelatedToSpringTest_returnEmptyList() {
		
		// Given - setup
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		given(todoServiceMock.retrieveTodos("Alex")).willReturn(todos);
		
		// When - actual method call
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Alex");
		
		// Then - asserts
		assertThat(filteredTodos.size(), is(0));
		// ===> .is() method is part of the hamcrest matchers
	}

}
