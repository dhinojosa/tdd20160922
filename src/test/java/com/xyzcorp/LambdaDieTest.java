package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Random;

import org.junit.Test;

public class LambdaDieTest {
   
	@Test
	public void testDefaultIs1GivenARandom() {
		LambdaDie die = new LambdaDie(() -> 4); // Subject Under Test
		assertThat(die.getPips()).isEqualTo(1);
	}
	
	@Test
	public void testIntegration() {
	Random random = new Random();
		LambdaDie die = new LambdaDie(() -> random.nextInt(6) + 1); // Subject Under Test
		assertThat(die.getPips()).isEqualTo(1);
	}
}
