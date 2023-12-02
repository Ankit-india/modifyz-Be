package com.modifyz.dto;

import lombok.Data;

@Data
public class ContactDto {

    private String mobileNumber;

    private String alternateMobileNumber;

    private String address;

    private String pincode;

    public ContactDto(String mobileNumber, String alternateMobileNumber, String address,
        String pincode) {
        this.mobileNumber = mobileNumber;
        this.alternateMobileNumber = alternateMobileNumber;
        this.address = address;
        this.pincode = pincode;
    }

    public static interface MobileNumberStep {
        AlternateMobileNumberStep withMobileNumber(String mobileNumber);
    }

    public static interface AlternateMobileNumberStep {
        AddressStep withAlternateMobileNumber(String alternateMobileNumber);
    }

    public static interface AddressStep {
        PincodeStep withAddress(String address);
    }

    public static interface PincodeStep {
        BuildStep withPincode(String pincode);
    }

    public static interface BuildStep {
        ContactDto build();
    }

    public static class Builder
        implements MobileNumberStep, AlternateMobileNumberStep, AddressStep, PincodeStep,
        BuildStep {
        private String mobileNumber;

        private String alternateMobileNumber;

        private String address;

        private String pincode;

        private Builder() {
        }

        public static MobileNumberStep contactDto() {
            return new Builder();
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
        public PincodeStep withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public BuildStep withPincode(String pincode) {
            this.pincode = pincode;
            return this;
        }

        @Override
        public ContactDto build() {
            return new ContactDto(
                this.mobileNumber,
                this.alternateMobileNumber,
                this.address,
                this.pincode
            );
        }
    }
}