package com.modifyz.entities;

import com.modifyz.commons.utils.idGenerator.GenericIdAbstract;
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
public class Contact extends GenericIdAbstract {

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "alternateMobileNumber")
    private String alternateMobileNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode")
    private String pincode;

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
        Contact build();
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

        public static MobileNumberStep contact() {
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
        public Contact build() {
            return new Contact(
                this.mobileNumber,
                this.alternateMobileNumber,
                this.address,
                this.pincode
            );
        }
    }
}