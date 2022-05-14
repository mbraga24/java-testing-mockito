package com.testme.data.api;

import java.util.List;

/*
 * TodoService can be communicating to a database or an external 
 * interface.
 */
public interface TodoService {
	public List<String> retrieveTodos(String user);
	
	public void deleteTodo(String todo);
}
