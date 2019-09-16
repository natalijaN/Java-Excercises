package services;

import java.sql.SQLException;
import java.util.List;

import dao.ILoadDao;
import entities.Loan;

public class LoanService implements ILoadDao {

	ILoadDao loanDao;

	public LoanService(ILoadDao loanDao) {
		this.loanDao = loanDao;
	}

	public List<Loan> listLoan() throws SQLException {
		return loanDao.listLoan();
	}

	public void deleteLoan(int userId, int bookId) throws SQLException {
		loanDao.deleteLoan(userId, bookId);
	}

	public void reserveBook(int usedId, int bookId) throws SQLException {
		loanDao.reserveBook(usedId, bookId);
	}

}
