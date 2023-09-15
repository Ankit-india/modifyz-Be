package com.modifyz.booking.constant;

public enum PaymentMethod {

    CASH("cash"),
    UPI("upi");

    private String displayName;

    PaymentMethod() {
    }

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
