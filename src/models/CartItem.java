package models;

import java.util.Date;

public class CartItem<T extends Number> {
    private Product product;
    private T quantity;

    public CartItem(Product product, T quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void print(Date dateOfPurchase) {
        product.print(quantity, dateOfPurchase);
    }

    public T getQuantity() {
        return quantity;
    }

    public void setQuantity(T quantity) {
        this.quantity = quantity;
    }
}
