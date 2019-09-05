package org.stack.exceptions;

public class StackTooLargeException extends RuntimeException {
	private static final long serialVersionUID = 4143669996211923318L;

	public StackTooLargeException(String message) {
        super(message);
    }
}
