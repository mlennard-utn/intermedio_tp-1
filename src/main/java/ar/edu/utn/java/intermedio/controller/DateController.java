package ar.edu.utn.java.intermedio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.java.intermedio.service.DateService;

@RestController
@RequestMapping("/dates")
public class DateController {

	@Autowired
	private DateService dateService;
	
	@GetMapping(value = "/ultimoDiaMesAno/{anio}")
	public ResponseEntity<LocalDate> getUltimoDiaMesAno(@PathVariable Integer anio, @RequestParam(value="mes") Integer mes ) {
		
		return ResponseEntity.ok(dateService.ultimoDiaMesAno(mes, anio));
		
	}
    
    
}
