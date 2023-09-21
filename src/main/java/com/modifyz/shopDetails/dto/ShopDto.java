package com.modifyz.shopDetails.dto;

import java.util.List;
import lombok.Data;

@Data
public class ShopDto {

    private String panNumber;

    private String shopName;

    private String ownerName;

    // Not required but will see in future whether to remove or not
    private String nickName;

    private String description;

    // Need to store images in S3 instances
    private List<String> images;

    private String mobileNumber;

    private String alternateMobileNumber;

    private String address;

    private String chair;

    public ShopDto(String panNumber, String shopName, String ownerName, String nickName,
        String description, List<String> images, String mobileNumber, String alternateMobileNumber,
        String address, String chair) {
        this.panNumber = panNumber;
        this.shopName = shopName;
        this.ownerName = ownerName;
        this.nickName = nickName;
        this.description = description;
        this.images = images;
        this.mobileNumber = mobileNumber;
        this.alternateMobileNumber = alternateMobileNumber;
        this.address = address;
        this.chair = chair;
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
        MobileNumberStep withImages(List<String> images);
    }

    public static interface MobileNumberStep {
        AlternateMobileNumberStep withMobileNumber(String mobileNumber);
    }

    public static interface AlternateMobileNumberStep {
        AddressStep withAlternateMobileNumber(String alternateMobileNumber);
    }

    public static interface AddressStep {
        ChairStep withAddress(String address);
    }

    public static interface ChairStep {
        BuildStep withChair(String chair);
    }

    public static interface BuildStep {
        ShopDto build();
    }

    public static class Builder
        implements PanNumberStep, ShopNameStep, OwnerNameStep, NickNameStep, DescriptionStep,
        ImagesStep, MobileNumberStep, AlternateMobileNumberStep, AddressStep, ChairStep, BuildStep {
        private String panNumber;

        private String shopName;

        private String ownerName;

        private String nickName;

        private String description;

        private List<String> images;

        private String mobileNumber;

        private String alternateMobileNumber;

        private String address;

        private String chair;

        private Builder() {
        }

        public static PanNumberStep shopDto() {
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
        public MobileNumberStep withImages(List<String> images) {
            this.images = images;
            return this;
        }

        @Override
        public AlternateMobileNumberStep withMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        @Override
        public AddressStep withAlternateMobileNumber(String alternateMobileNumber) {
            this.alternateMobileNumber = alternateMobileNumber;
            return this;
        }

        @Override
        public ChairStep withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public BuildStep withChair(String chair) {
            this.chair = chair;
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
                this.images,
                this.mobileNumber,
                this.alternateMobileNumber,
                this.address,
                this.chair
            );
        }
    }
}