package org.library.app;

import java.sql.SQLException;
import java.util.Scanner;

import org.library.models.*;

public class MainApplication {

	public static void main(String[] args) throws SQLException {

		Library library = new Library();

		System.out.println("********************Welcome to the Library!********************");
		System.out.println("               Please Write Your Library Number:               ");
		System.out.println("***************************************************************");

		Scanner inputNumber = new Scanner(System.in);
		int libraryId = InputValidator.integerValidate(inputNumber);

		User user = null;

		for (User userDb : library.getAllUsers()) {
			if (userDb.getId() == libraryId) {
				user = userDb;
			}
		}

		if (user != null) {
			System.out.println(user);
			System.out.println();
		} else {
			System.out.println("There is no such user in our database! Please try again!");
		}

		System.out.println();
		System.out.println("***************************************************************");
		System.out.println("           If you want to borrow a book, enter 1!              ");
		System.out.println("          If you want to return the book, enter 2!             ");
		System.out.println("         If you want to exit the application, enter 3!         ");
		System.out.println("***************************************************************");
		System.out.println();

		int userChoise = InputValidator.userChoiseValidate(inputNumber);

		switch (userChoise) {
		case 1: {
			System.out.println();
			System.out.println("***************************************************************");
			System.out.println("           Please Select Book Id From Following Books          ");
			System.out.println("***************************************************************");
			System.out.println();

			for (Book b : library.getAllBooks()) {
				System.out.println(b.toString());
				System.out.println();
			}

			int bookId = InputValidator.integerValidate(inputNumber);
			Book book = null;

			for (Book bookDb : library.getAllBooks()) {
				if (bookDb.getId() == bookId) {
					book = bookDb;
				}
			}

			if (book != null) {
				library.reserveBook(user.getId(), book.getId());
				book.setBorrowedCounter();
			} else {
				System.out.println("There is no such book in our database! Please try again!");
			}
			break;
		}
		case 2: {
			if (user.getBooks().size() != 0) {
				System.out.println("Enter the Book Id of the book you want to return!");
				System.out.println();

				user.getBooks().stream().distinct().forEach(book -> {
					System.out.println(book.reviewBook());
					System.out.println();
				});

				int bookId = InputValidator.integerValidate(inputNumber);

				Book bookForReturn = null;
				for (Book userBook : user.getBooks()) {
					if (userBook.getId() == bookId) {
						bookForReturn = userBook;
					}
				}

				if (bookForReturn != null) {
					library.returnBook(user.getId(), bookForReturn.getId());
				} else {
					System.out.println("Wrong book id! Please try again!");
				}

			}
			System.out.println("You haven`t rented a book!");
			break;
		}
		case 3: {
			System.out.println("Thank you for using Library App!");
			break;
		}
		default: {
			System.out.println("Invalid input! Try again!");
		}
		}
		inputNumber.close();
	}
}