package com.modifyz.entities;

import com.modifyz.dto.TimeDetailsDto;
import lombok.Data;

@Data
public class InventoryInfo {

    private String shopId;

    private TimeDetailsDto timeDetailsDto;

    private int numberOfChairs;

    public static interface ShopIdStep {
        TimeDetailsDtoStep withShopId(String shopId);
    }

    public static interface TimeDetailsDtoStep {
        NumberOfChairsStep withTimeDetailsDto(TimeDetailsDto timeDetailsDto);
    }

    public static interface NumberOfChairsStep {
        BuildStep withNumberOfChairs(int numberOfChairs);
    }

    public static interface BuildStep {
        InventoryInfo build();
    }

    public static class Builder
        implements ShopIdStep, TimeDetailsDtoStep, NumberOfChairsStep, BuildStep {
        private String shopId;

        private TimeDetailsDto timeDetailsDto;

        private int numberOfChairs;

        private Builder() {
        }

        public static ShopIdStep inventoryInfo() {
            return new Builder();
        }

        @Override
        public TimeDetailsDtoStep withShopId(String shopId) {
            this.shopId = shopId;
            return this;
        }

        @Override
        public NumberOfChairsStep withTimeDetailsDto(TimeDetailsDto timeDetailsDto) {
            this.timeDetailsDto = timeDetailsDto;
            return this;
        }

        @Override
        public BuildStep withNumberOfChairs(int numberOfChairs) {
            this.numberOfChairs = numberOfChairs;
            return this;
        }

        @Override
        public InventoryInfo build() {
            InventoryInfo inventoryInfo = new InventoryInfo();
            inventoryInfo.setShopId(this.shopId);
            inventoryInfo.setTimeDetailsDto(this.timeDetailsDto);
            inventoryInfo.setNumberOfChairs(this.numberOfChairs);
            return inventoryInfo;
        }
    }
}