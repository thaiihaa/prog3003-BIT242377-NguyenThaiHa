package com.mycompany.paymentsystem;

public class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("[PayPal] Dang chuyen huong den trang dang nhap PayPal...");
        System.out.println("[PayPal] Xac nhan giao dich: " + amount + " VND thanh cong.");
    }
}