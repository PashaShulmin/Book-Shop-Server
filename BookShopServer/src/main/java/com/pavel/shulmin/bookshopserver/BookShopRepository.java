package com.pavel.shulmin.bookshopserver;

import com.pavel.shulmin.bookshopserver.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return account;
    }

    public Market getMarket() {
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
