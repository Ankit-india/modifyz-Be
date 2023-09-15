package com.modifyz.booking.controller;

import com.modifyz.booking.dto.BookingDto;
import com.modifyz.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired BookingService bookingService;

    @PostMapping("/")
    public ResponseEntity<BookingDto> create(@RequestBody BookingDto bookingDto) {
        BookingDto savedBookingDto = bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(savedBookingDto, HttpStatus.CREATED);
    }

}
