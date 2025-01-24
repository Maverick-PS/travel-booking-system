package com.bookingsystem;

import com.bookingsystem.model.Flight;
import com.bookingsystem.model.Booking;
import com.bookingsystem.service.BookingService;
import com.bookingsystem.service.SearchService;
import com.bookingsystem.util.ValidationUtil;
import com.bookingsystem.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TravelApp {
    public static void main(String[] args) {
        SearchService searchService = new SearchService();
        BookingService bookingService = new BookingService();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean continueBooking = true;

            while (continueBooking) {
                // Get validated origin and destination inputs
                String origin = ValidationUtil.getValidatedCityInput(scanner, "Enter the origin city:", searchService, true);
                String destination = ValidationUtil.getValidatedCityInput(scanner, "Enter the destination city:", searchService, false);
                LocalDate travelDate = ValidationUtil.getValidatedDateInput(scanner);

                // Search for flights
                List<Flight> flights = searchService.searchFlights(origin, destination, travelDate);
                if (flights.isEmpty()) {
                    System.out.println("No flights available for the specified route and date.");
                    continue;
                }

                System.out.println("Available flights:");
                for (int i = 0; i < flights.size(); i++) {
                    Flight flight = flights.get(i);
                    System.out.printf("[%d] Flight ID: %s, From: %s, To: %s, Departure: %s, Arrival: %s, Price: ₹%.2f, Seats: %d%n",
                            i + 1, flight.getFlightId(), flight.getOriginCity(), flight.getDestinationCity(),
                            flight.getDepartureTime(), flight.getArrivalTime(), flight.getTicketPrice(), flight.getAvailableSeats());
                }

                int flightNumber = ValidationUtil.getValidatedFlightNumber(scanner, flights);

                if (flightNumber < 1 || flightNumber > flights.size()) {
                    System.out.println("Invalid flight number.");
                    continue;
                }

                Flight selectedFlight = flights.get(flightNumber - 1);

                // Get number of seats
                int seats = ValidationUtil.getValidatedSeatsInput(scanner, selectedFlight.getAvailableSeats());

                // Collect user details
                String fullName = ValidationUtil.getValidatedFullName(scanner);

                int age = ValidationUtil.getValidatedAgeInput(scanner);

                System.out.println("Enter your address:");
                String address = scanner.nextLine();
                String email = ValidationUtil.getValidatedEmailInput(scanner);

                // Create a User object
                User user = new User(fullName, age, email, address);

                // Booking process
                Booking booking = bookingService.bookFlight(selectedFlight, user, seats);
                selectedFlight.reduceSeatCount(seats);
                System.out.println("Booking successful! " + booking);
                System.out.println("Thank you for choosing our airlines!");


                // Ask if the user wants to book another flight
                System.out.println("Do you want to book another flight? (yes/no):");
                String response = scanner.nextLine().trim().toLowerCase();
                continueBooking = response.equals("yes");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
