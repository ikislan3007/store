package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cart {
    private static final String DATE_FORMAT_RECEIPT = "yyyy-MM-dd HH:mm:ss";
    private static final String RECEIPT_HEADER_SECTION = "Date: %s \n---Products--- \n";
    private static final String DELIMITER = "-----------------------------------------------------------------------------------";
    private static final String RECEIPT_FOOTER_SECTION = "SUBTOTAL $%.2f \nDISCOUNT $%.2f \n \nTOTAL $%.2f";


    private List<CartItem> cartItemList = new ArrayList<>();

    public void addCartItem(CartItem cartItem) {
        cartItemList.add(cartItem);
    }

    public void printReceipt(Date dateOfPurchase) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_RECEIPT);
        String dateOfPurchaseAsString = simpleDateFormat.format(dateOfPurchase);

        String receiptHeaderSection = String.format(RECEIPT_HEADER_SECTION, dateOfPurchaseAsString);
        System.out.println(receiptHeaderSection);

        double subTotal = 0;
        double totalDiscount = 0;

        for (CartItem cartItem : cartItemList) {
            cartItem.print(dateOfPurchase);
            double quantity = Double.parseDouble(cartItem.getQuantity().toString());
            double productPrice = cartItem.getProduct().getPrice() * quantity;
            subTotal += productPrice;
            if (cartItem.getProduct().getDiscount() != 1.00) {
                totalDiscount += productPrice * cartItem.getProduct().getDiscount();
            }

        }

        System.out.println(DELIMITER);

        String receiptBottomSection = String.format(RECEIPT_FOOTER_SECTION,
                subTotal,
                totalDiscount,
                subTotal - totalDiscount
        );

        System.out.println(receiptBottomSection);

    }
}
