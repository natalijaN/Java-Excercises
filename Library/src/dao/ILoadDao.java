package dao;


import java.sql.SQLException;
import java.util.List;
import entities.Loan;

public interface ILoadDao {
	List<Loan> listLoan() throws SQLException;
	void deleteLoan(int userId, int bookId) throws SQLException;
	void reserveBook(int usedId, int bookId) throws SQLException;
}
