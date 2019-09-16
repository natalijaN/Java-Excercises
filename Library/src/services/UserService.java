package services;

import java.sql.SQLException;
import java.util.List;

import dao.IUserDao;
import entities.Book;
import entities.User;

public class UserService implements IUserDao {
	
	IUserDao userDao;
	
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getAllUsers() throws SQLException {
		return this.userDao.getAllUsers();
	}

	public User getUserByPassword(String password) throws SQLException {
		return this.userDao.getUserByPassword(password);
	}

	public List<Book> getUserBooks(User user) throws SQLException {
		return this.userDao.getUserBooks(user);
	}
}
