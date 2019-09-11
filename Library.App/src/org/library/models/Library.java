package org.library.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.library.db.IDbContract;
import org.library.db.PostgresHelper;

public class Library {
	private List<User> users = new ArrayList<User>();
	private List<Book> books = new ArrayList<Book>();

	public Library() throws SQLException {
		PostgresHelper client = setConnectionToDb();
		getData(client);
	}

	public List<Book> getAllBooks() {
		return books;
	}

	public List<User> getAllUsers() {
		return users;
	}

	private PostgresHelper setConnectionToDb() {

		PostgresHelper client = new PostgresHelper(IDbContract.HOST, IDbContract.DB_NAME, IDbContract.USERNAME,
				IDbContract.PASSWORD);

		try {
			if (client.connect()) {
				System.out.println();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	private void getData(PostgresHelper client) throws SQLException {
		getUsers(client);
		getBooks(client);
		ResultSet relations = client.execQuery("SELECT * FROM relations");

		while (relations.next()) {
			int userId = relations.getInt(1);
			Optional<User> user = this.users.stream().filter(u -> u.getId() == userId).findFirst();
			User finalUser = user.orElse(null);

			int bookId = relations.getInt(2);
			Optional<Book> book = this.books.stream().filter(u -> u.getId() == bookId).findFirst();
			Book finalBook = book.orElse(null);
			finalUser.setBooks(finalBook);
		}
		this.books.clear();
		getBooks(client);
	}

	private void getBooks(PostgresHelper client) throws SQLException {
		ResultSet books = client.execQuery("SELECT * FROM books");
		while (books.next()) {
			Book book = new Book();
			book.setId(books.getInt(1));
			book.setTitle(books.getString(2));
			book.setAuthor(books.getString(3));
			book.setNumberOfCopies(books.getInt(4));
			book.setAvailable(books.getInt(5));
			this.books.add(book);
		}
	}

	private void getUsers(PostgresHelper client) throws SQLException {
		ResultSet users = client.execQuery("SELECT * FROM users");
		while (users.next()) {
			User user = new User();
			user.setId(users.getInt(1));
			user.setFirstName(users.getString(2));
			user.setLastName(users.getString(3));
			user.setborrowedBooks(users.getInt(4));
			this.users.add(user);
		}
	}

	public void reserveBook(int userId, int bookId) {
		Optional<User> user = this.users.stream().filter(u -> u.getId() == userId).findFirst();
		User finalUser = user.orElse(null);
		
		Optional<Book> book = this.books.stream().filter(u -> u.getId() == bookId).findFirst();
		Book finalBook = book.orElse(null);

		if(finalUser.getBooks().stream().anyMatch(b -> b.getId() == finalBook.getId())) {
			System.out.println("You already have this book!");
		} else if(finalBook.getAvailable() == 0) {
			System.out.println("This book is not available!");
		} else if (finalUser.getborrowedBooks() < 3) {
			PostgresHelper client = setConnectionToDb();
			client.updateQuery(String.format("INSERT INTO relations (userid, bookid) VALUES (%d,%d);", userId, bookId));
			client.updateQuery(String.format("UPDATE users SET borrowedbooks=%d WHERE id=%d;", finalUser.getborrowedBooks() + 1, finalUser.getId()));
			client.updateQuery(String.format("UPDATE books SET available=%d WHERE id=%d;", finalBook.getAvailable() - 1, finalBook.getId()));
			System.out.println("Congratulations! You rented the book!");
		} else {
			System.out.println("Can not borrow more than 3 books!");
		}
	}

	public void returnBook(int userId, int bookId) {
		Optional<User> user = this.users.stream().filter(u -> u.getId() == userId).findFirst();
		User finalUser = user.orElse(null);
		
		Optional<Book> book = this.books.stream().filter(u -> u.getId() == bookId).findFirst();
		Book bookForReturn = book.orElse(null);
		
		PostgresHelper client = setConnectionToDb();
		client.updateQuery(String.format("DELETE FROM relations WHERE userid=%d AND bookid=%d;", userId, bookId));
		client.updateQuery(String.format("UPDATE users SET borrowedbooks=%d WHERE id=%d;", finalUser.getborrowedBooks() - 1, finalUser.getId()));
		client.updateQuery(String.format("UPDATE books SET available=%d WHERE id=%d;", bookForReturn.getAvailable() + 1, bookForReturn.getId()));
		System.out.println("Book returned to the library!");
	}
}
