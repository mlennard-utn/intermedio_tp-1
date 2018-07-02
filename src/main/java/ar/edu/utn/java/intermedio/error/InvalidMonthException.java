package ar.edu.utn.java.intermedio.error;

public class InvalidMonthException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMonthException(int mes)
	{
		super(String.format("Error: el mes ingresado %d debe estar entre 1 y 12", mes));
	}
}
