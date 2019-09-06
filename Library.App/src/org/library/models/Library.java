package org.library.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.library.db.IDbContract;
import org.library.db.PostgresHelper;

public class Library {
	private List<User> users = new ArrayList<User>();
	private List<Book> books = new ArrayList<Book>();

	public Library() throws SQLException {
		PostgresHelper client = setConnectionToDb();
		getUsers(client);
		getBooks(client);
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
				System.out.println("DB connected");
				System.out.println();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	private void getBooks(PostgresHelper client) throws SQLException {
		ResultSet books = client.execQuery("SELECT * FROM books");
		while (books.next()) {
			Book book = new Book();
			book.setId(books.getInt(1));
			book.setTitle(books.getString(2));
			book.setAuthor(books.getString(3));
			book.setNumberOfCopies(books.getInt(4));
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
}
