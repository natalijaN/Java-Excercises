package org.stack.exceptions;

public class ListTooLargeException extends RuntimeException{

	private static final long serialVersionUID = 4143669996211923318L;

	public ListTooLargeException(String message) {
        super(message);
    }
}
