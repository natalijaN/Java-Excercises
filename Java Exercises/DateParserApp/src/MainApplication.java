//Create a program that turns a birthday in MM/DD/YYYY format (such as 12/04/2007) into 
//three individual strings which it then displays.

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class MainApplication {

	public static void main(String[] args) {
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("08/08/1994");  
	    String strDate= formatter.format(date);  
	    System.out.println(strDate);  
	    	    
	    StringTokenizer birthday = new StringTokenizer(strDate, "/");
	    	  
		System.out.println("Day: "+birthday.nextToken());
		System.out.println("Month: "+birthday.nextToken());
		System.out.println("Year: "+birthday.nextToken());
	}

}
