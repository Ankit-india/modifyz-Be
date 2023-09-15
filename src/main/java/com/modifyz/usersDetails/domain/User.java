package com.modifyz.usersDetails.domain;

import com.modifyz.commons.utils.idGenerator.GenericIdAbstract;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends GenericIdAbstract {

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "location")
    private String location;

    @Column(name = "isLoggedIn", nullable = false)
    private boolean isLoggedIn;

    public static interface NameStep {
        PhoneNumberStep withName(String name);
    }

    public static interface PhoneNumberStep {
        LocationStep withPhoneNumber(String phoneNumber);
    }

    public static interface LocationStep {
        IsLoggedInStep withLocation(String location);
    }

    public static interface IsLoggedInStep {
        BuildStep withIsLoggedIn(boolean isLoggedIn);
    }

    public static interface BuildStep {
        User build();
    }

    public static class Builder
        implements NameStep, PhoneNumberStep, LocationStep, IsLoggedInStep, BuildStep {
        private String name;

        private String phoneNumber;

        private String location;

        private boolean isLoggedIn;

        private Builder() {
        }

        public static NameStep user() {
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
        public IsLoggedInStep withLocation(String location) {
            this.location = location;
            return this;
        }

        @Override
        public BuildStep withIsLoggedIn(boolean isLoggedIn) {
            this.isLoggedIn = isLoggedIn;
            return this;
        }

        @Override
        public User build() {
            return new User(
                this.name,
                this.phoneNumber,
                this.location,
                this.isLoggedIn
            );
        }
    }
}
