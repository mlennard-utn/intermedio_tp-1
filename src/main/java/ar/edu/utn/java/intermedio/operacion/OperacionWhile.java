package ar.edu.utn.java.intermedio.operacion;

import java.util.Iterator;
import java.util.List;

public class OperacionWhile extends Benchmark {

	@Override
	public void imprimir(List<Integer> items) {
		Iterator<Integer> it = items.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

	@Override
	public Double sumar(List<Integer> items) {
		Double sum = 0.0;
		Iterator<Integer> it = items.iterator();
		while(it.hasNext())
		{
			sum += it.next();
		}
		return sum;
	}

	@Override
	public Double maximo(List<Integer> items) {
		Double max = 0.0;
		Iterator<Integer> it = items.iterator();
		Integer i = 0;
		while(it.hasNext())
		{
			i = it.next();
			max = i > max ? i : max;
		}
		return max;
	}

}
