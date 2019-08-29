import java.io.File;
import java.util.Scanner;
import java.util.*;

public class CountWordFile   
{  
    public static void main(String[] args) throws Exception  { 
		File myFile = new File("data.txt");
		Scanner input = new Scanner(myFile);
		input.useDelimiter("(\\n)| |,");
		
		ArrayList<String> list = new ArrayList<String>();
		while(input.hasNext()){
			String word = input.next();
			list.add(word);
		}
		list.forEach(w -> System.out.println(w));
		System.out.println(String.format("Number of words in the file: %d", list.size()));
		long numOfUniqueWords = list.stream().distinct().count();
		System.out.println(String.format("Number of unique words in the file: %d", numOfUniqueWords));
    }
}