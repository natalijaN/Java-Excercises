public class InvestmentCalculator {
	private double investment;
	private double increasementFirstYear;
	private double lostInSecondYear;
	private double increasementThirdYear;
	
	public InvestmentCalculator() {
		this.increasementFirstYear =  0.40;
		this.lostInSecondYear =  1500;
		this.increasementThirdYear = 0.12;
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}

	public double investmentInFirstYear() {
		return investment = investment + investment * increasementFirstYear;
	}

	public double investmentInSecondYear() {
		return investment = investmentInFirstYear() - lostInSecondYear;
	}
	
	public double investmentInThirdYear() {
		return investment = investmentInSecondYear() + investment * increasementThirdYear;
	}
	
}
