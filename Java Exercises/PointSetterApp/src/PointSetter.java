import java.awt.Point;

public class PointSetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point location = new Point();
		location.x = 3;
		location.y = 5;
		
		System.out.println("X equals: " + location.getX());
		System.out.println("Y equals: " + location.getY());
		
		Point secondLocation = new Point(5, 17);
		
		System.out.println("X equals: " + secondLocation.getX());
		System.out.println("Y equals: " + secondLocation.getY());
	}

}
