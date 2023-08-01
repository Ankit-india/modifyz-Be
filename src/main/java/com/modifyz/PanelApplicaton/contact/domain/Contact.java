package com.modifyz.PanelApplicaton.contact.domain;

import com.modifyz.PanelApplicaton.commons.utils.idGenerator.GenericAbstract;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "contact")
@Table(name = "contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact extends GenericAbstract {

    @Column(name = "shopId", nullable = false)
    private String shopId;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "alternateMobileNumber")
    private String alternateMobileNumber;

    @Column(name = "address")
    private String address;

    public static interface ShopIdStep {
        MobileNumberStep withShopId(String shopId);
    }

    public static interface MobileNumberStep {
        AlternateMobileNumberStep withMobileNumber(String mobileNumber);
    }

    public static interface AlternateMobileNumberStep {
        AddressStep withAlternateMobileNumber(String alternateMobileNumber);
    }

    public static interface AddressStep {
        BuildStep withAddress(String address);
    }

    public static interface BuildStep {
        Contact build();
    }

    public static class Builder
        implements ShopIdStep, MobileNumberStep, AlternateMobileNumberStep, AddressStep, BuildStep {
        private String shopId;

        private String mobileNumber;

        private String alternateMobileNumber;

        private String address;

        private Builder() {
        }

        public static ShopIdStep contact() {
            return new Builder();
        }

        @Override
        public MobileNumberStep withShopId(String shopId) {
            this.shopId = shopId;
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
        public BuildStep withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public Contact build() {
            return new Contact(
                this.shopId,
                this.mobileNumber,
                this.alternateMobileNumber,
                this.address
            );
        }
    }
}