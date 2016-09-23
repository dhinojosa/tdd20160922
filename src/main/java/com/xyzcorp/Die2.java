package com.xyzcorp;

import java.util.Random;

public class Die2 {

	private Integer var = null;
	private final Random random;
	
	private Die2(Random random) {
		this.random = random;
	}
	
	public Die2 roll() {	
		if (var == null) var = random.nextInt(6) + 1;
		return this;
	}

	public int getPips() {
		return var;
	}
	
	public static Die2 createDie2() {
		Random random = new Random();
		return new Die2(random);
	}

}
