package com.modifyz.PanelApplicaton.shopDetails.domain;

import com.modifyz.PanelApplicaton.commons.utils.GenericAbstract;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.util.List;
import lombok.*;

@Entity
@Table(name = "shop")
@Getter
@Setter
@NoArgsConstructor
public class Shop extends GenericAbstract {

    @Column(name = "panCard")
    private String panCard;

    @Column(name = "shopName")
    private String shopName;

    @Column(name = "ownerName")
    private String ownerName;

    @Column(name = "nickName")
    private String nickName;

    @Column(name = "description")
    private String description;

    @Column(name = "images")
    private List<String> images;

    @Column(name = "contactId")
    private String contactId;

    public Shop(String panCard, String shopName, String ownerName, String nickName,
        String description, List<String> images, String contactId) {
        this.panCard = panCard;
        this.shopName = shopName;
        this.ownerName = ownerName;
        this.nickName = nickName;
        this.description = description;
        this.images = images;
        this.contactId = contactId;
    }

    public static interface PanCardStep {
        ShopNameStep withPanCard(String panCard);
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
        ContactIdStep withImages(List<String> images);
    }

    public static interface ContactIdStep {
        BuildStep withContactId(String contactId);
    }

    public static interface BuildStep {
        Shop build();
    }

    public static class Builder
        implements PanCardStep, ShopNameStep, OwnerNameStep, NickNameStep, DescriptionStep,
        ImagesStep, ContactIdStep, BuildStep {
        private String panCard;

        private String shopName;

        private String ownerName;

        private String nickName;

        private String description;

        private List<String> images;

        private String contactId;

        private Builder() {
        }

        public static PanCardStep shop() {
            return new Builder();
        }

        @Override
        public ShopNameStep withPanCard(String panCard) {
            this.panCard = panCard;
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
        public ContactIdStep withImages(List<String> images) {
            this.images = images;
            return this;
        }

        @Override
        public BuildStep withContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        @Override
        public Shop build() {
            return new Shop(
                this.panCard,
                this.shopName,
                this.ownerName,
                this.nickName,
                this.description,
                this.images,
                this.contactId
            );
        }
    }
}