package com.modifyz.constant;

import lombok.Getter;

@Getter
public enum PaymentMethod {

    CASH("cash"),
    UPI("upi");

    private String displayName;

    PaymentMethod() {
    }

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
