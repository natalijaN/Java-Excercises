package org.stack.exceptions;

public class EmptyStackException extends RuntimeException {

	private static final long serialVersionUID = 5873535188932738295L;

	public EmptyStackException(String message) {
        super(message);
    }
}
