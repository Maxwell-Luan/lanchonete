package com.lanchonete.megalanches.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Objeto não encontrado: " + id);
	}
}
