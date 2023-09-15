package com.modifyz.commons.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressInfo {

    private String buildingNumber;

    private String shopNumber;

    private String buildingName;

    private String streetName;

    private String landMark;

    private String cityName;

    private String stateName;

    private String pinCode;

    @JsonProperty(value = "buildingNumber")
    public String getBuildingNumber() {
        return buildingNumber;
    }

    @JsonProperty(value = "bn")
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @JsonProperty(value = "shopNumber")
    public String getShopNumber() {
        return shopNumber;
    }

    @JsonProperty(value = "sn")
    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    @JsonProperty(value = "buildingName")
    public String getBuildingName() {
        return buildingName;
    }

    @JsonProperty(value = "bnm")
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @JsonProperty(value = "streetName")
    public String getStreetName() {
        return streetName;
    }

    @JsonProperty(value = "stnm")
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @JsonProperty(value = "landMark")
    public String getLandMark() {
        return landMark;
    }

    @JsonProperty(value = "lmk")
    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    @JsonProperty(value = "cityName")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty(value = "cnm")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty(value = "stateName")
    public String getStateName() {
        return stateName;
    }

    @JsonProperty(value = "sttnm")
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonProperty(value = "pinCode")
    public String getPinCode() {
        return pinCode;
    }

    @JsonProperty(value = "pc")
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
            "buildingNumber='" + buildingNumber + '\'' +
            ", shopNumber='" + shopNumber + '\'' +
            ", buildingName='" + buildingName + '\'' +
            ", streetName='" + streetName + '\'' +
            ", landMark='" + landMark + '\'' +
            ", cityName='" + cityName + '\'' +
            ", stateName='" + stateName + '\'' +
            ", pinCode='" + pinCode + '\'' +
            '}';
    }
}