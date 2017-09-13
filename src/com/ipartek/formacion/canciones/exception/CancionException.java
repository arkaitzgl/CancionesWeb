package com.ipartek.formacion.canciones.exception;

public class CancionException extends Exception{

	private static final long serialVersionUID = 1L;
	public static final String MENSAJE_DURACION_FORTMAT = "El formato de la duración no es correcto, ej 2:59";

	public CancionException(String message) {
		super(message);

}
}
