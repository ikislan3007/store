package models;

import java.util.Date;

public class Cashier {
    private Cart cart;

    public Cashier(Cart cart) {
        this.cart = cart;
    }

    public void printReceipt(Date dateOfPurchase) {
        cart.printReceipt(dateOfPurchase);
    }
}
