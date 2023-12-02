package com.modifyz.convertor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.modifyz.entities.Booking;
import com.modifyz.dto.BookingDto;
import org.springframework.stereotype.Component;

@Component
public class BookingConvertor {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Booking convert(BookingDto bookingDto) {
        // we are converting here from Booking dto ----> Booking entity
        String bookingFacilityInfoListJson;
        try {
            bookingFacilityInfoListJson = objectMapper.writeValueAsString(bookingDto.getBookingFacilityInfoList());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Booking.Builder.booking()
            .withCustomerId(bookingDto.getCustomerId())
            .withSalonId(bookingDto.getSalonId())
            .withBookingFacilityInfoList(bookingFacilityInfoListJson)
            .withPaymentMethod(bookingDto.getPaymentMethod())
            .withRemark(bookingDto.getRemark())
            .build();
    }

    public BookingDto convertDto(Booking booking) {
        return null;
        //return BookingDto.Builder.bookingDto()
        //    .withCustomerId(booking.getCustomerId())
        //    .withSalonId(booking.getSalonId())
        //    .withBookingFacilityInfoList(bookingInfoList)
        //    .withPaymentMethod(booking.getPaymentMethod())
        //    .withRemark(booking.getRemark())
        //    .build();
    }

}
