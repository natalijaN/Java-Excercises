package org.library.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	public int borrowedBooks;
	private List<Book> books = new ArrayList<>();

	public User() throws SQLException {
	}

	public User(int id, String firstName, String lastName, int borrowedBooks) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.borrowedBooks = borrowedBooks;
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
		return books.size();
	}

	public void setborrowedBooks(int borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(Book book) {
		this.books.add(book);
	}

	@Override
	public String toString() {
		return "First name: " + getFirstName() + "\nLast name: " + getLastName() + "\nNumber of books borrowed: "
				+ getborrowedBooks();
	}

}
