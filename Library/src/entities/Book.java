package entities;


public class Book {
	private int id;
	private String title;
	private String author;
	private long isbn;
	private int numberOfCopies;
	private int available;
	
	public Book() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	public void setBorrowedCounter() {
		this.numberOfCopies = this.numberOfCopies - 1;
	}
	
	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	public String reviewBook() {
		return "Book title: " + getTitle() + "\nBook author: " +  getAuthor() + "\nBook isbn: " + getIsbn();
	}
	
	@Override
	public String toString() {
		return "Book title: " + getTitle() + "\nBook author: " +  getAuthor() + "\nBook isbn: " + getIsbn() + "\nAvailable: " + getAvailable();
	}

}
