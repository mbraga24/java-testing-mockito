package com.testme.mockito;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

public class HamcrestMatchersTest {

	/*
	 * List of integers
	 */

	@Test
	public void checkSizeOfListOfIntegers() {
		List<Integer> scores = Arrays.asList(85, 101, 122, 135);
			
		assertThat(scores, Matchers.hasSize(4));
	}
	
	@Test
	public void checkThePresenceOfElementsInListOfIntegers() {
		List<Integer> scores = Arrays.asList(85, 101, 122, 135);
			
		assertThat(scores, Matchers.hasItems(85, 101));
	}
	
	@Test
	public void checkIfElementsAreGreaterThan90InListOfIntegers() {
		List<Integer> scores = Arrays.asList(85, 101, 122, 135);
		
		assertThat(scores, Matchers.everyItem(Matchers.greaterThan(80)));
	}

	@Test
	public void checkIfElementsAreLessThan150InListOfIntegers() {
		List<Integer> scores = Arrays.asList(85, 101, 122, 135);
		
		assertThat(scores, Matchers.everyItem(Matchers.lessThan(150)));
	}
	
	/*
	 * Strings
	 */
	
	@Test
	public void stringIsEmpty() {
		String myString = "";
		
		assertThat(myString, Matchers.isEmptyString());
	}
	
	@Test
	public void stringIsEmptyOrNull() {
		String myString = null;
		
		assertThat(myString, Matchers.isEmptyOrNullString());
	}
	
	/*
	 * Arrays
	 */
	
	@Test
	public void checkArraySize() {
		Integer[] marks = {1, 2, 3};
		
		assertThat(marks, Matchers.arrayWithSize(3));
	}
	
	@Test
	public void checkIfArrayContainsSameValues() {
		Integer[] marks = {1, 2, 3};
		
		assertThat(marks, Matchers.arrayContaining(1, 2, 3));
	}
	
	@Test
	public void checkIfArrayContainsSameValuesInAnyOrder() {
		Integer[] marks = {1, 2, 3};
		
		assertThat(marks, Matchers.arrayContainingInAnyOrder(3, 1, 2));
	}

}
