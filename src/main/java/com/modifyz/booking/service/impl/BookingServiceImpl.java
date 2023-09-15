package com.modifyz.booking.service.impl;

import com.modifyz.booking.converter.BookingConvertor;
import com.modifyz.booking.domain.Booking;
import com.modifyz.booking.dto.BookingDto;
import com.modifyz.booking.repository.BookingRepository;
import com.modifyz.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired BookingConvertor bookingConvertor;

    @Autowired BookingRepository bookingRepository;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = bookingConvertor.convert(bookingDto);
        // salon
        // facility
        // user
        bookingRepository.save(booking);
        BookingDto savedBooking = bookingConvertor.convertDto(booking);
        return savedBooking;
    }
}

