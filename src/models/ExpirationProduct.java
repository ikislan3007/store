package models;

import java.util.Calendar;
import java.util.Date;

public abstract class ExpirationProduct<T> extends Product {
    private Date expirationDate;
    public ExpirationProduct(String name, String brand, double price, Date expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public double calculateDiscount(Date dateOfPurchase) {
        Calendar c = Calendar.getInstance();
        c.setTime(expirationDate); // Using today's date
        c.add(Calendar.DATE, -5);
        Date expirationDatePlusFiveDays = c.getTime();

        if (dateOfPurchase.compareTo(expirationDate) >= 0) {
            setDiscount(0.5);
        } else if(dateOfPurchase.compareTo(expirationDatePlusFiveDays) >= 0) {
            setDiscount(0.1);
        } else {
            setDiscount(1);
        }
        return getDiscount();
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
