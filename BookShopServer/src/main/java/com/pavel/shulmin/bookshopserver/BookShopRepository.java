package com.pavel.shulmin.bookshopserver;

import com.pavel.shulmin.bookshopserver.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookShopRepository {

    private Account account = new Account(null, null);
    private Market market = new Market(null);

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Account getAccount() {
        List<Item> books = new ArrayList<>();
        Book book1 = new Book("Harry Potter", "Rowling");
        Book book2 = new Book("Война и мир", "Толстой");
        books.add(new Item(book1, 3));
        books.add(new Item(book2, 5));
        this.account = new Account(books, BigDecimal.TEN);
        return account;
    }

    public Market getMarket() {
        List<Product> products = new ArrayList<>();
        Book book1 = new Book("Harry Potter", "Rowling");
        Book book2 = new Book("Война и мир", "Толстой");
        products.add(new Product(1, book1, BigDecimal.valueOf(1000), 0));
        products.add(new Product(2, book2, BigDecimal.valueOf(5000), 37));
        this.market = new Market(products);
        return market;
    }

    public Product getProductById(long id) {
        List<Product> products = market.getProducts();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
