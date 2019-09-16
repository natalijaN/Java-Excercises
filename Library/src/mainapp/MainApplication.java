package mainapp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dataaccess.PostgreBookDao;
import dataaccess.PostgreLoanDao;
import dataaccess.PostgreUserDao;
import entities.Book;
import entities.User;
import services.BookService;
import services.LoanService;
import services.UserService;

public class MainApplication {

	static BookService bookService = new BookService(new PostgreBookDao());
	static UserService userService = new UserService(new PostgreUserDao());
	static LoanService loanService = new LoanService(new PostgreLoanDao());

	static Scanner in = new Scanner(System.in);
	static int choice;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		welcomeMessage();
		boolean run = true;

		while (run) {
			String userChoice = in.next();
			User user = userService.getUserByPassword(userChoice);
			if (user != null) {
				System.out.println("--------------------------------");
				System.out.println("Enter a command:");
				System.out.println(" 1. Full list of books" + "\n 2. Return book" + "\n 0. Exit Application");
				System.out.println("--------------------------------");
				choice = in.nextInt();
				switch (choice) {
				// List all books
				case 1: {
					if (userService.getUserBooks(user).size() >= 3) {
						System.out.println("--------------------------------");
						System.out.println("Sorry! Can not borrow more than 3 books!");
						run = false;
					} else {
						List<Book> allBooks = bookService.getAllBooks();
						allBooks.forEach(b -> {
							System.out.println(b.toString());
							System.out.println();
						});
						System.out.println("---------------------------------------------------");
						System.out.println("    Please Enter Book ISBN From Following Books    ");
						System.out.println("---------------------------------------------------");
						long choice = in.nextLong();
						Book book = bookService.getBookByISBN(choice);
						if (book != null) {
							if (book.getAvailable() > 0) {
								loanService.reserveBook(user.getId(), book.getId());
								System.out.println(String.format("You loaned the book '%s'!", book.getTitle()));
								run = false;
								break;
							} else {
								System.out.println("This book is not available!");
								break;
							}
						} else {
							System.out.println("There is no book with that id in our database!");
						}
					}
					run = false;
					break;
				}
				// Return book
				case 2: {
					System.out.println();
					if(userService.getUserBooks(user).size() == 0) {
						System.out.println("------------------------------------------------------------");
						System.out.println("You haven`t rented a book!");
						System.out.println("------------------------------------------------------------");
					}
					else {
						List<Book> userBooks = user.getBooks();
						System.out.println("------------------------------------------------------------");
						System.out.println("   Please Enter Book ISBN For The Book You Want To Return   ");
						System.out.println("------------------------------------------------------------");
						userBooks.forEach(ub -> {
							System.out.println(ub.reviewBook());
							System.out.println();
						});
						long choice = in.nextLong();

						Book book = bookService.getBookByISBN(choice);
						if (book != null) {
							loanService.deleteLoan(user.getId(), book.getId());
							System.out.println(String.format("Thank you for returning the book '%s'", book.getTitle()));
							run = false;
						} else {
							System.out.println(String.format("You haven`t loaned book with id=%d", choice));
							run = false;
						}
					}
					run = false;
					break;
				}
				case 0: {
					run = false;
					break;
				}
				default: {
					System.out.println("Wrong input!");
					break;
				}
				}
			} else if (userChoice.equals("0")) {
				run = false;
				break;
			} else {
				System.out.println(String.format("There is no such user in our database! Try again!"));

			}
		}
		System.out.println("Thank you for using Library App!");
	}

	public static void welcomeMessage() {
		System.out.println("********************Welcome to the Library!********************");
		System.out.println("               Please Write Your Library Password:               ");
		System.out.println("         If you want to exit the application, enter '0'!       ");
		System.out.println("***************************************************************");
	}
}
