package com.xyzcorp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.ParseException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class LibraryParserTest {

    @Test
    public void testParseLineHappyPath() {
        String line = "Beth Brown~The Leftovers~2013-03-31";
        Checkout checkout = LibraryParser.parseLine(line);
        assertThat(checkout.getCheckoutDate()).isEqualTo(LocalDate.of(2013, 3, 31));
        assertThat(checkout.getPerson().getName()).isEqualTo("Beth Brown");
        assertThat(checkout.getBook().getName()).isEqualTo("The Leftovers");
    }

    @Test
    public void testParseLineHappyPathDifferentData() {
        String line = "Lopa M~The Bible~2012-10-15";
        Checkout checkout = LibraryParser.parseLine(line);
        assertThat(checkout.getCheckoutDate()).isEqualTo(LocalDate.of(2012, 10, 15));
        assertThat(checkout.getPerson().getName()).isEqualTo("Lopa M");
        assertThat(checkout.getBook().getName()).isEqualTo("The Bible");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testParseLineIfLineIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Line is not as expected");
        LibraryParser.parseLine("");
    }

    @Test
    public void testParseWithTwoElements() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Line is not as expected");
        String line = "Lopa M~The Bible";
        LibraryParser.parseLine(line);
    }

    @Test
    public void testParseWithBadDate() {
        thrown.expect(java.time.format.DateTimeParseException.class);
        String line = "Lopa M~The Bible~2015-099-12";
        LibraryParser.parseLine(line);
    }

    //TODO: Add More!
}
