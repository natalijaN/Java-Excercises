
public class BoxVolume {
	private int height;
	private int weight;
	private int depth;
	
	public BoxVolume(int height, int weight, int depth)
	{
		this.height = height;
		this.weight = weight;
		this.depth = depth;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int Volume() {
		return height * weight * depth;
	}
}
