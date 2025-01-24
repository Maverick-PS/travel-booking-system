package com.bookingsystem.service;

import com.bookingsystem.model.Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private final List<Flight> flightDatabase;

    public SearchService() {
        flightDatabase = new ArrayList<>();
        // Adding flights with origin and destination
        flightDatabase.add(new Flight("AI101", "Delhi", "Mumbai", "06:00 AM", "08:00 AM", 9000.0, 5, LocalDate.of(2025, 1, 25)));
        flightDatabase.add(new Flight("AI102", "Delhi", "Mumbai", "07:30 PM", "09:30 PM", 8200.0, 8, LocalDate.of(2025, 1, 25)));
        flightDatabase.add(new Flight("AI201", "Mumbai", "Delhi", "09:00 AM", "11:30 AM", 5800.0, 4, LocalDate.of(2025, 1, 26)));
        flightDatabase.add(new Flight("AI202", "Mumbai", "Delhi", "05:00 PM", "07:30 PM", 11000.0, 2, LocalDate.of(2025, 1, 26)));
        flightDatabase.add(new Flight("6E301", "Bengaluru", "Jaipur", "08:30 AM", "11:00 AM", 4700.0, 10, LocalDate.of(2025, 1, 25)));
        flightDatabase.add(new Flight("6E302", "Delhi", "Jaipur", "02:00 PM", "04:30 PM", 4800.0, 7, LocalDate.of(2025, 1, 25)));
        flightDatabase.add(new Flight("AI105", "Pune", "Mumbai", "06:00 AM", "08:00 AM", 5900.0, 5, LocalDate.of(2025, 1, 25)));
        flightDatabase.add(new Flight("AI106", "Bengaluru", "Mumbai", "07:30 PM", "09:30 PM", 4200.0, 8, LocalDate.of(2025, 1, 28)));
        flightDatabase.add(new Flight("AI209", "Mumbai", "Bengaluru", "09:00 AM", "11:30 AM", 3800.0, 4, LocalDate.of(2025, 1, 28)));
        flightDatabase.add(new Flight("AI207", "Pune", "Delhi", "05:00 PM", "07:30 PM", 6200.0, 2, LocalDate.of(2025, 1, 29)));
        flightDatabase.add(new Flight("6E305", "Bengaluru", "Jaipur", "08:30 AM", "11:00 AM", 9700.0, 10, LocalDate.of(2025, 1, 29)));
        flightDatabase.add(new Flight("6E308", "Pune", "Jaipur", "02:00 PM", "04:30 PM", 4800.0, 7, LocalDate.of(2025, 1, 29)));
    }

    public boolean isCityValid(String city, boolean isOrigin) {
        for (Flight flight : flightDatabase) {
            if (isOrigin && flight.getOriginCity().equalsIgnoreCase(city)) {
                return true;
            }
            if (!isOrigin && flight.getDestinationCity().equalsIgnoreCase(city)) {
                return true;
            }
        }
        return false;
    }

    public List<Flight> searchFlights(String origin, String destination, LocalDate travelDate) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightDatabase) {
            if (flight.getOriginCity().equalsIgnoreCase(origin) &&
                    flight.getDestinationCity().equalsIgnoreCase(destination) &&
                    flight.getTravelDate().equals(travelDate) &&
                    flight.getAvailableSeats() > 0) { // Exclude fully booked flights
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }

}
