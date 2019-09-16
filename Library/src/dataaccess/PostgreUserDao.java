package dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.IUserDao;
import entities.Book;
import entities.User;

public class PostgreUserDao implements IUserDao {

	public List<User> getAllUsers() throws SQLException {
		Connection connection = DatabaseConnection.createConnection();
		try {
			List<User> users = new ArrayList<User>();
			ResultSet usersResultSer = connection.createStatement().executeQuery("SELECT * FROM users");
			while (usersResultSer.next()) {
				User user = new User();
				user.setId(usersResultSer.getInt(1));
				user.setFirstName(usersResultSer.getString(2));
				user.setLastName(usersResultSer.getString(3));
				users.add(user);
			}
			connection.close();
			return users;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public User getUserByPassword(String password) throws SQLException {
		Connection connection = DatabaseConnection.createConnection();
		try {
			User user = new User();
			ResultSet userResultSet = connection.createStatement()
					.executeQuery(String.format("SELECT * FROM users WHERE password='%s'", password));
			while (userResultSet.next()) {
				user.setId(userResultSet.getInt(1));
				user.setFirstName(userResultSet.getString(2));
				user.setLastName(userResultSet.getString(3));
				user.setPassword(userResultSet.getString(4));
				connection.close();
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Book> getUserBooks(User user) throws SQLException {
		Connection connection = DatabaseConnection.createConnection();
		try {		
			ResultSet userRelation = connection.createStatement()
					.executeQuery(String.format("SELECT books.id,title,author,numberofcopies,available, isbn" + 
							"	FROM books" + 
							"	INNER JOIN loans ON" + 
							"	books.id = loans.bookid" + 
							"	WHERE loans.userid = %d", user.getId()));
			while (userRelation.next()) {
			    Book book = new Book();
			    book.setId(userRelation.getInt(1));
			    book.setTitle(userRelation.getString(2));
				book.setAuthor(userRelation.getString(3));
				book.setNumberOfCopies(userRelation.getInt(4));
				book.setAvailable(userRelation.getInt(5));
				book.setIsbn(userRelation.getLong(6));	
			    user.addBooks(book);;
			}
			userRelation.close();
			connection.close();
			return user.getBooks();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
