package com.modifyz.PanelApplicaton.commons.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String buildingNumber;

    private String buildingName;

    private String streetName;

    private String landMark;

    private String cityName;

    private String stateName;

    private String pinCode;

    private Address(Builder builder) {
        setBuildingNumber(builder.buildingNumber);
        setBuildingName(builder.buildingName);
        setStreetName(builder.streetName);
        setLandMark(builder.landMark);
        setCityName(builder.cityName);
        setStateName(builder.stateName);
        setPinCode(builder.pinCode);
    }

    public static IBuildingNumber builder() {
        return new Builder();
    }


    interface IBuild {
        Address build();
    }

    interface IPinCode {
        IBuild withPinCode(String val);
    }

    interface IStateName {
        IPinCode withStateName(String val);
    }

    interface ICityName {
        IStateName withCityName(String val);
    }

    interface ILandMark {
        ICityName withLandMark(String val);
    }

    interface IStreetName {
        ILandMark withStreetName(String val);
    }

    interface IBuildingName {
        IStreetName withBuildingName(String val);
    }

    interface IBuildingNumber {
        IBuildingName withBuildingNumber(String val);
    }

    public static final class Builder implements IPinCode, IStateName, ICityName, ILandMark, IStreetName, IBuildingName, IBuildingNumber, IBuild {
        private String pinCode;
        private String stateName;
        private String cityName;
        private String landMark;
        private String streetName;
        private String buildingName;
        private String buildingNumber;

        private Builder() {
        }

        @Override
        public IBuild withPinCode(String val) {
            pinCode = val;
            return this;
        }

        @Override
        public IPinCode withStateName(String val) {
            stateName = val;
            return this;
        }

        @Override
        public IStateName withCityName(String val) {
            cityName = val;
            return this;
        }

        @Override
        public ICityName withLandMark(String val) {
            landMark = val;
            return this;
        }

        @Override
        public ILandMark withStreetName(String val) {
            streetName = val;
            return this;
        }

        @Override
        public IStreetName withBuildingName(String val) {
            buildingName = val;
            return this;
        }

        @Override
        public IBuildingName withBuildingNumber(String val) {
            buildingNumber = val;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
