package ar.edu.utn.java.intermedio.error;

public class MaxItemsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaxItemsException(Integer cantidadItems, Integer maxItems) {
		super(String.format("Error: la cantidad maximo de items %d no debe superar el valor %d", 
					cantidadItems, maxItems));
	}
	
}
