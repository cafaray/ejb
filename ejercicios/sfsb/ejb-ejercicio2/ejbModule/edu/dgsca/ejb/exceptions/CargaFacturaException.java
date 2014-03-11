package edu.dgsca.ejb.exceptions;

public class CargaFacturaException extends Exception {

	private static final long serialVersionUID = 8526602464703253569L;

	public CargaFacturaException() {
		super();
	}

	public CargaFacturaException(String message) {
		super(message);
	}

	public CargaFacturaException(Throwable cause) {
		super(cause);		
	}

	public CargaFacturaException(String message, Throwable cause) {
		super(message, cause);
	}

}
