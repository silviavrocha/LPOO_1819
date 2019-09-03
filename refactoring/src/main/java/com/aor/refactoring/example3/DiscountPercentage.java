package com.aor.refactoring.example3;

public class DiscountPercentage extends Discount{
    private final double percentage;

    public DiscountPercentage(double percentage) {
        this.percentage = percentage;

    }

    public double applyDiscount(double price) {
        double discountedPrice;
        if (percentage > 0)
            discountedPrice = price - price * percentage;
        else
            discountedPrice = price;

        return discountedPrice;
    }
}
