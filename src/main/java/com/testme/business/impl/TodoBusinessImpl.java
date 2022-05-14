package com.testme.business.impl;

import java.util.ArrayList;
import java.util.List;

import com.testme.data.api.TodoService;


/*
 * TodoBusinessImpl contains the business logic to be tested.
 * 
 * 
 * TodoBusinessImpl - SUT (System Under Test)
 * TodoService - DEPENDENCY 
 * 
 */
public class TodoBusinessImpl {

	/*
	 * TodoService is a dependency of TodoBusinessImpl.
	 */
	private TodoService todoService;

	/*
	 * The constructor enables to test TodoBusinessImpl with any
	 * implementation of TodoService.
	 * 
	 */
	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	/*
	 * Method to write tests for.
	 * 
	 * The method depends on the TodoService to get the list of the users 
	 * to operate the logic.
	 */
	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		
		for (String todo:allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodoFromUserTodos(String user, String deleteTodo) {
		List<String> todos = todoService.retrieveTodos(user);
		
		for (String todo:todos) {
			if (todo.equals(deleteTodo)) {
				todoService.deleteTodo(deleteTodo);
			}
		}
	}
	
	public void deleteAllTodosContainingKeywordFromTodos(String user, String keyWord) {
		List<String> todos = todoService.retrieveTodos(user);
		
		for (String todo:todos) {
			if (!todo.contains(keyWord)) {
				todoService.deleteTodo(todo);
			}
		}
	}
	
}
