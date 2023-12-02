package com.modifyz.constant;

public enum Meridiem {
    AM("am"),
    PM("pm");

    Meridiem() {
    }
    private String displayName;

    Meridiem(String displayName) {
        this.displayName = displayName;
    }
}
