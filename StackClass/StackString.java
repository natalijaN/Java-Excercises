public class StackString<T extends String> extends Stack<T>{
	
	   public static void main(String[] args) {
		   
        StackString<String> stack = new StackString<String>();
		
		System.out.println();
        System.out.println("Stack Length: " + stack.size());
		System.out.println("Is stack empty: " + stack.isEmpty());
		System.out.println("Is stack full: " + stack.isFull());
		System.out.println();
		
        stack.push("Natalija");
        stack.push("Nikolova");
        stack.push("Negotino");

		System.out.println(stack);
        System.out.println("Stack Length: " + stack.size());
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
	}
}