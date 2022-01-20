package models;

import java.util.Calendar;
import java.util.Date;

public class Clothes extends Product<Integer> {
    private static final String NAME_BRAND_SIZE_COLOR_SECTION = "%s %s %s %s";
    private static final String PRICE_CALCULATION_SECTION = "%d * $%.2f = $%.2f";
    private static final String DISCOUNT_SECTION = "#discount %.2f%% -$%.2f";

    private String color;
    private Size size;

    public Clothes(String name, String brand, double price, String color, Size size) {
        super(name, brand, price);
        this.color = color;
        this.size = size;
    }

    @Override
    public double calculateDiscount(Date dateOfPurchase) {
        Calendar c = Calendar.getInstance();
        c.setTime(dateOfPurchase);
        if (c.get(Calendar.DAY_OF_WEEK) != 5 || c.get(Calendar.DAY_OF_WEEK) != 6) {
            setDiscount(0.1);
        } else {
            setDiscount(1);
        }
        return getDiscount();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public void print(Integer quantity, Date dateOfPurchase) {
        double discount = calculateDiscount(dateOfPurchase);
        double priceWithoutDiscount = quantity * getPrice();
        double priceWithDiscount = priceWithoutDiscount * discount;
        String nameBrandSizeColor = String.format(NAME_BRAND_SIZE_COLOR_SECTION, getName(), getBrand(), getSize().toString(), getColor());
        System.out.println(nameBrandSizeColor);

        String quantityPricePriceWithoutDiscount = String.format(PRICE_CALCULATION_SECTION, quantity, getPrice(), priceWithoutDiscount);
        System.out.println(quantityPricePriceWithoutDiscount);

        if (discount != 1.0) {
            String discountPriceWithDiscount = String.format(DISCOUNT_SECTION, getDiscount()*100, priceWithDiscount);
            System.out.println(discountPriceWithDiscount);
        }

        System.out.println();
    }
}
