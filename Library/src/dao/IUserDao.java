package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Book;
import entities.User;

public interface IUserDao {
	List<User> getAllUsers() throws SQLException;
	User getUserByPassword(String password) throws SQLException;
	List<Book> getUserBooks(User user) throws SQLException;
}
