package org.library.models;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private int borrowedBooks;
	private List<Book> books;

	public User() {
		setBooks(new ArrayList<>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getborrowedBooks() {
		return borrowedBooks;
	}

	public void setborrowedBooks(int borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void borrowBook(Book book) {
		if (books.size() == 3) {
			System.out.println("User can not borrow more than 3 books.");
		}
		books.add(book);
	}

	@Override
	public String toString() {
		return "First name: " + getFirstName() + "\nLast name: " + 
				getFirstName() + "\nNumber of books borrowed: " + getborrowedBooks();
	}
}
