package com.bookingsystem.model;

import java.time.LocalDate;

public class Flight {
    private final String flightId;
    private final String originCity;
    private final String destinationCity;
    private final String departureTime;
    private final String arrivalTime;
    private final double ticketPrice;
    private int availableSeats;
    private final LocalDate travelDate;

    public Flight(String flightId, String originCity, String destinationCity, String departureTime,
                  String arrivalTime, double ticketPrice, int availableSeats, LocalDate travelDate) {
        this.flightId = flightId;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
        this.travelDate = travelDate;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getOriginCity() {
        return originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public double calculateTotalPrice(int seats) {
        return ticketPrice * seats;
    }

    public void reduceSeatCount(int seats) {
        availableSeats -= seats;
    }
}
