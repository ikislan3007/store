import models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static void main(String[] argc) throws ParseException {

        Date expirationProductsDate = new SimpleDateFormat(DATE_FORMAT).parse("2022-01-28");
        Date weekendPurchaseDate = new SimpleDateFormat(DATE_FORMAT).parse("2022-01-22");
        Date productionDate = new SimpleDateFormat(DATE_FORMAT).parse("2020-11-14");

        Appliance laptop = new Appliance("Macbook Air M1", "Apple", 1000, "Air", productionDate);
        Food apple = new Food("Apple", "Brand", 1.45, expirationProductsDate);
        Beverage milk = new Beverage("Milk", "Meggle", 1.45, expirationProductsDate);
        Clothes cloth = new Clothes("Palto", "Ralph Floran", 1.45, "White", Size.M);

        Cart cart = new Cart();
        cart.addCartItem(new CartItem(laptop, 1));
        cart.addCartItem(new CartItem(apple, 2.34));
        cart.addCartItem(new CartItem(milk, 7));
        cart.addCartItem(new CartItem(cloth, 3));

        Cashier cashier = new Cashier(cart);
        cashier.printReceipt(weekendPurchaseDate);

    }
}
