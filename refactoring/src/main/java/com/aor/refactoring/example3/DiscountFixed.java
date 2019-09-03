package com.aor.refactoring.example3;

public class DiscountFixed extends Discount {
    private final int fixed;

    public DiscountFixed(int fixed) {
        this.fixed = fixed;
    }


    public double applyDiscount(double price) {
        double discountedPrice;
        if (fixed > 0)
            discountedPrice = fixed > price ? 0 : price - fixed;
        else
            discountedPrice = price;
        return discountedPrice;
    }
}
