package org.stack;

import org.stack.exceptions.EmptyStack;
import org.stack.exceptions.ListTooLargeException;

public class App {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(4);

		System.out.println();
		System.out.println("Stack Length: " + stack.size());

		System.out.println("Is stack empty: " + stack.isEmpty());
		System.out.println("Is stack full: " + stack.isFull());
		System.out.println();

		try {
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(4);
			stack.push(5);
		} catch (ListTooLargeException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	
		System.out.println();
		System.out.println(stack);
		System.out.println("Stack Length: " + stack.size());
		System.out.println("Is stack full: " + stack.isFull());
		System.out.println();

		try {
			stack.pop();
		} catch (EmptyStack ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println("Stack Length: " + stack.size());
		System.out.println();


		try {
			stack.peek();
		} catch (EmptyStack ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Stack Length: " + stack.size());
		System.out.println();

		stack.grow(3);
		System.out.println("Grow length by 3");
		System.out.println(stack);
		System.out.println("Stack Length: " + stack.size());
		System.out.println();

		System.out.println("Is stack empty: " + stack.isEmpty());
		System.out.println("Is stack full: " + stack.isFull());
		System.out.println();

		System.out.println(stack);
		System.out.println("Stack Length: " + stack.size());
		System.out.println();

		IStack<String> stackString = new Stack<String>();

		try {
			stackString.push("Natalija");
			stackString.push("Nikolova");
			stackString.push("Negotino");
			stackString.push("Macedonia");
		} catch (ListTooLargeException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println();
		System.out.println(stackString);
		System.out.println("Stack Length: " + stackString.size());
	}
}
