package com.modifyz.dto;

import com.modifyz.constant.ShopType;
import lombok.Data;

@Data
public class ShopDto {

    private String panNumber;

    private ShopType shopType;

    private String shopName;

    private String ownerName;

    private String description;

    private int numberOfChairs;

    private ContactDto contactDto;

    private TimeDetailsDto timeDetailsDto;

    public static interface PanNumberStep {
        ShopTypeStep withPanNumber(String panNumber);
    }

    public static interface ShopTypeStep {
        ShopNameStep withShopType(ShopType shopType);
    }

    public static interface ShopNameStep {
        OwnerNameStep withShopName(String shopName);
    }

    public static interface OwnerNameStep {
        DescriptionStep withOwnerName(String ownerName);
    }

    public static interface DescriptionStep {
        ContactDtoStep withDescription(String description);
    }

    public static interface ContactDtoStep {
        NumberOfChairsStep withContactDto(ContactDto contactDto);
    }

    public static interface NumberOfChairsStep {
        TimeDetailsDtoStep withNumberOfChairs(int numberOfChairs);
    }

    public static interface TimeDetailsDtoStep {
        BuildStep withTimeDetailsDto(TimeDetailsDto timeDetailsDto);
    }

    public static interface BuildStep {
        ShopDto build();
    }

    public static class Builder
        implements PanNumberStep, ShopTypeStep, ShopNameStep, OwnerNameStep, DescriptionStep,
        ContactDtoStep, NumberOfChairsStep, TimeDetailsDtoStep, BuildStep {
        private String panNumber;

        private ShopType shopType;

        private String shopName;

        private String ownerName;

        private String description;

        private ContactDto contactDto;

        private int numberOfChairs;

        private TimeDetailsDto timeDetailsDto;

        private Builder() {
        }

        public static PanNumberStep shopDto() {
            return new Builder();
        }

        @Override
        public ShopTypeStep withPanNumber(String panNumber) {
            this.panNumber = panNumber;
            return this;
        }

        @Override
        public ShopNameStep withShopType(ShopType shopType) {
            this.shopType = shopType;
            return this;
        }

        @Override
        public OwnerNameStep withShopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        @Override
        public DescriptionStep withOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        @Override
        public ContactDtoStep withDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public NumberOfChairsStep withContactDto(ContactDto contactDto) {
            this.contactDto = contactDto;
            return this;
        }

        @Override
        public TimeDetailsDtoStep withNumberOfChairs(int numberOfChairs) {
            this.numberOfChairs = numberOfChairs;
            return this;
        }

        @Override
        public BuildStep withTimeDetailsDto(TimeDetailsDto timeDetailsDto) {
            this.timeDetailsDto = timeDetailsDto;
            return this;
        }

        @Override
        public ShopDto build() {
            ShopDto shopDto = new ShopDto();
            shopDto.setPanNumber(this.panNumber);
            shopDto.setShopType(this.shopType);
            shopDto.setShopName(this.shopName);
            shopDto.setOwnerName(this.ownerName);
            shopDto.setDescription(this.description);
            shopDto.setContactDto(this.contactDto);
            shopDto.setNumberOfChairs(this.numberOfChairs);
            shopDto.setTimeDetailsDto(this.timeDetailsDto);
            return shopDto;
        }
    }
}