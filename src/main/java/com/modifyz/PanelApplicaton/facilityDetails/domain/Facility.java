package com.modifyz.PanelApplicaton.facilityDetails.domain;

import com.modifyz.PanelApplicaton.commons.utils.GenericAbstract;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "facility")
@NoArgsConstructor
public class Facility extends GenericAbstract {

    @Column(name = "shopId")
    private String shopId;

    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "estimatedTime")
    private BigDecimal estimatedTime;

    @Column(name = "timeUnit")
    private String timeUnit;

    public Facility(String shopId, String serviceName, String image, BigDecimal price,
        BigDecimal estimatedTime, String timeUnit) {
        this.shopId = shopId;
        this.serviceName = serviceName;
        this.image = image;
        this.price = price;
        this.estimatedTime = estimatedTime;
        this.timeUnit = timeUnit;
    }

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
        Facility build();
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

        public static ShopIdStep facility() {
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
        public Facility build() {
            return new Facility(
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