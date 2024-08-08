package com.eventplanning.evento.service;

import com.eventplanning.evento.model.Booking;
import com.eventplanning.evento.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Integer id) {
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Integer id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setEventName(bookingDetails.getEventName());
        booking.setOrganizerName(bookingDetails.getOrganizerName());
        booking.setDate(bookingDetails.getDate());
        booking.setTime(bookingDetails.getTime());
        booking.setVenue(bookingDetails.getVenue());
        booking.setAdditionalInfo(bookingDetails.getAdditionalInfo());

        return bookingRepository.save(booking);
    }

    public void deleteBooking(Integer id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        bookingRepository.delete(booking);
    }
}
