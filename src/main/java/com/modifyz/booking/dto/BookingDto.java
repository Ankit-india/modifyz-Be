package com.modifyz.booking.dto;

import com.modifyz.booking.constant.PaymentMethod;
import com.modifyz.booking.domain.BookingFacilityInfo;
import java.util.List;
import lombok.Data;

@Data
public class BookingDto {

    private String customerId;

    private String salonId;

    private List<BookingFacilityInfo> bookingFacilityInfoList;

    private PaymentMethod paymentMethod;

    private String remark;

    public BookingDto(String customerId, String salonId,
        List<BookingFacilityInfo> bookingFacilityInfoList, PaymentMethod paymentMethod,
        String remark) {
        this.customerId = customerId;
        this.salonId = salonId;
        this.bookingFacilityInfoList = bookingFacilityInfoList;
        this.paymentMethod = paymentMethod;
        this.remark = remark;
    }

    public static interface CustomerIdStep {
        SalonIdStep withCustomerId(String customerId);
    }

    public static interface SalonIdStep {
        BookingFacilityInfoListStep withSalonId(String salonId);
    }

    public static interface BookingFacilityInfoListStep {
        PaymentMethodStep withBookingFacilityInfoList(
            List<BookingFacilityInfo> bookingFacilityInfoList);
    }

    public static interface PaymentMethodStep {
        RemarkStep withPaymentMethod(PaymentMethod paymentMethod);
    }

    public static interface RemarkStep {
        BuildStep withRemark(String remark);
    }

    public static interface BuildStep {
        BookingDto build();
    }

    public static class Builder
        implements CustomerIdStep, SalonIdStep, BookingFacilityInfoListStep, PaymentMethodStep,
        RemarkStep, BuildStep {
        private String customerId;

        private String salonId;

        private List<BookingFacilityInfo> bookingFacilityInfoList;

        private PaymentMethod paymentMethod;

        private String remark;

        private Builder() {
        }

        public static CustomerIdStep bookingDto() {
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
        public PaymentMethodStep withBookingFacilityInfoList(
            List<BookingFacilityInfo> bookingFacilityInfoList) {
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
        public BookingDto build() {
            return new BookingDto(
                this.customerId,
                this.salonId,
                this.bookingFacilityInfoList,
                this.paymentMethod,
                this.remark
            );
        }
    }
}