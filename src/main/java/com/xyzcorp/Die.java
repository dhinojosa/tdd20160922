package com.xyzcorp;

import java.util.Objects;
import java.util.Random;

public class Die {

	private final int pips;
	private final Random random;

	public Die(Random random) {
		this(random, 1);
	}

	private Die(Random random, int pips) {
		Objects.requireNonNull(random, "Random is null");
		this.random = random;
		this.pips = pips;
	}

	public int getPips() {
		return pips;
	}

	public Die roll() {
		return new Die(random, random.nextInt(6) + 1);
	}
}
