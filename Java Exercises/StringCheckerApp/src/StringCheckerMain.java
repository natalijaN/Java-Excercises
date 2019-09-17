
public class StringCheckerMain {

	public static void main(String[] args) {
		String text = "Methods are invoked using the dot notation";
		
		System.out.println("This is my string: " + text);
		System.out.println("The length of the string is: " + text.length());
		System.out.println("The index of dot is: " + text.indexOf("dot"));
		System.out.println("The string in Upper case look like this: " + text.toUpperCase());
	}
}
