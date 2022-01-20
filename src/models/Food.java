package models;

import java.util.Date;

public class Food extends ExpirationProduct<Double> {
    private static final String NAME_AND_BRAND_SECTION = "%s %s";
    private static final String PRICE_CALCULATION_SECTION = "%.2f * $%.2f = $%.2f";
    private static final String DISCOUNT_SECTION = "#discount %.0f%% -$%.2f";

    public Food(String name, String brand, double price, Date expirationDate) {
        super(name, brand, price, expirationDate);
    }

    @Override
    public void print(Object quantity, Date dateOfPurchase) {
        double discount = calculateDiscount(dateOfPurchase);
        double priceWithoutDiscount = (Double) quantity * getPrice();
        double priceWithDiscount = priceWithoutDiscount * discount;

        String brandAndName = String.format(NAME_AND_BRAND_SECTION, getName(), getBrand());
        System.out.println(brandAndName);

        String quantityPricePriceWithoutDiscount = String.format(PRICE_CALCULATION_SECTION,
                quantity,
                getPrice(),
                priceWithoutDiscount
        );
        System.out.println(quantityPricePriceWithoutDiscount);

        if (discount != 1.0) {
            String discountAndPriceAfterDiscount = String.format(DISCOUNT_SECTION, discount * 100, priceWithDiscount);
            System.out.println(discountAndPriceAfterDiscount);
        }

        System.out.println();
    }
}
