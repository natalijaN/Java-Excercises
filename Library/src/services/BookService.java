package services;

import java.sql.SQLException;
import java.util.List;

import dao.IBookDao;
import entities.Book;

public class BookService implements IBookDao {

	IBookDao bookDao;
	
	public BookService(IBookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public List<Book> getAllBooks() throws SQLException {
		return bookDao.getAllBooks();
	}

	public Book getBookByISBN(long isbn) throws SQLException {
		return bookDao.getBookByISBN(isbn);
	}
}
