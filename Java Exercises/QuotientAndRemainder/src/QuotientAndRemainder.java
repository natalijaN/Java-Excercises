
public class QuotientAndRemainder {

	private int numberOne;
	private int numberTwo;
	
	public int getNumberOne() {
		return numberOne;
	}
	
	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}
	
	public int getNumberTwo() {
		return numberTwo;
	}
	
	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}
	
	public float quotent() {
		return this.numberOne / this.numberTwo;
	}
	
	public float remainder() {
		return this.numberOne % this.numberTwo;
	}
}
