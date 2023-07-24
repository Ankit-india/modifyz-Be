package com.modifyz.PanelApplicaton.facilityDetails.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacilityDto {

    private String shopId;

    private String serviceName;

    private String image;

    private BigDecimal price;

    private BigDecimal estimatedTime;

    private String timeUnit;

    public static interface ShopIdStep {
        ServiceNameStep withShopId(String shopId);
    }

    public static interface ServiceNameStep {
        ImageStep withServiceName(String serviceName);
    }

    public static interface ImageStep {
        PriceStep withImage(String image);
    }

    public static interface PriceStep {
        EstimatedTimeStep withPrice(BigDecimal price);
    }

    public static interface EstimatedTimeStep {
        TimeUnitStep withEstimatedTime(BigDecimal estimatedTime);
    }

    public static interface TimeUnitStep {
        BuildStep withTimeUnit(String timeUnit);
    }

    public static interface BuildStep {
        FacilityDto build();
    }

    public static class Builder
        implements ShopIdStep, ServiceNameStep, ImageStep, PriceStep, EstimatedTimeStep,
        TimeUnitStep, BuildStep {
        private String shopId;

        private String serviceName;

        private String image;

        private BigDecimal price;

        private BigDecimal estimatedTime;

        private String timeUnit;

        private Builder() {
        }

        public static ShopIdStep facilityDto() {
            return new Builder();
        }

        @Override
        public ServiceNameStep withShopId(String shopId) {
            this.shopId = shopId;
            return this;
        }

        @Override
        public ImageStep withServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        @Override
        public PriceStep withImage(String image) {
            this.image = image;
            return this;
        }

        @Override
        public EstimatedTimeStep withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        @Override
        public TimeUnitStep withEstimatedTime(BigDecimal estimatedTime) {
            this.estimatedTime = estimatedTime;
            return this;
        }

        @Override
        public BuildStep withTimeUnit(String timeUnit) {
            this.timeUnit = timeUnit;
            return this;
        }

        @Override
        public FacilityDto build() {
            return new FacilityDto(
                this.shopId,
                this.serviceName,
                this.image,
                this.price,
                this.estimatedTime,
                this.timeUnit
            );
        }
    }
}