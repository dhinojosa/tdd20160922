package com.xyzcorp;


import java.util.Objects;
import java.util.Random;

public class Die {

    private int pips;
	private Random random;

    public Die(Random random) {
       Objects.requireNonNull(random, "Random is null");
    	   this.random = random;
    }

    public Die() {
        this.pips = 1;
    }

    public Die(Random random, int pips) {
    	    this.random = random;
        this.pips = pips;
    }

    public int getPips() {
        return pips;
    }

    public Die roll() {
        return new Die(random, random.nextInt());
    }
}
