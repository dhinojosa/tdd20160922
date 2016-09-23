package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Optional;

import org.assertj.core.data.Offset;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalcStatsTest {
	// Find the simplest thing that we can do...
	// Find the minimum value of an array
	// Where the array is one element

	@Test
	public void testMinimumWithAnArrayOfOneItem() {
		// How do I want this to look?
		// 1. Is there a class that this should be a part of.
		// 2. Instance? (6)
		// CalcStats calcStats = new CalcStats(array);
		// calcStats.getMinimum();
		// 3. Instance? (1)
		// CalcStats calcStats = new CalcStats();
		// calcStats.getMinimum(array);
		// 4. Static method call? (4)
		// CalcStats.getMinimum(array);
		// 5. Instance? (1)
		// CalcStats calcStats = new CalcStats();
		// calcStats.setArray(array)
		// calcStats.getMinimum();

		CalcStats calcStats = new CalcStats(new int[] { 3 });
		Optional<Integer> result = calcStats.getMinimum();
		assertEquals(Optional.of(3), result);
	}

	@Test
	public void testMinimumWithAnArrayOfOneDifferentItem() {
		CalcStats calcStats = new CalcStats(new int[] { 5 });
		assertThat(calcStats.getMinimum()).contains(5);
	}

	@Test
	public void testMinimumWithAnArrayOfTwoDifferentItem() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5 });
		assertThat(calcStats.getMinimum()).contains(5);
	}

	@Test
	public void testMinimumWithAnArrayOfThreeDifferentItem() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5, 3 });
		assertThat(calcStats.getMinimum()).contains(3);
	}

	@Test
	public void testMinimumWithAnArrayOfFourDifferentItem() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5, 2, 3 });
		assertThat(calcStats.getMinimum()).contains(2);
	}

	@Test
	public void testMinimumWithAnArrayOfTwelveDifferentItemAndDuplicate() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5, 2, 3, 6, 7, 8, 1, 9, 20, 11, 0 });
		assertThat(calcStats.getMinimum()).contains(0);
	}

	@Test
	public void testMinimumWithAnArrayOfTwelveDifferentItemAndDuplicatesAndANegative() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5, 2, 3, 6, -7, 8, 1, 9, 20, 11, 0 });
		assertThat(calcStats.getMinimum()).isEqualTo(Optional.of(-7));
		assertThat(calcStats.getMinimum()).contains(-7);
	}

	@Test
	public void testMinimumEmptyArray() {
		CalcStats calcStats = new CalcStats(new int[] {});
		Optional<Integer> result = calcStats.getMinimum();
		assertThat(result).isEmpty();
	}

	@Test
	public void testCalcStatsWithANullArray() {
		try {
			new CalcStats(null);
			fail("This line should not be invoked");
		} catch (IllegalArgumentException e) {
		     assertThat(e).hasMessage("Array is null");
		}
	}

	//Don't use this style, under penalty of law
	@Test(expected=IllegalArgumentException.class)
	public void testCalcStatsWithANullArrayBadWay() {
			new CalcStats(null);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCalcStatsWithANullArrayUsingARule() {
		//Setup of the rules
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Array is null");
		
		//Actually running the test
		new CalcStats(null);
	}
	
	@Test
	public void testMaximumWithAnArrayOfOneItem() {
		CalcStats calcStats = new CalcStats(new int[] { 3 });
		Optional<Integer> result = calcStats.getMaximum();
		assertEquals(Optional.of(3), result);
	}
	
	@Test
	public void testMaximumWithAnArrayOfOneDifferentItem() {
		CalcStats calcStats = new CalcStats(new int[] { 5 });
		assertThat(calcStats.getMaximum()).contains(5);
	}

	@Test
	public void testMaximumWithAnArrayOfTwoDifferentItem() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5 });
		assertThat(calcStats.getMaximum()).contains(10);
	}
	
	@Test
	public void testMaximumWithAnArrayOfThreeDifferentItem() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5, 3 });
		assertThat(calcStats.getMaximum()).contains(10);
	}

	@Test
	public void testMaximumWithAnArrayOfTwelveDifferentItemAndDuplicate() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5, 2, 3, 6, 7, 8, 1, 9, 20, 11, 0 });
		assertThat(calcStats.getMaximum()).contains(20);
	}
	
	@Test
	public void testMaximumWithAnArrayOfTwelveDifferentItemAndDuplicatesAndANegative() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5, 2, 3, 6, -7, 8, 1, 9, 20, 11, 0 });
		assertThat(calcStats.getMaximum()).contains(20);
	}
	
	@Test
	public void testMaximumEmptyArray() {
		CalcStats calcStats = new CalcStats(new int[] {});
		Optional<Integer> result = calcStats.getMaximum();
		assertThat(result).isEmpty();
	}

	@Test
	public void testSizeWithOneElement() {
		CalcStats calcStats = new CalcStats(new int[] {10});
		assertThat(calcStats.getSize()).isEqualTo(1);
	}

	@Test
	public void testSizeWithTwoElement() {
		CalcStats calcStats = new CalcStats(new int[] {10, 11});
		assertThat(calcStats.getSize()).isEqualTo(2);
	}

	@Test
	public void testAverageWithOneElement() {
		CalcStats calcStats = new CalcStats(new int[] {10});
		assertThat(calcStats.getAverage()).contains(10.0);
	}

	@Test
	public void testAverageWithTwoElement() {
		CalcStats calcStats = new CalcStats(new int[] {10, 30});
		assertThat(calcStats.getAverage()).contains(20.0);
	}
	
	@Test
	public void testAverageWithThreeElement() {
		CalcStats calcStats = new CalcStats(new int[] {10, 30, 40});
		assertThat(calcStats.getAverage().get()).isEqualTo(26.66, Offset.offset(.01));
	}
	
	@Test
	public void testAverageWithNoElements() {
		CalcStats calcStats = new CalcStats(new int[] {});
		assertThat(calcStats.getAverage()).isEmpty();
	}
	
	@Test
	public void testMinimumWithAnArrayOfTwelveDifferentItemAndDuplicatesAndWithAMINValue() {
		CalcStats calcStats = new CalcStats(new int[] { 10, 5, 2, 3, 6, -7, 8, Integer.MAX_VALUE + 1, 9, 20, 11, 0 });
		assertThat(calcStats.getMinimum()).contains(Integer.MIN_VALUE);
	}

	@Test
	public void testAverageWithThreeEnormousElements() {
		CalcStats calcStats = new CalcStats(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
		assertThat(calcStats.getAverage().get()).isEqualTo(Integer.MAX_VALUE);
	}

}
































