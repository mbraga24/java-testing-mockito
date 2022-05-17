package com.testme.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {
	/*
	 * Spy
	 * 
	 * In a scenario where the functionality of the ArrayList class
	 * needs to be retained and override a specific functionality in
	 * the class, that's when the tester implements - spy().
	 * 
	 * With spy it's the same as creating a real ArrayList.
	 */
	@Test 
	public void testSpy() {
		List arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("value one");
		assertEquals(1, arrayListSpy.size());
	}
	
}
