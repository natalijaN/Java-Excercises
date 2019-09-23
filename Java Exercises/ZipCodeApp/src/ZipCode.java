//Create a ZipCode class that uses access control to ensure that its zipCode instance variable 
//always has a five or nine-digit value.

public class ZipCode {
	private String zipCode;
	private String checkZipCode = "^[0-9]*";
	
	public ZipCode(String code) {
		if(code.length() == 5 || code.length() == 9) {
			if(code.matches(checkZipCode)) {
				zipCode = code;
				System.out.println("Success");
			}
		} else {
			System.out.println("Not valid zip code");
		}
	}

	public String getZipCode() {
		return zipCode;
	}
}
