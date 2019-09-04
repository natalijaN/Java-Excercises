package org.stack;

public class App {

	public static void main(String[] args) {
		IStack<Integer> stack = new Stack<Integer>();

		System.out.println();
		System.out.println("Stack Length: " + stack.size());

		System.out.println("Is stack empty: " + stack.isEmpty());
		System.out.println("Is stack full: " + stack.isFull());
		System.out.println();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println(stack);
		System.out.println("Stack Length: " + stack.size());
		System.out.println("Is stack full: " + stack.isFull());
		System.out.println();

		System.out.println("Pop element: " + stack.pop());
		System.out.println("Stack Length: " + stack.size());
		System.out.println();

		System.out.println("Peeked element: " + stack.peek());
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
		stackString.push("Natalija");
		stackString.push("Nikolova");
		stackString.push("Negotino");
		
		System.out.println(stackString);
		
		stackString.push("Macedonia");
		
		System.out.println(stackString);
		System.out.println("Stack Length: " + stackString.size());				
	}
}
















