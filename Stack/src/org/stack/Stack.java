package org.stack;

import org.stack.exceptions.EmptyStackException;
import org.stack.exceptions.ListTooLargeException;

public class Stack<T> implements IStack<T> {

	private int DEFAULT_SIZE;
	private int length = 0;
	private Node<T> top = null;

	public Stack() {
		this.DEFAULT_SIZE = 3;
	}

	public Stack(int DEFAULT_SIZE) {
		this.DEFAULT_SIZE = DEFAULT_SIZE;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Node<T> getTop() {
		return top;
	}

	public void setTop(Node<T> top) {
		this.top = top;
	}

	// Push
	public void push(T item) {
		if (length >= DEFAULT_SIZE) {
			throw new ListTooLargeException(String.format("Stack can't exceed more than %d items!", this.DEFAULT_SIZE));
		} else {
			createNode(item);
			length++;
		}
	}

	// Pop
	public T pop() {
		T result = null;
		if (top != null) {
			result = top.data;
			top = top.next;
			length--;
		}
		if (result == null) {
			throw new EmptyStackException("Can not pop element from empty stack!");
		}
		return result;
	}

	// size
	public int size() {
		return length;
	}

	// Peek
	public T peek() {
		T result = null;
		if (top != null) {
			result = top.data;
		}
		if (result == null) {
			throw new EmptyStackException("Can not peek element from empty stack!");
		}
		return result;
	}

	// Grow
	public void grow(int growSize) {
		length += growSize;
	}

	// isEmpty
	public boolean isEmpty() {
		if (top == null && length == 0) {
			return true;
		}
		return false;
	}

	// isFull
	public boolean isFull() {
		if (length == DEFAULT_SIZE) {
			return true;
		}
		int numOfElementsInStack = numberOfElementsInStack();
		if (numOfElementsInStack <= length) {
			return false;
		}
		return true;
	}

	// Print stack contains
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node<T> tempNode = null;
		result.append("[ ");
		if (top != null) {
			for (tempNode = top; tempNode != null; tempNode = tempNode.next) {
				result.append(tempNode.data + " ");
			}
		}
		result.append("]");
		return result.toString();
	}

	private Node<T> createNode(T item) {
		Node<T> node = new Node<T>(item);
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
		return node;
	}

	private int numberOfElementsInStack() {
		int numOfElementsInStack = 0;
		Node<T> tempNode = null;
		if (top != null) {
			for (tempNode = top; tempNode != null; tempNode = tempNode.next) {
				numOfElementsInStack++;
			}
		}
		return numOfElementsInStack;
	}
}