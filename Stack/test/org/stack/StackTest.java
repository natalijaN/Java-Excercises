package org.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.stack.exceptions.EmptyStackException;

public class StackTest {

	@Test
	public void push_StackWithoutElement_setItemAtTop() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		final int expected = 7;
		final int actual = stack.peek();
		assertEquals(expected, actual);
	}

	@Test
	public void push_StackWithElement_setItemAtTop() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		stack.push(9);
		final int expected = 9;
		final int actual = stack.peek();
		assertEquals(expected, actual);
	}

	@Test
	public void pop_StackWithOneElement_ReturnsElement() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		final int expected = 7;
		final int actual = stack.pop();
		assertEquals(expected, actual);
	}

	@Test
	public void pop_StackWithOutElement_ReturnsNull() {
		Stack<Integer> stack = new Stack<Integer>();
		assertThrows(EmptyStackException.class, () -> {
			stack.pop();
		});
	}

	@Test
	public void size_EmptyStack_returnLength() {
		Stack<Integer> stack = new Stack<Integer>();
		int length = 0;
		assertEquals(length, stack.size());
	}

	@Test
	public void peek_StackWithElements_returnFirstElement() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		final int expected = 7;
		final int actual = stack.peek();
		assertEquals(expected, actual);
	}

	@Test
	public void peek_StackWithoutElements_returnNull() {
		Stack<Integer> stack = new Stack<Integer>();
		assertThrows(EmptyStackException.class, () -> {
			stack.peek();
		});
	}

	@Test
	public void grow_GrowLength_returnLengthPlusGrowLength() {
		Stack<Integer> stack = new Stack<Integer>();
		int growSize = 2;
		int expectedLength = 2;
		stack.grow(growSize);
		int actualLength = stack.size();
		assertEquals(expectedLength, actualLength);
	}

	@Test
	public void isEmpty_StackWithoutElements_returnTrue() {
		Stack<Integer> stack = new Stack<Integer>();
		final boolean expected = stack.getTop() == null && stack.getLength() == 0;
		assertEquals(expected, stack.isEmpty());
	}

	@Test
	public void isEmpty_StackWithoutElements_returnTrue2() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.setTop(null);
		assertTrue(stack.isEmpty());
	}

	@Test
	public void isEmpty_StackWithoutElements_returnTrue3() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.setLength(0);
		assertTrue(stack.isEmpty());
	}

	@Test
	public void isEmpty_StackWithElements_returnFalse() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void isFull_EmptyStack_returnFalse() {
		Stack<Integer> stack = new Stack<Integer>();
		assertFalse(stack.isFull());
	}

	@Test
	public void isFull_StackWithThreeElements_returnTrue() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		stack.push(7);
		stack.push(7);
		assertTrue(stack.isFull());
	}

	@Test
	public void toString_returnOverrideToString() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		final String expected = "[ 7 ]";
		final String actual = stack.toString();
		assertEquals(expected, actual);
	}
}
