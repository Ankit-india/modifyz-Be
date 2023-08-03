package com.modifyz.PanelApplicaton.shopDetails.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopDto {

    private String panNumber;

    private String shopName;

    private String ownerName;

    // Not required but will see in future whether to remove or not
    private String nickName;

    private String description;

    private List<String> images;

    //private ContactDto contactDto;

    public static interface panNumberStep {
        ShopNameStep withpanNumber(String panNumber);
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
        BuildStep withImages(List<String> images);
    }

    public static interface BuildStep {
        ShopDto build();
    }

    public static class Builder
        implements panNumberStep, ShopNameStep, OwnerNameStep, NickNameStep, DescriptionStep,
        ImagesStep, BuildStep {
        private String panNumber;

        private String shopName;

        private String ownerName;

        private String nickName;

        private String description;

        private List<String> images;

        private Builder() {
        }

        public static panNumberStep shopDto() {
            return new Builder();
        }

        @Override
        public ShopNameStep withpanNumber(String panNumber) {
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
        public BuildStep withImages(List<String> images) {
            this.images = images;
            return this;
        }

        @Override
        public ShopDto build() {
            return new ShopDto(
                this.panNumber,
                this.shopName,
                this.ownerName,
                this.nickName,
                this.description,
                this.images
            );
        }
    }
}