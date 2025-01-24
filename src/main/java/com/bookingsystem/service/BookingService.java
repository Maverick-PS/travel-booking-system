package com.bookingsystem.service;

import com.bookingsystem.model.Booking;
import com.bookingsystem.model.Flight;
import com.bookingsystem.model.User;

import java.util.UUID;

public class BookingService {

    public Booking bookFlight(Flight flight, User user, int seats) {
        if (flight.getAvailableSeats() < seats) {
            throw new IllegalStateException("Not enough seats available for this flight.");
        }

        String bookingId = UUID.randomUUID().toString(); // Generate a unique booking ID
        flight.reduceSeatCount(seats); // Decrease available seats by the number selected
        flight.calculateTotalPrice(seats); // Total ticket booking price
        return new Booking(bookingId, user, flight, seats); // Create Booking with User and Flight details
    }
}
