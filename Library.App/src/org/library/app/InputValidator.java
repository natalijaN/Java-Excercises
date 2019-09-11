package org.library.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class InputValidator {
	
	public static int integerValidate(Scanner inputNumber) {
		int number = -1;
		while (number < 0) {
			try {
				System.out.println("Please enter valid number: ");
				number = inputNumber.nextInt();
			} catch (InputMismatchException ex) {
				inputNumber.next();
			}
		}
		return number;
	}
	
	public static int userChoiseValidate(Scanner inputNumber) {
		int number = -1;
		while (number < 0 || number > 3) {
			try {
				System.out.println("Please enter number from 1 to 3: ");
				number = inputNumber.nextInt();
			} catch (InputMismatchException ex) {
				inputNumber.next();
			}
		}
		return number;
	}

}
