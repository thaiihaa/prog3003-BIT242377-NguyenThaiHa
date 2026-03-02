package com.mycompany.bankingsystemasync;

public class TransactionRequest {
    private String user;
    private double amount;
    private String description;

    public TransactionRequest(String user, double amount, String description) {
        this.user = user;
        this.amount = amount;
        this.description = description;
    }

    // Getters
    public String getUser() { return user; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
}