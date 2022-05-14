package com.testme.business.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.testme.data.api.TodoService;

/*
 * @Rule
 * 
 * It's not possible to use two JUnit runners in the same class. JUnit introduced a concept
 * called Rules. Instead of using runners, a tester will use an annotation called @Rule. 
 * 
 * - Similar to a runner, a rule is ran before and after a test. 
 * - All rules must be define as public. JUnit needs to be able to access that rule.
 * - A test can define multiple rules.
 * - Rules can do all the set up for the test class.
 * - Each rule is independent from each other.
 * 
 * JUnit is moving away from Runners and moving more towards rules because rules make the tests
 * more flexible.
 * 
 */
public class TodoBusinessImplMockitoRules {
	
	/*
	 * All rules must be define as public. JUnit needs to be able to access that rule.
	 */
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService todoServiceMock; // => instead of TodoService todoServiceMock = mock(TodoService.class);
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl; // => instead of TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

	// Declare Argument Captor
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor; // => instead of ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

	@Test
	public void retrieveTodosRelatedToSpringTest_usingBDD() {
		
		// Given - setup 
		
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
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("John");
		
		// Then - asserts
		assertThat(filteredTodos.size(), is(4));
		// ===> .is() method is part of the hamcrest matchers
	}
	
	@Test
	public void retrieveTodosRelatedToSpringTest_returnEmptyList() {
		
		// Given - setup
		
		List<String> todos = Arrays.asList();
		given(todoServiceMock.retrieveTodos("Alex")).willReturn(todos);
		
		// When - actual method call
		
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
	public void deleteTodoFromUserTodos_usingBDD_usingVerify() {
		// Give - setup
		
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
	
		// When - actual method call
		todoBusinessImpl.deleteTodoFromUserTodos("Danyel", "Learn CSS");
		
		// Then - asserts
		// ==> Verifying that a method is called n number of times: times(n)
		verify(todoServiceMock, times(1)).deleteTodo("Learn CSS");
		
		// ==> Verifying that a method is called at least once: atLeastOnce()
		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn CSS");
		
		// ==> Verifying that a method is called at least n number of times: atLeast()
		verify(todoServiceMock, atLeast(1)).deleteTodo("Learn CSS");
		
		// ==> Verifying that a method is not called: never()
		verify(todoServiceMock, never()).deleteTodo("Learn Spring Boot");
	}
	
	/*
	 * Side Effects - Alternative syntax
	 * 
	 * The method below also checks methods' side effects using alternative syntax.
	 */
	@Test
	public void deleteTodoFromUserTodos_usingBDD_usingThenShould() {
		// Give - setup
		
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
	
		// When - actual method call
		todoBusinessImpl.deleteTodoFromUserTodos("Danyel", "Learn CSS");
		
		// Then - asserts
		// ==> Verifying that a method is called n number of times: times(n)
		then(todoServiceMock).should(times(1)).deleteTodo("Learn CSS");
		
		// ==> Verifying that a method is called at least once: atLeastOnce()
		then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn CSS");
		
		// ==> Verifying that a method is called at least n number of times: atLeast()
		then(todoServiceMock).should(atLeast(1)).deleteTodo("Learn CSS");
		
		// ==> Verifying that a method is not called: never()
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring Boot");
	}
	
	/*
	 * Argument Capture
	 * 
	 * Argument capture is useful when tester wants to check the values that are passed
	 * to a mock method. This is especially useful if the argument is a complex object.
	 * 
	 */
	@Test
	public void deleteAllNonSpringTodos_usingBDD_argumentCaptor() {
		

		
		// Give - setup
		
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
	
		// When - actual method call
		todoBusinessImpl.deleteAllTodosContainingKeywordFromTodos("Danyel", "Spring");
		
		// Then - asserts

		// Define Argument Captor on specific method call 
		then(todoServiceMock).should(times(7)).deleteTodo(stringArgumentCaptor.capture()); // wants 7
		
		// Capture the argument
		assertThat(stringArgumentCaptor.getAllValues().size(), is(7)); // expects 7 
	}


}
