public class InvestmentCalculator {
	private double investment;
	private double increasmentFirstYear;
	private double lostInSecondYear;
	private double increasmentThirdYear;
	
	private static final double VALUE_FIRST_YEAR = 0.40;
	private static final double VALUE_SECOND_YEAR = 1500;
	private static final double VALUE_THIRD_YEAR = 0.12;
	
	public InvestmentCalculator() {
		this.increasmentFirstYear = VALUE_FIRST_YEAR;
		this.lostInSecondYear = VALUE_SECOND_YEAR;
		this.increasmentThirdYear = VALUE_THIRD_YEAR;
	}

	public double getInvesment() {
		return investment;
	}

	public void setInvesment(double investment) {
		this.investment = investment;
	}

	public double investmentInFirstYear() {
		return this.investment = this.investment + this.investment * increasmentFirstYear;
	}

	public double investmentInSecondYear() {
		return this.investment = investmentInFirstYear() - this.lostInSecondYear;
	}
	
	public double investmentInThirdYear() {
		return this.investment = investmentInSecondYear() + this.investment * increasmentThirdYear;
	}
	
}
