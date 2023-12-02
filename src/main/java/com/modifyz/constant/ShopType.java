package com.modifyz.constant;

import lombok.Getter;

@Getter
public enum ShopType {

    UNISEX("unisex"),
    ONLY_FOR_MEN("only_for_men"),
    ONLY_FOR_WOMEN("only_for_women");

    private String displayName;

    ShopType() {
    }

    ShopType(String displayName) {
        this.displayName = displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
