package com.modifyz.entities;

import com.modifyz.commons.utils.idGenerator.GenericIdAbstract;
import com.modifyz.constant.ShopType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "shop")
@Table(name = "shop", indexes = {
    @Index(name = "index_panNumber", columnList = "panNumber", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shop extends GenericIdAbstract {

    @Column(name = "panNumber", nullable = false)
    private String panNumber;

    @Column(name = "shopType", nullable = false)
    @Enumerated(EnumType.STRING)
    private ShopType shopType;

    @Column(name = "shopName", nullable = false)
    private String shopName;

    @Column(name = "ownerName", nullable = false)
    private String ownerName;

    @Column(name = "description")
    private String description;

    @Column(name = "contactId", nullable = false)
    private String contactId;

    @Column(name = "timeDetailsId", nullable = false)
    private String timeDetailsId;

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
        ContactIdStep withDescription(String description);
    }

    public static interface ContactIdStep {
        TimeDetailsIdStep withContactId(String contactId);
    }

    public static interface TimeDetailsIdStep {
        BuildStep withTimeDetailsId(String timeDetailsId);
    }

    public static interface BuildStep {
        Shop build();
    }

    public static class Builder
        implements PanNumberStep, ShopTypeStep, ShopNameStep, OwnerNameStep, DescriptionStep,
        ContactIdStep, TimeDetailsIdStep, BuildStep {
        private String panNumber;

        private ShopType shopType;

        private String shopName;

        private String ownerName;

        private String description;

        private String contactId;

        private String timeDetailsId;

        private Builder() {
        }

        public static PanNumberStep shop() {
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
        public ContactIdStep withDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public TimeDetailsIdStep withContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        @Override
        public BuildStep withTimeDetailsId(String timeDetailsId) {
            this.timeDetailsId = timeDetailsId;
            return this;
        }

        @Override
        public Shop build() {
            return new Shop(
                this.panNumber,
                this.shopType,
                this.shopName,
                this.ownerName,
                this.description,
                this.contactId,
                this.timeDetailsId
            );
        }
    }
}