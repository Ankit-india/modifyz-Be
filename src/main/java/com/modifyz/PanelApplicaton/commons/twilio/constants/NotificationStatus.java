package com.modifyz.PanelApplicaton.commons.twilio.constants;

public enum NotificationStatus {

    DELIVERED("delivered"),
    FAILED("Failed"),

    VERIFIED("verified"),

    NOT_VERIFIED("not verified");
    private String displayName;

    NotificationStatus() {
    }

    NotificationStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
