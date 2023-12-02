package com.modifyz.dto;

import lombok.Data;

@Data
public class InventoryDto {

    private String shopId;

    private int numberOfChairs;

    private TimeDetailsDto timeDetailsDto;

    public static interface ShopIdStep {
        NumberOfChairsStep withShopId(String shopId);
    }

    public static interface NumberOfChairsStep {
        TimeDetailsDtoStep withNumberOfChairs(int numberOfChairs);
    }

    public static interface TimeDetailsDtoStep {
        BuildStep withTimeDetailsDto(TimeDetailsDto timeDetailsDto);
    }

    public static interface BuildStep {
        InventoryDto build();
    }

    public static class Builder
        implements ShopIdStep, NumberOfChairsStep, TimeDetailsDtoStep, BuildStep {
        private String shopId;

        private int numberOfChairs;

        private TimeDetailsDto timeDetailsDto;

        private Builder() {
        }

        public static ShopIdStep inventoryDto() {
            return new Builder();
        }

        @Override
        public NumberOfChairsStep withShopId(String shopId) {
            this.shopId = shopId;
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
        public InventoryDto build() {
            InventoryDto inventoryDto = new InventoryDto();
            inventoryDto.setShopId(this.shopId);
            inventoryDto.setNumberOfChairs(this.numberOfChairs);
            inventoryDto.setTimeDetailsDto(this.timeDetailsDto);
            return inventoryDto;
        }
    }
}
