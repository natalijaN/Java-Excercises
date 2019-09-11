package org.library.app;

public abstract class CheckDatabase {
	public static void isNull(Object object) {
		if (object != null) {
			System.out.println(object);
			System.out.println();
		} else {
			System.out.println("Wrong input!");
		}
	}
}
