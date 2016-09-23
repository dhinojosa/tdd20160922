package com.xyzcorp;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

public class CalcStats {

	private int[] array;

	public CalcStats(int[] array) {
		if (array == null)
			throw new IllegalArgumentException("Array is null");
		this.array = array;
	}

	private Optional<Integer> filter(BiPredicate<Integer, Integer> biPredicate) {
		if (array.length == 0)
			return Optional.empty();
		int result = array[0];
		for (int i = 1; i < array.length; i++) {
			if (biPredicate.test(array[i], result))
				result = array[i];
		}
		return Optional.of(result);
	}

	public Optional<Integer> getMinimum() {
		return filter((next, result) -> next < result);
	}

	public Optional<Integer> getMaximum() {
		return filter((next, result) -> next > result);
	}

	public int getSize() {
		return array.length;
	}

	public Optional<Double> getAverage() {
	   if(getSize() == 0) return Optional.empty();
	   double sum = 0.0;
	   for (int item: array) {
		   sum += item;
	   }
	   return Optional.of(sum / getSize());
	}
}
