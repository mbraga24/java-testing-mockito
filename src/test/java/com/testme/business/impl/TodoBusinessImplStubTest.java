package com.testme.business.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.testme.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	
	@Test
	public void retrieveTodosRelatedToSpringTest_usingAStub() {
		
		TodoServiceStub todoServiceStub = new TodoServiceStub();
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub); 
	
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("John");
		
		assertEquals(4, filteredTodos.size());
		
	}

}
