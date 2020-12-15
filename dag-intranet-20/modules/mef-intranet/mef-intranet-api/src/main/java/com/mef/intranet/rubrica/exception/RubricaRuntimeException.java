package com.mef.intranet.rubrica.exception;

public class RubricaRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RubricaRuntimeException(Exception exception) {
		super(exception);
	}
}
