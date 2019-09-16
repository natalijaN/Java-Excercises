package dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ILoadDao;
import entities.Loan;

public class PostgreLoanDao implements ILoadDao {

	public List<Loan> listLoan() throws SQLException {
		Connection connection = DatabaseConnection.createConnection();
		try {
			List<Loan> loans = new ArrayList<Loan>();
			ResultSet loansResultSet = connection.createStatement().executeQuery("SELECT * FROM loans");
			System.out.println(loansResultSet.getFetchSize());
			while (loansResultSet.next()) {
				Loan loan = new Loan();
				loan.setId(loansResultSet.getInt(1));
				loan.setUserid(loansResultSet.getInt(2));
				loan.setBookid(loansResultSet.getInt(3));
				loans.add(loan);
			}
			return loans;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		connection.close();
		return null;
	}

	public void reserveBook(int userdId, int bookId) throws SQLException {
		Connection connection = DatabaseConnection.createConnection();
		try {
			connection.createStatement().executeUpdate((String.format("INSERT INTO loans (userid, bookid) VALUES (%d,%d);", userdId, bookId)));
			connection.createStatement().executeUpdate(String.format("UPDATE users SET borrowedbooks=borrowedbooks+1 WHERE id=%d", userdId));
			connection.createStatement().executeUpdate(String.format("UPDATE books SET available=available-1 WHERE id=%d;", bookId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		connection.close();
	}

	public void deleteLoan(int userId, int bookId) throws SQLException {
		Connection connection = DatabaseConnection.createConnection();
		try {
			connection.createStatement().executeUpdate((String.format("DELETE FROM loans WHERE ctid=(SELECT ctid FROM loans WHERE userid=%d LIMIT 1);", userId, bookId)));
			connection.createStatement().executeUpdate(String.format("UPDATE users SET borrowedbooks=borrowedbooks-1 WHERE id=%d;", userId));
			connection.createStatement().executeUpdate(String.format("UPDATE books SET available=available+1 WHERE id=%d;", bookId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		connection.close();
	}
}
