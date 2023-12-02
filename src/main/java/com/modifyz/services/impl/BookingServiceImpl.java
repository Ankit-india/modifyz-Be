package com.modifyz.services.impl;

import com.modifyz.convertor.BookingConvertor;
import com.modifyz.entities.Booking;
import com.modifyz.dto.BookingDto;
import com.modifyz.repositories.BookingRepository;
import com.modifyz.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
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

