package com.mycompany.paymentsystem;

public class PaymentFactory {
    public static Payment getPaymentMethod(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }

        String paymentType = type.toUpperCase();

        switch (paymentType) {
            case "CREDIT":
                return new CreditCardPayment();
            case "PAYPAL":
                return new PayPalPayment();
            case "CASH":
                return new CashPayment();
            default:
                System.out.println("Loi: Phuong thuc thanh toan '" + type + "' khong ton tai.");
                return null;
        }
    }
}