package com.testme.business.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.testme.data.api.TodoService;

/*
 * Behavior Driven Development - BDD
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
				 "Learn Spring Boot", 
				 "Learn Data Structures",
				 "Learn Spring MVC",
				 "Learn Java",
				 "Learn HTML",
				 "Learn CSS",
				 "Build 40 HTML/CSS projects",
				 "Build 4 Spring Boot projects",
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
	
	/*
	 * Side Effects
	 * 
	 * Below are examples of how to check if and how many times the deleteTodo 
	 * is called. To verify method calls on a mock is also called Side Effects.
	 * 
	 * When writing a lot of unit tests, some times there won't be any return values.
	 * Some methods naturally won't return anything >void<. When methods don't return 
	 * anything back, the unit test can check for Side Effect on the method 
	 * 
	 * Note:
	 * Side Effects are the calls on the method of a mock.
	 */
	@Test
	public void deleteTodoFromTodos_usingBDD_usingVerify() {
		// Give - setup
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Computer Science", 
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
		
		given(todoServiceMock.retrieveTodos("Danyel")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	
		// When - actual method call
		todoBusinessImpl.deleteTodoFromTodos("Danyel");
		
		// Then - asserts
		// ==> Verifying that a method is called n number of times: times(n)
		verify(todoServiceMock, times(1)).deleteTodo("Learn Algorithms");
		
		// ==> Verifying that a method is called at least once: atLeastOnce()
		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn Algorithms");
		
		// ==> Verifying that a method is called at least n number of times: atLeast()
		verify(todoServiceMock, atLeast(1)).deleteTodo("Learn Algorithms");
		
		// ==> Verifying that a method is not called: never()
		verify(todoServiceMock, never()).deleteTodo("Learn Spring Boot");
	}
	/*
	 * Side Effects - Alternative syntax
	 * 
	 * The method below also checks methods' side effects using alternative syntax.
	 */
	@Test
	public void deleteTodoFromTodos_usingBDD_usingThenShould() {
		// Give - setup
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Computer Science", 
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
		
		given(todoServiceMock.retrieveTodos("Danyel")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	
		// When - actual method call
		todoBusinessImpl.deleteTodoFromTodos("Danyel");
		
		// Then - asserts
		// ==> Verifying that a method is called n number of times: times(n)
		then(todoServiceMock).should(times(1)).deleteTodo("Learn Algorithms");
		
		// ==> Verifying that a method is called at least once: atLeastOnce()
		then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn Algorithms");
		
		// ==> Verifying that a method is called at least n number of times: atLeast()
		then(todoServiceMock).should(atLeast(1)).deleteTodo("Learn Algorithms");
		
		// ==> Verifying that a method is not called: never()
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring Boot");
	}

}
