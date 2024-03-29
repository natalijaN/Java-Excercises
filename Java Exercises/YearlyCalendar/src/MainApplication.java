//Using the countDays() method from the DayCounter application, create an application that 
//stores every date in a given year from January 1 to December 31 as Strings in an array and 
//prints it out.

public class MainApplication {

	public static void main(String[] args) {

		String date;
		int year = 1996;
		int count = 0;
		String[] calendar;
		int tempDay = 0;
		
		for(int m=1; m<=12; m++)
		{
			count+=countDays(m, year);
		}
		System.out.println("Sum of days in year: " + count);
		calendar = new String[count];
		
		int days;
		for(int month=1; month<=12; month++)
		{
			days = countDays(month, year);
			for(int day = 1; day <= days; day++) {
				date = String.format("%d/%d/%d", day, month, year);
				calendar[tempDay] = date;
				tempDay++;
			}
		}
		for (String day : calendar) {
			System.out.println(day);
		}
	}
	
	static int countDays(int month, int year)
	{
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }
                if ((year % 100 == 0) & (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;
    }

}
