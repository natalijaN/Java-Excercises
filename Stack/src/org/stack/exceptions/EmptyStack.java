package org.stack.exceptions;

public class EmptyStack extends RuntimeException {

	private static final long serialVersionUID = 5873535188932738295L;

	public EmptyStack(String message) {
        super(message);
    }
}
