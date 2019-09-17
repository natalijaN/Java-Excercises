import java.util.StringTokenizer;

public class TokenTester {

	public static void main(String[] args) {
		StringTokenizer st1 = new StringTokenizer("Hello Geeks How are you", " ", false);
		
		System.out.println(st1.countTokens());

		while (st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
	}
}
