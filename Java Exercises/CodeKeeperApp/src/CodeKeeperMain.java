import java.util.Iterator;
import java.util.Vector;

public class CodeKeeperMain {
	
	private String[] codes = new String[] {"one", "four", "five"};
	
	Vector<String> list;

	public CodeKeeperMain(String[] userCodes) {
		list = new Vector<String>();
		
		for (int i = 0; i < userCodes.length; i++) {
			addCode(userCodes[i]);
		}
		
		for (int i = 0; i < codes.length; i++) {
			addCode(codes[i]);
		}
		
	}

	private void addCode(String code) {
		if(!list.contains(code)) {
			list.add(code);
		}
	}
	
	public void displayVector() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public void displayVectorWithIterator() {
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String element = (String) iterator.next();
			System.out.println(element);	
		}
	}
	

	public static void main(String[] args) {
		String[] userCodes = new String[] {"one", "two", "three"};
		
		CodeKeeperMain codeKeeper = new CodeKeeperMain(userCodes);
		codeKeeper.displayVector();
		System.out.println();
		System.out.println("----------------------");
		System.out.println();
		codeKeeper.displayVectorWithIterator();
	}

}
