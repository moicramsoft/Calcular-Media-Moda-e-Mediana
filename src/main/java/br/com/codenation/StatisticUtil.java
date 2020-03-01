package br.com.codenation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) Arrays.stream(elements).average().getAsDouble();
	}

	public static int mode(int[] elements) {

		return IntStream.of(elements)
				.boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.max(Comparator.comparingLong(Map.Entry::getValue))
				.get().getKey();
	}

	public static int median(int[] elements) {

		int[] lista = Arrays.stream(elements).sorted().toArray();
		int size = lista.length;

		if( size % 2 == 1 ){
			return lista[Math.floorDiv(size,2)];
		}else{
			return (lista[Math.floorDiv(size,2)] + lista[(Math.floorDiv(size,2) - 1)]) / 2;
		}
	}

	public static void main(String[] args){

		int[] elements = new int[]{2,2,2,2,3,3,3,3,6,7,7,7,7,7};
		System.out.println(mode(elements));
	}
}