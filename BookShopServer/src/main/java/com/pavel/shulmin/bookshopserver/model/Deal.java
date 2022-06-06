package com.pavel.shulmin.bookshopserver.model;

public class Deal {
    private final long id;
    private final int amount;

    public Deal(long id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}
