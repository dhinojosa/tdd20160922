package com.xyzcorp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class DieTest {

	// Simplest thing rolling a die....
	@Test
	public void testDefaultIs1GivenARandom() {
		Random random = mock(Random.class);
		Die die = new Die(random); // Subject Under Test
		assertThat(die.getPips()).isEqualTo(1);
	}

	@Test
	public void testSimpleRollOf4() {
		// Stub - Test Double - Collaborator
		Random random = new Random() {
			@Override
			public int nextInt(int bound) {
				return 4;
			}
		};
		Die die = new Die(random);
		Die rolledDie = die.roll();
		assertThat(rolledDie.getPips()).isEqualTo(5);
	}

	@Test
	public void testSimpleRollOf6WithAMock() {
		// Mock - Test Double - Collaborator
		// 1. Create the mock
		Random random = mock(Random.class);

		// 2. Rehearse with the mock
		when(random.nextInt(6)).thenReturn(5);

		// 3. Run the Test
		Die die = new Die(random);
		Die rolledDie = die.roll();
		assertThat(rolledDie.getPips()).isEqualTo(6);
	}

	@Test
	public void testSimpleRollOf6ThenA4WithAMock() {
		// Mock - Test Double - Collaborator
		// 1. Create the mock
		Random random = mock(Random.class);

		// 2. Rehearse with the mock
		when(random.nextInt(6)).thenReturn(5, 1);

		// 3. Run the Test
		Die die = new Die(random);
		Die rolledDie = die.roll().roll();
		assertThat(rolledDie.getPips()).isEqualTo(2);
	}

	@Test
	public void testStateOfPips() {
		Random random = mock(Random.class);
		// 2. Rehearse with the mock
		when(random.nextInt(6)).thenReturn(5, 1);

		// 3. Run the Test
		Die firstRoll = new Die(random).roll();
		Die secondRoll = firstRoll.roll();
		assertThat(firstRoll.getPips()).isEqualTo(6);
		assertThat(secondRoll.getPips()).isEqualTo(2);
	}

	@Test
	public void testThatRandomIsNotNull() {
		try {
			new Die(null);
			fail("Should not be here");
		} catch (NullPointerException npe) {
			assertThat(npe).hasMessage("Random is null");
		}
	}

	@Test
	public void testIntegrationWithARealRandom() {
		Random random = new Random();
		Die die = new Die(random);
		for (int i = 0; i < 1000000; i++) {
			assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
		}
	}

	@Test
	public void testBUG2010() {
		Random random = mock(Random.class);
		when(random.nextInt(5)).thenReturn(2);
		Die firstRoll = new Die(random).roll();
		assertThat(firstRoll.getPips()).isGreaterThan(0).isLessThan(7);
	}

	@Test
	public void testBUG2010WithAZero() {
		Random random = mock(Random.class);
		when(random.nextInt(5)).thenReturn(0);
		Die firstRoll = new Die(random).roll();
		assertThat(firstRoll.getPips()).isGreaterThan(0).isLessThan(7);
	}

	@Test
	public void testDistribution() {
		Random random = new Random();
		Die die = new Die(random);
		Map<Integer, Integer> dist = new HashMap<>();
		for (int i = 0; i < 100000; i++) {
			int pips = die.roll().getPips();
			if (dist.get(pips) == null) {
				dist.put(pips, 1);
			} else {
				dist.put(pips, dist.get(pips) + 1);
			}
		}
		assertThat(dist.get(6)).isNotNull().isGreaterThan(0);
	}

	@Test
	public void testBUG2044WithNotGeneratingAny6() {
		Random random = mock(Random.class);
		when(random.nextInt(6)).thenReturn(5);
		Die firstRoll = new Die(random).roll();
		assertThat(firstRoll.getPips()).isEqualTo(6);
	}

	@Test
    public void testStream() {
        IntStream.range(0, 100).map(x -> x + 1)
                .peek(x -> System.out.println("peek x = " + x))
                .limit(4)
                .forEach(x -> System.out.println("result x = " + x));

    }

}
