package ar.edu.utn.java.intermedio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import ar.edu.utn.java.intermedio.domain.BenchmarkResponse;
import ar.edu.utn.java.intermedio.error.MaxItemsException;
import ar.edu.utn.java.intermedio.operacion.Benchmark;

import ar.edu.utn.java.intermedio.operacion.OperacionFor;
import ar.edu.utn.java.intermedio.operacion.OperacionStreams;
import ar.edu.utn.java.intermedio.operacion.OperacionWhile;

@Service
public class BenchmarkService {
	
	private static final Integer CANTIDAD_MAXIMA_ITEMS = 50000000;
	
	public BenchmarkResponse imprimir(Integer cantidadItems) throws MaxItemsException {
		
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new MaxItemsException(cantidadItems, CANTIDAD_MAXIMA_ITEMS);		
		}
		
		BenchmarkResponse response = inicializarResponse(cantidadItems);

		long tiempo = System.currentTimeMillis();
		Benchmark operacionStreams = new OperacionStreams();
		operacionStreams.imprimirListado(response.getItems());
		response.setTiempoStreams((System.currentTimeMillis() - tiempo)*1000);
		
		tiempo = System.currentTimeMillis();
		Benchmark operacionFor = new OperacionFor();
		operacionFor.imprimirListado(response.getItems());
		response.setTiempoFor((System.currentTimeMillis() - tiempo)*1000);

		tiempo = System.currentTimeMillis();
		Benchmark operacionWhile = new OperacionWhile();
		operacionWhile.imprimirListado(response.getItems());
		response.setTiempoWhile((System.currentTimeMillis() - tiempo)*1000);
		
		return response;
	}


	
	public BenchmarkResponse sumar(Integer cantidadItems) throws MaxItemsException {
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new MaxItemsException(cantidadItems, CANTIDAD_MAXIMA_ITEMS);
		}
		
		BenchmarkResponse response = inicializarResponse(cantidadItems);
		
		long tiempo = System.currentTimeMillis();
		Benchmark operacionStreams = new OperacionStreams();
		response.setResultado(operacionStreams.sumarValores(response.getItems()));
		response.setTiempoStreams((System.currentTimeMillis() - tiempo)*1000);
		
		tiempo = System.currentTimeMillis();
		Benchmark operacionFor = new OperacionFor();
		operacionFor.sumarValores(response.getItems());
		response.setTiempoFor((System.currentTimeMillis() - tiempo)*1000);

		tiempo = System.currentTimeMillis();
		Benchmark operacionWhile = new OperacionWhile();
		operacionWhile.sumarValores(response.getItems());
		response.setTiempoWhile((System.currentTimeMillis() - tiempo)*1000);
		
		return response;
		
	}
	
	public BenchmarkResponse maximo(Integer cantidadItems) throws MaxItemsException {
		
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new MaxItemsException(cantidadItems, CANTIDAD_MAXIMA_ITEMS);
		}
		
		BenchmarkResponse response = inicializarResponse(cantidadItems);

		long tiempo = System.currentTimeMillis();
		Benchmark operacionStreams = new OperacionStreams();
		response.setResultado(operacionStreams.maximoValor(response.getItems()));
		response.setTiempoStreams((System.currentTimeMillis() - tiempo)*1000);
		
		tiempo = System.currentTimeMillis();
		Benchmark operacionFor = new OperacionFor();
		operacionFor.maximoValor(response.getItems());
		response.setTiempoFor((System.currentTimeMillis() - tiempo)*1000);

		tiempo = System.currentTimeMillis();
		Benchmark operacionWhile = new OperacionWhile();
		operacionWhile.maximoValor(response.getItems());
		response.setTiempoWhile((System.currentTimeMillis() - tiempo)*1000);
		
		return response;
	}
	
	private List<Integer> generarItems(Integer cantidadItems){
		Random rand = new Random();
		List<Integer> items = new ArrayList<>();
		for(int i = 0; i < cantidadItems; i++) {
			items.add(rand.nextInt(cantidadItems));
		}
		return items;
	}

	private BenchmarkResponse inicializarResponse(Integer cantidadItems) {
		BenchmarkResponse response = new BenchmarkResponse();
		List<Integer> items = generarItems(cantidadItems);
		response.setItems(items);
		return response;
	}
	
}
