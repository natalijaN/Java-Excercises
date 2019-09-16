package dao;

import java.sql.SQLException;
import java.util.List;
import entities.Book;

public interface IBookDao {
	List<Book> getAllBooks() throws SQLException;
	Book getBookByISBN(long isbn) throws SQLException;
}
