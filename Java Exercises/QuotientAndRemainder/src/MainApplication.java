//Write a program that displays two numbers and uses the "/" and "%" operators to display 
//the result and remainder after they are divided. Use the "\t" character escape code to 
//separate the result and remainder in your output.

public class MainApplication {

	public static void main(String[] args) {
	
	QuotientAndRemainder qr = new QuotientAndRemainder();
	qr.setNumberOne(5);
	qr.setNumberTwo(2);
	
	double quotent = qr.quotent();
	double remainder = qr.remainder();
	
	System.out.println(String.format("The quotent of %d and %d is: %.2f.\tThe remainder is: %.2f",qr.getNumberOne(), qr.getNumberTwo(), quotent, remainder));
	
	}
}
