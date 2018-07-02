package ar.edu.utn.java.intermedio.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateResponse extends Response{
	private LocalDate resultado;
	
	public String getResultado() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedString = resultado.format(formatter);
		return formattedString;
	}
	public void setResultado(LocalDate resultado) {
		this.resultado = resultado;
	}
}
