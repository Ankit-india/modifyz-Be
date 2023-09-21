package com.modifyz.shopDetails.domain;

import com.modifyz.commons.utils.idGenerator.GenericIdAbstract;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.util.List;
import lombok.*;

@Entity(name = "shop")
@Table(name = "shop", indexes = {
    @Index(name = "index_panNumber", columnList = "panNumber", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
public class Shop extends GenericIdAbstract {

    @Column(name = "panNumber", nullable = false)
    private String panNumber;

    @Column(name = "shopName", nullable = false)
    private String shopName;

    @Column(name = "ownerName", nullable = false)
    private String ownerName;

    @Column(name = "nickName")
    private String nickName;

    @Column(name = "description")
    private String description;

    @Column(name = "images")
    private List<String> images;

    @Column(name = "chairDetails")
    private String chairDetails;

    public Shop(String panNumber, String shopName, String ownerName, String nickName,
        String description, List<String> images, String chairDetails) {
        this.panNumber = panNumber;
        this.shopName = shopName;
        this.ownerName = ownerName;
        this.nickName = nickName;
        this.description = description;
        this.images = images;
        this.chairDetails = chairDetails;
    }

    public static interface PanNumberStep {
        ShopNameStep withPanNumber(String panNumber);
    }

    public static interface ShopNameStep {
        OwnerNameStep withShopName(String shopName);
    }

    public static interface OwnerNameStep {
        NickNameStep withOwnerName(String ownerName);
    }

    public static interface NickNameStep {
        DescriptionStep withNickName(String nickName);
    }

    public static interface DescriptionStep {
        ImagesStep withDescription(String description);
    }

    public static interface ImagesStep {
        ChairDetailsStep withImages(List<String> images);
    }

    public static interface ChairDetailsStep {
        BuildStep withChairDetails(String chairDetails);
    }

    public static interface BuildStep {
        Shop build();
    }

    public static class Builder
        implements PanNumberStep, ShopNameStep, OwnerNameStep, NickNameStep, DescriptionStep,
        ImagesStep, ChairDetailsStep, BuildStep {
        private String panNumber;

        private String shopName;

        private String ownerName;

        private String nickName;

        private String description;

        private List<String> images;

        private String chairDetails;

        private Builder() {
        }

        public static PanNumberStep shop() {
            return new Builder();
        }

        @Override
        public ShopNameStep withPanNumber(String panNumber) {
            this.panNumber = panNumber;
            return this;
        }

        @Override
        public OwnerNameStep withShopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        @Override
        public NickNameStep withOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        @Override
        public DescriptionStep withNickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        @Override
        public ImagesStep withDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public ChairDetailsStep withImages(List<String> images) {
            this.images = images;
            return this;
        }

        @Override
        public BuildStep withChairDetails(String chairDetails) {
            this.chairDetails = chairDetails;
            return this;
        }

        @Override
        public Shop build() {
            return new Shop(
                this.panNumber,
                this.shopName,
                this.ownerName,
                this.nickName,
                this.description,
                this.images,
                this.chairDetails
            );
        }
    }
}