package com.mycompany.paymentsystem;

public class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("[The Tin Dung] Dang ket noi cong thanh toan...");
        System.out.println("[The Tin Dung] Da thanh toan thanh cong so tien: " + amount + " VND");
    }
}