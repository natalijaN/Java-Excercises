package org.stack;

public interface IStack<T> {
	void push(T item);
	T pop();
	int size();
	T peek();
	void grow(int growSize);
	boolean isEmpty();
	boolean isFull();
}
