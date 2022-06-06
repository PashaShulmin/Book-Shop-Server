package com.pavel.shulmin.bookshopserver;

import com.pavel.shulmin.bookshopserver.domain.*;
import com.pavel.shulmin.bookshopserver.model.Deal;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class BookShopService {

    private final BookShopRepository bookShopRepository;

    public BookShopService(BookShopRepository bookShopRepository) {
        this.bookShopRepository = bookShopRepository;
    }

    public Account getAccount() {
        return bookShopRepository.getAccount();
    }

    public Market getMarket() {
        Market receivedMarket = bookShopRepository.getMarket();
        for (int i = 0; i < receivedMarket.getProducts().size(); i++) {
            int amount = receivedMarket.getProducts().get(i).getAmount();
            if (amount == 0) {
                receivedMarket.removeProductByIndex(i);
            }
        }
        return receivedMarket;
    }

    public BigDecimal makeDeal(Deal deal) {
        Product productById = bookShopRepository.getProductById(deal.getId());
        if (productById == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (productById.getAmount() < deal.getAmount()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        BigDecimal balance = bookShopRepository.getAccount().getBalance();
        BigDecimal totalCost = productById.getPrice().multiply(BigDecimal.valueOf(deal.getAmount()));
        if (balance.compareTo(totalCost) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Market updatedMarket = bookShopRepository.getMarket().removeCountById(deal.getId(), deal.getAmount());
        Account updatedAccount = bookShopRepository.getAccount().addItem(new Item(productById.getBook(), deal.getAmount()));
        updatedAccount.setBalance(updatedAccount.getBalance().subtract(totalCost));
        bookShopRepository.setMarket(updatedMarket);
        bookShopRepository.setAccount(updatedAccount);
        return updatedAccount.getBalance();
    }
}
