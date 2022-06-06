package com.pavel.shulmin.bookshopserver.domain;

import java.math.BigDecimal;

public class Item {
    private Book book;
    private int amount;

    public Item(Book book, int amount) {
        this.book = book;
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
