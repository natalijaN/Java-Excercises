import java.util.Hashtable;

public class ComisBooksMain {

	public static void main(String[] args) {
		
		Hashtable<String, Float> table = new Hashtable<String, Float>();
		
		float price1 = 1.5F;
		table.put("very fine", price1);
		
		float price2 = 13.3F;
		table.put("fine", price2);
		
		float price3 = 10.6F;
		table.put("fine", price3);	
		
		Comic[] comicBooks = new Comic[1];
		
		comicBooks[0] = new Comic("Amazing Spider-Man", "very fine", 9240.00F);
		comicBooks[0].setPrice((Float)table.get(comicBooks[0].getCondition()));
		
		 for (int i = 0; i < comicBooks.length; i++) {
	            System.out.println("Title: " + comicBooks[i].getTitle());
	            System.out.println("Condition: " + comicBooks[i].getCondition());
	            System.out.println("Price: $" + comicBooks[i].getPrice() + "\n");
	        }
	}

}
