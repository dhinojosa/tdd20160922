package com.xyzcorp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    public void testFizzBuzzWith1() {
        assertThat(FizzBuzz.translate(1)).isEqualTo("1");
    }

    @Test
    public void testFizzBuzzWith3() {
        assertThat(FizzBuzz.translate(3)).isEqualTo("Fizz");
    }

    @Test
    public void testFizzBuzzWith5() {
        assertThat(FizzBuzz.translate(5)).isEqualTo("Buzz");
    }

    @Test
    public void testFizzBuzzWith15() {
        assertThat(FizzBuzz.translate(15)).isEqualTo("FizzBuzz");
    }

    @Test
    public void testFizzBuzzWith10() {
        assertThat(FizzBuzz.translate(10)).isEqualTo("Buzz");
    }

    @Test
    public void testFizzBuzzWith12() {
        assertThat(FizzBuzz.translate(12)).isEqualTo("Fizz");
    }

    @Test
    public void testFizzBuzzWith30() {
        assertThat(FizzBuzz.translate(30)).isEqualTo("FizzBuzz");
    }

    @Test
    public void testFizzBuzzWith4() {
        assertThat(FizzBuzz.translate(4)).isEqualTo("4");
    }

    @Test
    public void testWith1to100() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("FizzBuzz.translate(" + i + ") = " + FizzBuzz.translate(i));
        }
    }
    


}
