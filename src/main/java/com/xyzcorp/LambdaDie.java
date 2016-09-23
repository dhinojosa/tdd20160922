package com.xyzcorp;

import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.*;

public class LambdaDie {

	private Supplier<Integer> supplier;

	public LambdaDie(Supplier<Integer> supplier) {
		this.supplier = supplier;
	}

	public LambdaDie(int i) {
		// TODO Auto-generated constructor stub
	}

	public LambdaDie roll() {
		return null;
	}

	public int getPips() {
		// TODO Auto-generated method stub
		return 0;
	}

}
