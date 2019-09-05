package org.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.stack.exceptions.EmptyStackException;
import org.stack.exceptions.StackTooLargeException;

public class StackTest {

	@Test
	public void push_LessElementsThanDefaultSize_setItemAtTop() {
		Stack<Integer> stack = new Stack<Integer>(3);
		stack.push(7);
		final int expected = 7;
		final int actual = stack.peek();
		assertEquals(expected, actual);
	}

	@Test
	public void push_MoreElementsThanDefaultSize_throwsException() {
		Stack<Integer> stack = new Stack<Integer>(3);
		stack.push(7);
		stack.push(7);
		stack.push(7);
		assertThrows(StackTooLargeException.class, () -> {
			stack.push(7);
		});
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
	public void pop_StackWithOutElement_throwsException() {
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
	public void peek_StackWithoutElements_throwsException() {
		Stack<Integer> stack = new Stack<Integer>();
		assertThrows(EmptyStackException.class, () -> {
			stack.peek();
		});
	}

	@Test
	public void grow_GrowLength_returnLengthPlusGrowLength() {
		Stack<Integer> stack = new Stack<Integer>();
		final int growSize = 2;
		final int expectedLength = 2;
		stack.grow(growSize);
		final int actualLength = stack.size();
		assertEquals(expectedLength, actualLength);
	}

	@Test
	public void isEmpty_StackWithoutElements_returnTrue() {
		Stack<Integer> stack = new Stack<Integer>();
		final boolean expected = stack.getTop() == null && stack.getLength() == 0;
		assertEquals(expected, stack.isEmpty());
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
	public void isFull_NumOfElementsSameAsDefaultSize_returnTrue() {
		Stack<Integer> stack = new Stack<Integer>(3);
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
