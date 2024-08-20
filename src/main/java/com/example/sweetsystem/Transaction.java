package com.example.sweetsystem;

public class Transaction {
    private final String description;
    private final double amount;
    private final boolean isRevenue;

    public Transaction(String description, double amount, boolean isRevenue) {
        this.description = description;
        this.amount = amount;
        this.isRevenue = isRevenue;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isRevenue() {
        return isRevenue;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", isRevenue=" + isRevenue +
                '}';
    }
}
