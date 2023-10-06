package com.modifyz.commons.twilio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequestDto {
    private String phoneNumber;

    private String otp;

    public static interface PhoneNumberStep {
        OtpStep withPhoneNumber(String phoneNumber);
    }

    public static interface OtpStep {
        BuildStep withOtp(String otp);
    }

    public static interface BuildStep {
        NotificationRequestDto build();
    }

    public static class Builder implements PhoneNumberStep, OtpStep, BuildStep {
        private String phoneNumber;

        private String otp;

        private Builder() {
        }

        public static PhoneNumberStep notificationRequestDto() {
            return new Builder();
        }

        @Override
        public OtpStep withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public BuildStep withOtp(String otp) {
            this.otp = otp;
            return this;
        }

        @Override
        public NotificationRequestDto build() {
            return new NotificationRequestDto(
                this.phoneNumber,
                this.otp
            );
        }
    }
}