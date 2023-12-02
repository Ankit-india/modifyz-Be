package com.modifyz.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingFacilityInfo implements Serializable {

    private String facilityId;
    private String facilityName;
    private String facilityDuration;
    private String facilityCharge;

    public static interface FacilityIdStep {
        FacilityNameStep withFacilityId(String facilityId);
    }

    public static interface FacilityNameStep {
        FacilityDurationStep withFacilityName(String facilityName);
    }

    public static interface FacilityDurationStep {
        FacilityChargeStep withFacilityDuration(String facilityDuration);
    }

    public static interface FacilityChargeStep {
        BuildStep withFacilityCharge(String facilityCharge);
    }

    public static interface BuildStep {
        BookingFacilityInfo build();
    }

    public static class Builder
        implements FacilityIdStep, FacilityNameStep, FacilityDurationStep, FacilityChargeStep,
        BuildStep {
        private String facilityId;

        private String facilityName;

        private String facilityDuration;

        private String facilityCharge;

        private Builder() {
        }

        public static FacilityIdStep bookingFacilityInfo() {
            return new Builder();
        }

        @Override
        public FacilityNameStep withFacilityId(String facilityId) {
            this.facilityId = facilityId;
            return this;
        }

        @Override
        public FacilityDurationStep withFacilityName(String facilityName) {
            this.facilityName = facilityName;
            return this;
        }

        @Override
        public FacilityChargeStep withFacilityDuration(String facilityDuration) {
            this.facilityDuration = facilityDuration;
            return this;
        }

        @Override
        public BuildStep withFacilityCharge(String facilityCharge) {
            this.facilityCharge = facilityCharge;
            return this;
        }

        @Override
        public BookingFacilityInfo build() {
            return new BookingFacilityInfo(
                this.facilityId,
                this.facilityName,
                this.facilityDuration,
                this.facilityCharge
            );
        }
    }
}
