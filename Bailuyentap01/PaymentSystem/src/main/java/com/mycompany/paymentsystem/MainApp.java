package com.mycompany.paymentsystem;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("--- HE THONG THANH TOAN CUA HANG ---");

        // Vi du 1: Thanh toan qua the
        Payment p1 = PaymentFactory.getPaymentMethod("CREDIT");
        if (p1 != null) {
            p1.processPayment(500000);
        }

        System.out.println("------------------------------------");

        // Vi du 2: Thanh toan qua PayPal
        Payment p2 = PaymentFactory.getPaymentMethod("PAYPAL");
        if (p2 != null) {
            p2.processPayment(250.5);
        }

        System.out.println("------------------------------------");

        // Vi du 3: Thanh toan Tien Mat
        Payment p3 = PaymentFactory.getPaymentMethod("CASH");
        if (p3 != null) {
            p3.processPayment(100000);
        }
    }
}