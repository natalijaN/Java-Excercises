import java.io.File;
import java.util.Scanner;
import java.util.*;

public class WordCounter
{  
    public static void main(String[] args) throws Exception  { 
		File myFile = new File("data.txt");
		Scanner input = new Scanner(myFile);
		input.useDelimiter("(\\n)| |,");
		
		List<String> wordsList = new ArrayList<String>();
		
		while(input.hasNext()){
			String word = input.next();
			wordsList.add(word);
		}
		
		wordsList.forEach(w -> System.out.println(w));
		System.out.println(String.format("Number of words in the file: %d", wordsList.size()));
		long numOfUniqueWords = wordsList.stream().distinct().count();
		System.out.println(String.format("Number of unique words in the file: %d", numOfUniqueWords));
    }
}