package org.stack;
public class Stack<T> implements IStack<T> {

	final int DEFAULT_SIZE = 3;
	int length = 0;
	Node<T> top = null;

	// Push
	public void push(T item) {
		if (length >= DEFAULT_SIZE) {
			grow(1);
			Node<T> node = new Node<T>(item);
			if (top == null) {
				top = node;
			} else {
				node.next = top;
				top = node;
			}
		} else {
			Node<T> node = new Node<T>(item);
			if (top == null) {
				top = node;
			} else {
				node.next = top;
				top = node;
			}
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
		return result;
	}

	public int size() {
		return length;
	}

	// Peek
	public T peek() {
		T result = null;
		if (top != null) {
			result = top.data;
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
		int numOfElementsInStack = 0;
		Node<T> tempNode = null;
		if (top != null) {
			for (tempNode = top; tempNode != null; tempNode = tempNode.next) {
				numOfElementsInStack++;
			}
		}
		if (numOfElementsInStack < length) {
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
}