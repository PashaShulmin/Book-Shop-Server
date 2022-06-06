package com.pavel.shulmin.bookshopserver.domain;

import java.math.BigDecimal;
import java.util.*;

public class Account {
    private List<Item> books = new ArrayList<>();
    private BigDecimal balance;

    public Account(List<Item> books, BigDecimal balance) {
        this.books = books;
        this.balance = balance;
    }

    public List<Item> getBooks() {
        return new ArrayList<>(books);
    }

    public void setBooks(List<Item> books) {
        this.books = books;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account addItem(Item item) {
        books.add(item);
        return this;
    }
}
