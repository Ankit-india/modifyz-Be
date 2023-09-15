package com.modifyz.usersDetails.dto;

import lombok.Data;

@Data
public class UserDto {

    private String name;

    private String phoneNumber;

    private String location;

    public UserDto(String name, String phoneNumber, String location) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public static interface NameStep {
        PhoneNumberStep withName(String name);
    }

    public static interface PhoneNumberStep {
        LocationStep withPhoneNumber(String phoneNumber);
    }

    public static interface LocationStep {
        BuildStep withLocation(String location);
    }

    public static interface BuildStep {
        UserDto build();
    }

    public static class Builder implements NameStep, PhoneNumberStep, LocationStep, BuildStep {
        private String name;

        private String phoneNumber;

        private String location;

        private Builder() {
        }

        public static NameStep userDto() {
            return new Builder();
        }

        @Override
        public PhoneNumberStep withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public LocationStep withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public BuildStep withLocation(String location) {
            this.location = location;
            return this;
        }

        @Override
        public UserDto build() {
            return new UserDto(
                this.name,
                this.phoneNumber,
                this.location
            );
        }
    }
}