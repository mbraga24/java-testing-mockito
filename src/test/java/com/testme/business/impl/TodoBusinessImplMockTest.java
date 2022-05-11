package com.testme.business.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.testme.data.api.TodoService;

/*
 * Mocking is creating objects that simulate the behavior of real objects.
 * unlike stubs, mocks can be dynamically created from code - at runtime.
 * Mocks offer more functionality than stubbing.
 * You can verify method calls and a lot more.
 */
public class TodoBusinessImplMockTest {
	
	@Test
	public void retrieveTodosRelatedToSpringTest_usingMock() {
		
		// Dynamically stubbing a method
		// Making the mock return a specific value on a specific method call.
		
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
		when(todoServiceMock.retrieveTodos("John")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("John");
		
		assertEquals(4, filteredTodos.size());
	}
	
	@Test
	public void retrieveTodosRelatedToSpringTest_returnEmptyList() {
		
		// Dynamically stubbing a method
		// Making the mock return a specific value on a specific method call.
		
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Alex")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Alex");
		
		assertEquals(0, filteredTodos.size());
	}

}
