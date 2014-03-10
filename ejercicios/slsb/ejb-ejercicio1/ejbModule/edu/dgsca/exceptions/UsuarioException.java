package edu.dgsca.exceptions;

public class UsuarioException extends Exception {

	private static final long serialVersionUID = -7685135849542135548L;

	public UsuarioException() {
		super();
	}

	public UsuarioException(String message) {
		super(message);
	}

	public UsuarioException(Throwable cause) {
		super(cause);
	}

	public UsuarioException(String message, Throwable cause) {
		super(message, cause);
	}

}
