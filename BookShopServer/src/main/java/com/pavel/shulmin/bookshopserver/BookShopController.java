package com.pavel.shulmin.bookshopserver;

import com.pavel.shulmin.bookshopserver.domain.*;
import com.pavel.shulmin.bookshopserver.model.Deal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookShopController {

    private final BookShopService bookShopService;

    public BookShopController(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @GetMapping("/account")
    public Account getAccount() {
        return bookShopService.getAccount();
    }

    @GetMapping("/market")
    public Market getMarket() {
        return bookShopService.getMarket();
    }

    @PostMapping("/market/deal")
    public void deal(@RequestBody Deal deal) {
        bookShopService.makeDeal(deal);
    }
}
