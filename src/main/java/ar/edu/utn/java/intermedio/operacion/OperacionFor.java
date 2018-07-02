package ar.edu.utn.java.intermedio.operacion;

import java.util.List;

public class OperacionFor extends Benchmark{

	@Override
	public void imprimir(List<Integer> items) {
		for(Integer i : items) {
			System.out.println(i);
		}
	}

	@Override
	public Double sumar(List<Integer> items) {
		Double sum = 0.0;
		for(Integer i : items) {
			sum += i;
		}
		return sum;
	}

	@Override
	public Double maximo(List<Integer> items) {
		Double max = 0.0;
		for(Integer i : items) {
			max = i > max ? i : max;
		}
		return max;
	}

}
