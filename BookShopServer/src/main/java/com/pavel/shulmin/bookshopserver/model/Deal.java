package com.pavel.shulmin.bookshopserver.model;

public class Deal {
    private long id;
    private int amount;

    public Deal(long id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
