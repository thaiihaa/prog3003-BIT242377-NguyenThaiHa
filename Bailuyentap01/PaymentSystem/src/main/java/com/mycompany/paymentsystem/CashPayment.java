package com.mycompany.paymentsystem;

public class CashPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("[Tien Mat] Dang cho nhan vien xac nhan thu tien...");
        System.out.println("[Tien Mat] Da nhan du " + amount + " VND. In hoa don.");
    }
}
