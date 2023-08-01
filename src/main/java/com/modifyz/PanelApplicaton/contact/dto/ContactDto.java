package com.modifyz.PanelApplicaton.contact.dto;

import com.modifyz.PanelApplicaton.commons.common.AddressInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    private String shopId;

    private String mobileNumber;

    private String alternateMobileNumber;

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
        ContactDto build();
    }

    public static class Builder
        implements ShopIdStep, MobileNumberStep, AlternateMobileNumberStep, AddressStep, BuildStep {
        private String shopId;

        private String mobileNumber;

        private String alternateMobileNumber;

        private String address;

        private Builder() {
        }

        public static ShopIdStep contactDto() {
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
        public ContactDto build() {
            return new ContactDto(
                this.shopId,
                this.mobileNumber,
                this.alternateMobileNumber,
                this.address
            );
        }
    }
}