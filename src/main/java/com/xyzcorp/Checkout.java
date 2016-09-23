package com.xyzcorp;

import java.time.LocalDate;

public class Checkout {

    private final LocalDate checkoutDate;
    private final Book book;
    private final Person person;

    public Checkout(Person person, Book book, LocalDate checkoutDate) {
        this.person = person;
        this.book = book;
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public Person getPerson() {
        return person;
    }

    public Book getBook() {
        return book;
    }
}
