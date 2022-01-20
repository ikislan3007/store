package models;

import java.util.Date;

public class Appliance extends Product<Integer> {
    private static final String NAME_BRAND_MODEL_SECTION = "%s %s %s";
    private static final String PRICE_CALCULATION_SECTION = "%d x $%.2f = $%.2f";
    private static final String DISCOUNT_SECTION = "#discount %.2f%% -$%.2f";

    private String model;
    private Date productionDate;

    public Appliance(String name, String brand, double price, String model, Date productionDate) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
    }

    @Override
    public double calculateDiscount(Date dateOfPurchase) {
        if (getPrice() > 999.00) {
            setDiscount(0.05);
        } else {
            setDiscount(1);
        }
        return getDiscount();
    }

    @Override
    public void print(Integer quantity, Date dateOfPurchase) {
        double discount = calculateDiscount(dateOfPurchase);
        double priceWithoutDiscount = quantity * getPrice();
        double priceWithDiscount = priceWithoutDiscount*discount;

        String nameBrandModel = String.format(NAME_BRAND_MODEL_SECTION, getName(), getBrand(), getModel());
        System.out.println(nameBrandModel);

        String quantityPricePriceWithoutDiscount = String.format(PRICE_CALCULATION_SECTION, quantity, getPrice(), priceWithoutDiscount);
        System.out.println(quantityPricePriceWithoutDiscount);

        if (discount != 1.0) {
            String discountPriceWithDiscount = String.format(DISCOUNT_SECTION, getDiscount()*100, priceWithDiscount);
            System.out.println(discountPriceWithDiscount);
        }

        System.out.println();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
