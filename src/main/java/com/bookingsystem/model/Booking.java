package com.bookingsystem.model;

public class Booking {
    private final String bookingId;
    private final User user; // Use the User class
    private final Flight flight;
    private final int bookedSeats;

    public Booking(String bookingId, User user, Flight flight, int bookedSeats) {
        this.bookingId = bookingId;
        this.user = user;
        this.flight = flight;
        this.bookedSeats = bookedSeats;
    }

    public User getUser() {
        return user;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    @Override
    public String toString() {
        return "Booking Details:\n" +
                "Booking ID: " + bookingId + "\n" +
                "User Name: " + user.getUserName() + "\n" +
                "User Age: " + user.getUserAge() + "\n" +
                "User Contact: " + user.getUserContact() + "\n" +
                "User Address: " + user.getAddress() + "\n" +
                "Flight ID: " + flight.getFlightId() + "\n" +
                "From: " + flight.getOriginCity() + " To: " + flight.getDestinationCity() + "\n" +
                "Departure: " + flight.getDepartureTime() + "\n" +
                "Arrival: " + flight.getArrivalTime() + "\n" +
                "Ticket Price: ₹" + flight.calculateTotalPrice(bookedSeats) + "\n" +
                "Seats Booked: " + bookedSeats + "\n";
    }
}
