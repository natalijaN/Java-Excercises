package org.library.app;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

import org.library.models.*;

public class MainApplication {

	public static void main(String[] args) throws SQLException {

		Library library = new Library();

		System.out.println("********************Welcome to the Library!********************");
		System.out.println("               Please Write Your Library Number:               ");
		System.out.println("***************************************************************");

		Scanner inputLibraryNumber = new Scanner(System.in);
		int libraryId = inputLibraryNumber.nextInt();

		Optional<User> user = library.getAllUsers().stream().filter(u -> u.getId() == libraryId).findFirst();
		User finalUser = user.orElse(null);

		if (finalUser != null) {
			System.out.println(finalUser);
			System.out.println();
		} else {
			System.out.println("There is no such user in our database! Please try again!");
		}

		System.out.println();
		System.out.println("***************************************************************");
		System.out.println("           Please Select Book Id From Following Books          ");
		System.out.println("***************************************************************");
		System.out.println();

		for (Book b : library.getAllBooks()) {
			System.out.println(b.toString());
			System.out.println();
		}

		Scanner inputBookId = new Scanner(System.in);
		int bookId = inputBookId.nextInt();

		Optional<Book> book = library.getAllBooks().stream().filter(u -> u.getId() == bookId).findFirst();
		Book finalBook = book.orElse(null);

		if (finalBook != null) {
			library.reserveBook(finalUser.getId(), finalBook.getId());
			finalBook.setBorrowedCounter();
		} else {
			System.out.println("There is no such book in our database! Please try again!");
		}

		inputBookId.close();
		inputLibraryNumber.close();
	}
}