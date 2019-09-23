
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
			throw new IllegalArgumentException("Invalid input provided");
		}
	}

	public String getZipCode() {
		return zipCode;
	}
}
