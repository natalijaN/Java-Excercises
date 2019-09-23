public class RangeLister {
	int[] listerRange(int upper, int lower) {
		int[] rangeList = new int[(upper - lower) + 1];
		for (int i = 0; i < rangeList.length; i++) {
			rangeList[i] = lower++;
		}
		return rangeList;
	}
	
	public static void main(String[] args) {

		RangeLister range = new RangeLister();
		
		int[] myArray = range.listerRange(13, 3);
		for (int i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]);
		}
	}
}
