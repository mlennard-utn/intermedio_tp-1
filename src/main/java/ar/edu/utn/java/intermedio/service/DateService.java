package ar.edu.utn.java.intermedio.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import ar.edu.utn.java.intermedio.domain.DateResponse;
import ar.edu.utn.java.intermedio.error.InvalidMonthException;

@Service
public class DateService {
	
	public DateResponse ultimoDiaMesAno(Integer mes, Integer anio) throws InvalidMonthException {
		DateResponse response = new DateResponse();
		switch(mes) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				response.setResultado(LocalDate.of(anio, mes, 31));
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				response.setResultado(LocalDate.of(anio, mes, 30));
				break;
			case 2:
				response.setResultado(LocalDate.of(anio, mes, anio % 4 == 0 ? 29 : 28));
				break;
			default:
				throw new InvalidMonthException(mes);	
		}
		return response;
	}
	
}
