package com.testme.business.impl;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void mockListSize_ReturnSize() {
		List listMock = mock(List.class);		
		
		when(listMock.size()).thenReturn(2);
		
		assertEquals(2, listMock.size());
		
	}
	
	@Test
	public void mockListSize_ReturnMultipleSizeValues() {
		List listMock = mock(List.class);
		
		when(listMock.size()).thenReturn(2).thenReturn(4);
		
		assertEquals(2, listMock.size());
		assertEquals(4, listMock.size());
	}
	
	@Test
	public void mockListGetWithArgumentMatcher() {
		List listMock = mock(List.class);
		
		String betterPro = "Loading programmer . . .";
		
		// Argument Matcher
		when(listMock.get(anyInt())).thenReturn(betterPro);
		
		assertEquals(betterPro, listMock.get(0));
		assertEquals(betterPro, listMock.get(1));
	}
	
	/*
	 * Add expected property syntax
	 * .thenThrow()
	 */
	@Test(expected = RuntimeException.class)
	public void mockList_GetWithArgumentMatcherThrowException() {	
		List listMock = mock(List.class);
		
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("An error occurred."));
		
		listMock.get(0);
	}
	
	/*
	 * Add expected property syntax
	 * .thenThrow()
	 */
	@Test(expected = RuntimeException.class)
	public void mockList_GetMixUpArgumentMatcherAndWholeNumberThrowException() {
		List listMock = mock(List.class);
		
		when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("An error occurred."));
	
		listMock.get(0);
	}

}
