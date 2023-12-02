package com.modifyz.entities;

import com.modifyz.constant.PaymentMethod;
import com.modifyz.commons.utils.idGenerator.GenericIdAbstract;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
public class Booking extends GenericIdAbstract {

    @Column(name = "customerId", nullable = false)
    private String customerId;

    @Column(name = "salonId", nullable = false)
    private String salonId;

    @Column(name = "bookingDetails", nullable = false, columnDefinition = "json")
    private String bookingFacilityInfoList;

    @Column(name = "paymentMethod")
    private PaymentMethod paymentMethod;

    @Column(name = "remark")
    private String remark;

    public static interface CustomerIdStep {
        SalonIdStep withCustomerId(String customerId);
    }

    public static interface SalonIdStep {
        BookingFacilityInfoListStep withSalonId(String salonId);
    }

    public static interface BookingFacilityInfoListStep {
        PaymentMethodStep withBookingFacilityInfoList(String bookingFacilityInfoList);
    }

    public static interface PaymentMethodStep {
        RemarkStep withPaymentMethod(PaymentMethod paymentMethod);
    }

    public static interface RemarkStep {
        BuildStep withRemark(String remark);
    }

    public static interface BuildStep {
        Booking build();
    }

    public static class Builder
        implements CustomerIdStep, SalonIdStep, BookingFacilityInfoListStep, PaymentMethodStep,
        RemarkStep, BuildStep {
        private String customerId;

        private String salonId;

        private String bookingFacilityInfoList;

        private PaymentMethod paymentMethod;

        private String remark;

        private Builder() {
        }

        public static CustomerIdStep booking() {
            return new Builder();
        }

        @Override
        public SalonIdStep withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        @Override
        public BookingFacilityInfoListStep withSalonId(String salonId) {
            this.salonId = salonId;
            return this;
        }

        @Override
        public PaymentMethodStep withBookingFacilityInfoList(String bookingFacilityInfoList) {
            this.bookingFacilityInfoList = bookingFacilityInfoList;
            return this;
        }

        @Override
        public RemarkStep withPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        @Override
        public BuildStep withRemark(String remark) {
            this.remark = remark;
            return this;
        }

        @Override
        public Booking build() {
            return new Booking(
                this.customerId,
                this.salonId,
                this.bookingFacilityInfoList,
                this.paymentMethod,
                this.remark
            );
        }
    }
}