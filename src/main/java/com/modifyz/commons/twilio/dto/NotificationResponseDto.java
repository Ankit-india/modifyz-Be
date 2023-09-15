package com.modifyz.commons.twilio.dto;

import com.modifyz.commons.twilio.constants.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponseDto {

    private NotificationStatus notificationStatus;

    private String message;

    private String otp;

    public static interface NotificationStatusStep {
        MessageStep withNotificationStatus(NotificationStatus notificationStatus);
    }

    public static interface MessageStep {
        OtpStep withMessage(String message);
    }

    public static interface OtpStep {
        BuildStep withOtp(String otp);
    }

    public static interface BuildStep {
        NotificationResponseDto build();
    }

    public static class Builder implements NotificationStatusStep, MessageStep, OtpStep, BuildStep {
        private NotificationStatus notificationStatus;

        private String message;

        private String otp;

        private Builder() {
        }

        public static NotificationStatusStep notificationResponseDto() {
            return new Builder();
        }

        @Override
        public MessageStep withNotificationStatus(NotificationStatus notificationStatus) {
            this.notificationStatus = notificationStatus;
            return this;
        }

        @Override
        public OtpStep withMessage(String message) {
            this.message = message;
            return this;
        }

        @Override
        public BuildStep withOtp(String otp) {
            this.otp = otp;
            return this;
        }

        @Override
        public NotificationResponseDto build() {
            return new NotificationResponseDto(
                this.notificationStatus,
                this.message,
                this.otp
            );
        }
    }
}