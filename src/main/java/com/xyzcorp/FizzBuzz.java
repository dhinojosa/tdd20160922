package com.xyzcorp;


public class FizzBuzz {
    public static String translate(int number) {
        StringBuilder builder = new StringBuilder();
        if (number % 3 == 0) builder.append("Fizz");
        if (number % 5 == 0) builder.append("Buzz");
        else if (builder.length() == 0)
            builder.append(Integer.toString(number));
        return builder.toString();
    }
}
