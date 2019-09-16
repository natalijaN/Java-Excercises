package dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IBookDao;
import entities.Book;

public class PostgreBookDao implements IBookDao {

	public List<Book> getAllBooks() throws SQLException {
		Connection connection = DatabaseConnection.createConnection();
		try {
			List<Book> books = new ArrayList<Book>();
			ResultSet booksResultSet = connection.createStatement().executeQuery("SELECT * FROM books");
			while (booksResultSet.next()) {
				Book book = new Book();
				book.setId(booksResultSet.getInt(1));
				book.setTitle(booksResultSet.getString(2));
				book.setAuthor(booksResultSet.getString(3));
				book.setNumberOfCopies(booksResultSet.getInt(4));
				book.setAvailable(booksResultSet.getInt(5));
				book.setIsbn(booksResultSet.getLong(6));
				books.add(book);	
			}
			return books;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		connection.close();
		return null;
	}

	public Book getBookByISBN(long isbn) throws SQLException {
		Connection connection = DatabaseConnection.createConnection();
		try {
			Book book = new Book();
			ResultSet bookResultSet = connection.createStatement()
					.executeQuery(String.format("SELECT * FROM books WHERE isbn='%d'", isbn));
			while (bookResultSet.next()) {
				book.setId(bookResultSet.getInt(1));
				book.setTitle(bookResultSet.getString(2));
				book.setAuthor(bookResultSet.getString(3));
				book.setNumberOfCopies(bookResultSet.getInt(4));
				book.setAvailable(bookResultSet.getInt(5));
				book.setIsbn(bookResultSet.getLong(6));
				return book;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		connection.close();
		return null;
	}
}
