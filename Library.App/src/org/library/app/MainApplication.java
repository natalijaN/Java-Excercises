package org.library.app;

import java.sql.SQLException;
import org.library.models.*;

public class MainApplication {

	public static void main(String[] args) throws SQLException {

		Library library = new Library();

		for (User u : library.users) {
			System.out.println(u.toString());
			System.out.println();
		}

		for (Book b : library.books) {
			System.out.println(b.toString());
			System.out.println();
		}
	}
}