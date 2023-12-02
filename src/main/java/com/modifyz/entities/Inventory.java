package com.modifyz.entities;

import com.modifyz.commons.utils.idGenerator.GenericIdAbstract;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Entity(name = "Inventory")
@Data
@Table(name = "inventory")
public class Inventory extends GenericIdAbstract {

    @Column(name = "shopId")
    private String shopId;

    @Column(name = "chairId")
    private int chairId;

    @Column(name = "availablity")
    private String availability;

    public static interface ShopIdStep {
        ChairIdStep withShopId(String shopId);
    }

    public static interface ChairIdStep {
        AvailabilityStep withChairId(int chairId);
    }

    public static interface AvailabilityStep {
        BuildStep withAvailability(String availability);
    }

    public static interface BuildStep {
        Inventory build();
    }

    public static class Builder implements ShopIdStep, ChairIdStep, AvailabilityStep, BuildStep {
        private String shopId;

        private int chairId;

        private String availability;

        private Builder() {
        }

        public static ShopIdStep inventory() {
            return new Builder();
        }

        @Override
        public ChairIdStep withShopId(String shopId) {
            this.shopId = shopId;
            return this;
        }

        @Override
        public AvailabilityStep withChairId(int chairId) {
            this.chairId = chairId;
            return this;
        }

        @Override
        public BuildStep withAvailability(String availability) {
            this.availability = availability;
            return this;
        }

        @Override
        public Inventory build() {
            Inventory inventory = new Inventory();
            inventory.setShopId(this.shopId);
            inventory.setChairId(this.chairId);
            inventory.setAvailability(this.availability);
            return inventory;
        }
    }
}