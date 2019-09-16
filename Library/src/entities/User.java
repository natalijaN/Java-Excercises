package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private List<Book> books = new ArrayList<>();

	public User() {}

	public User(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Book> getBooks() {
		return this.books;
	}

	public void addBooks(Book book) {		
		this.books.add(book);
	}

	public String toString() {
		return "First name: " + getFirstName() + "\nLast name: " + getLastName()
		+ "\nNumber of books borrowed: " + books.size();
	}
}