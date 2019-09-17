
//Create a program that calculates how much a $14,000 investment would be worth if it 
//increased in value by 40% during the first year, 
//lost $1,500 in value the second year, and 
//increased 12% in the third year

public class MainApplication {

	public static void main(String[] args) {

		InvestmentCalculator investment = new InvestmentCalculator();
		investment.setInvestment(14000);
		
		System.out.println(String.format("Investment in the third year is %.2f$.", investment.investmentInThirdYear()));
	}
}