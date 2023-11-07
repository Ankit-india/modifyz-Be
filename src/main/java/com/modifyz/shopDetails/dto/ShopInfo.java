package com.modifyz.shopDetails.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ShopInfo {
    String id;

    String img;

    String name;

    String address;

    BigDecimal distance;

    BigDecimal rating;

    public static interface IdStep {
        ImgStep withId(String id);
    }

    public static interface ImgStep {
        NameStep withImg(String img);
    }

    public static interface NameStep {
        AddressStep withName(String name);
    }

    public static interface AddressStep {
        DistanceStep withAddress(String address);
    }

    public static interface DistanceStep {
        RatingStep withDistance(BigDecimal distance);
    }

    public static interface RatingStep {
        BuildStep withRating(BigDecimal rating);
    }

    public static interface BuildStep {
        ShopInfo build();
    }

    public static class Builder
        implements IdStep, ImgStep, NameStep, AddressStep, DistanceStep, RatingStep, BuildStep {
        private String id;

        private String img;

        private String name;

        private String address;

        private BigDecimal distance;

        private BigDecimal rating;

        private Builder() {
        }

        public static IdStep shopInfo() {
            return new Builder();
        }

        @Override
        public ImgStep withId(String id) {
            this.id = id;
            return this;
        }

        @Override
        public NameStep withImg(String img) {
            this.img = img;
            return this;
        }

        @Override
        public AddressStep withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public DistanceStep withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public RatingStep withDistance(BigDecimal distance) {
            this.distance = distance;
            return this;
        }

        @Override
        public BuildStep withRating(BigDecimal rating) {
            this.rating = rating;
            return this;
        }

        @Override
        public ShopInfo build() {
            ShopInfo shopInfo = new ShopInfo();
            shopInfo.setId(this.id);
            shopInfo.setImg(this.img);
            shopInfo.setName(this.name);
            shopInfo.setAddress(this.address);
            shopInfo.setDistance(this.distance);
            shopInfo.setRating(this.rating);
            return shopInfo;
        }
    }
}