package com.bookingsystem.util;
import com.bookingsystem.model.Flight;
import com.bookingsystem.service.SearchService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationUtil {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$" // Ensures a valid domain extension
    );

    public static LocalDate getValidatedDateInput(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter travel date (dd-MM-yyyy):");
                String dateInput = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return LocalDate.parse(dateInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use dd-MM-yyyy.");
            }
        }
    }

    public static String getValidatedEmailInput(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter your email:");
                String email = scanner.nextLine().trim();
                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    throw new IllegalArgumentException("Invalid email address. Please enter a valid email (e.g., example@domain.com).");
                }
                return email;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getValidatedAgeInput(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter your age:");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Age must be a valid number.");
            }
        }
    }

    public static String getValidatedCityInput(Scanner scanner, String prompt, SearchService searchService, boolean isOrigin) {
        while (true) {
            System.out.println(prompt);
            String city = scanner.nextLine().trim();
            if (!city.matches("[A-Za-z\\s]+")) {
                System.out.println("Invalid city name. Please enter only letters.");
            } else if (!searchService.isCityValid(city, isOrigin)) {
                System.out.println("City not found in our database. Please enter a valid city.");
            } else {
                return city;
            }
        }
    }

    public static String getValidatedFullName(Scanner scanner) {
        while (true) {
            System.out.println("Enter your full name:");
            String fullName = scanner.nextLine().trim();

            // Regex: Allows only letters, spaces, and ensures at least two words with no extra spaces
            if (!fullName.matches("^[A-Za-z]+( [A-Za-z]+)+$")) {
                System.out.println("Invalid full name. Please enter your full name (e.g., Piyush Kumar) with at least two words and no special characters.");
            } else {
                return fullName;
            }
        }
    }

    public static int getValidatedFlightNumber(Scanner scanner, List<Flight> flights) {
        while (true) {
            System.out.println("Enter the flight number to book:");
            String input = scanner.nextLine().trim();

            try {
                int flightNumber = Integer.parseInt(input);
                if (flightNumber < 1 || flightNumber > flights.size()) {
                    System.out.println("Invalid flight number. Please choose a valid option from the list.");
                } else {
                    return flightNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number corresponding to the flight you want to book.");
            }
        }
    }

    public static int getValidatedSeatsInput(Scanner scanner, int availableSeats) {
        while (true) {
            try {
                System.out.println("Enter the number of seats you want to book:");
                int seats = Integer.parseInt(scanner.nextLine());
                if (seats < 1 || seats > availableSeats) {
                    throw new IllegalArgumentException("Only " + availableSeats + " are available right now.");
                }
                return seats;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


