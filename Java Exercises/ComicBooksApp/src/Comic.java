
public class Comic {
	
	private String title;
	private String condition;
	private float price;
	
	public Comic(String title, String condition, float basePrice) {
		this.title = title;
		this.condition = condition;
		this.price = basePrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = this.price * price;
	}

}
