package com.modifyz.PanelApplicaton.facilityDetails.constants;

public enum TimeUnit {
    HOURS("HRS", "hours"),
    MINUTES("MINS", "minutes");

    private String displayName;

    private String name;

    TimeUnit() {
    }

    TimeUnit(String displayName, String name) {
        this.displayName = displayName;
        this.name = name;
    }

}
