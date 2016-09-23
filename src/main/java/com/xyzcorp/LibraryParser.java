package com.xyzcorp;

import java.text.ParseException;
import java.time.LocalDate;

/**
 * Created by danno on 9/23/16.
 */
public class LibraryParser {
    public static Checkout parseLine(String line) {

        if ("".equals(line)) throw new IllegalArgumentException("Line is not as expected");
        String[] split = line.split("~");
        if (split.length != 3) throw new IllegalArgumentException("Line is not as expected");

        return new Checkout(new Person(split[0]), new Book(split[1]), LocalDate.parse(split[2]));
    }
}
