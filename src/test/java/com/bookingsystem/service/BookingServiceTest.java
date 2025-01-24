package com.bookingsystem.service;

import com.bookingsystem.model.Booking;
import com.bookingsystem.model.Flight;
import com.bookingsystem.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;



import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    private BookingService bookingService;
    private Flight flight;

    @BeforeEach
    void setUp() {
        bookingService = new BookingService();
        flight = new Flight("AI101", "Delhi", "Mumbai", "06:00 AM", "08:00 AM", 9000.0, 5, LocalDate.of(2025, 1, 25));
        // Setting up default state of Flight object (you can add setter methods as needed)
        flight.setAvailableSeats(5); // Set the available seats to 5 for testing purposes
    }

    //Test for successful Booking
    @Test
    void bookFlight_SuccessfulBooking_ReturnsBooking() {
        // Arrange
        User user = new User("Piyush Kumar", 30, "pks280721@gmail.com", "123 Lucknow");
        int seats = 2;

        // Act
        Booking booking = bookingService.bookFlight(flight, user, seats);

        // Assert
        assertNotNull(booking);
        assertEquals(user.getUserName(), booking.getUser().getUserName());
        assertEquals(seats, booking.getBookedSeats());
        assertEquals(3, flight.getAvailableSeats()); // After booking, remaining seats should be 3
    }

    //Test for Booking No seats available
    @Test
    void bookFlight_NotEnoughSeats_ThrowsException() {
        // Arrange
        User user = new User("Piyush Singh", 30, "xyz@yahoo.com", "123 corner");
        int seats = 6;

        // Act & Assert
        Exception exception = assertThrows(IllegalStateException.class, () -> bookingService.bookFlight(flight, user, seats));
        assertEquals("Not enough seats available for this flight.", exception.getMessage());
    }

    //Test for Booking with Exact Available Seats
    @Test
    void bookFlight_ExactAvailableSeats_SuccessfulBooking() {
        // Arrange
        User user = new User("Jane Doe", 25, "jane.doe@example.com", "456 Park Ave");
        int seats = 5;

        // Act
        Booking booking = bookingService.bookFlight(flight, user, seats);

        // Assert
        assertNotNull(booking);
        assertEquals(seats, booking.getBookedSeats());
        assertEquals(0, flight.getAvailableSeats()); // After booking, remaining seats should be 0
    }
}
