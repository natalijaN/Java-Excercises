
public class MainApplication {

	public static void main(String[] args) {
		Person bob = new Person();
		bob.setFirstName("bob");
		bob.setLastName("bobsky");
		
		Person john = new Person();
		john = bob;
		
		System.out.println(bob.toString());
		System.out.println(john.toString());
	}
}