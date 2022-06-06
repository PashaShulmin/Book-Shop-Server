package com.pavel.shulmin.bookshopserver.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Product> products = new ArrayList<>();

    public Market(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void removeProductByIndex(int index) {
        products.remove(index);
    }

    public Market removeCountById(long id, int count) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setAmount(product.getAmount() - count);
                return this;
            }
        }
        return this;
    }
}
