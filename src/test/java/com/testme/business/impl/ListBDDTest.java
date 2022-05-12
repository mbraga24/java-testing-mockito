package com.testme.business.impl;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;

public class ListBDDTest {

	@Test
	public void mockListSize_ReturnSize() {
		// given - setup
		List listMock = mock(List.class);
		given(listMock.size()).willReturn(2);
		
		// when - actual method call
		int expectedSize = listMock.size();
		
		// then - asserts
		assertThat(expectedSize, is(2));
	}
	
	@Test
	public void mockListGetWithArgumentMatcher() {
		// given - setup
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("BDD in action!");
		
		// when - actual method
		String expectedValue = listMock.get(0);
		
		// then - asserts
		assertThat(expectedValue, is("BDD in action!"));
	}
	
	/*
	 * Add expected property syntax
	 * .thenThrow()
	 */
	@Test(expected = RuntimeException.class)
	public void mockList_GetWithArgumentMatcherThrowException() {
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willThrow(new RuntimeException("An error occurred!"));
	
		listMock.get(0);
	}
	
	/*
	 * Add expected property syntax
	 * .thenThrow()
	 */
	@Test(expected = RuntimeException.class)
	public void mockList_GetMixUpArgumentMatcherAndWholeNumberThrowException() {
		List<String> listMock = mock(List.class);
		given(listMock.subList(anyInt(), 5)).willThrow(new RuntimeException("An error occurred!"));
		
		listMock.get(0);
	}

}
