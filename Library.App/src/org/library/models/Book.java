package org.library.models;

public class Book {
	private int id;
	private String title;
	private String author;
	private int numberOfCopies;
	
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
	
	@Override
	public String toString() {
		return "Book title: " + getTitle() + "\nBook author: " +  getAuthor() +
				"\nNumber of book copies: " + getNumberOfCopies();
	}

}
