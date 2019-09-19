//Create a class with instance variables for height, weight, and depth, making each an integer. 
//Create a Java application that uses your new class to create two instances to which it then 
//sets values for the attributes, and finally displays the values of the object that has the 
//greater volume.

public class MainApplication {

	public static void main(String[] args) {
		
		BoxVolume firstBox = new BoxVolume(4,6,5);
		BoxVolume secondBox = new BoxVolume(3,7,4);
		
		int volumeOfFirstBox = firstBox.Volume();
		System.out.println("Volume of the first box: " + volumeOfFirstBox);
		int volumeOfSecondBox = secondBox.Volume();
		System.out.println("Volume of the second box: " + volumeOfSecondBox);
		
		int maxVolume = Math.max(volumeOfFirstBox, volumeOfSecondBox);
		
		if(volumeOfFirstBox > volumeOfSecondBox) {
			System.out.println("Max volume is: " + maxVolume);
			System.out.println("Height: " + firstBox.getHeight() + "; Weight: " + firstBox.getWeight() + "; Depth: " + firstBox.getDepth());
		} else if (volumeOfFirstBox < volumeOfSecondBox) {
			System.out.println(secondBox.getHeight() + " " + secondBox.getWeight() + " " + secondBox.getDepth());
		} else {
			System.out.println("Same volume");
		}	
	}
}
