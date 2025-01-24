package com.bookingsystem.util;

import com.bookingsystem.model.Flight;
import com.bookingsystem.service.SearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    private SearchService searchService;

    @BeforeEach
    void setUp() {
        searchService = new SearchService();
    }

    // Test for getValidatedDateInput()
    @Test
    void getValidatedDateInput_ValidDate_ReturnsParsedDate() {
        String validDate = "25-01-2025\n";
        System.setIn(new ByteArrayInputStream(validDate.getBytes()));
        Scanner scanner = new Scanner(System.in);

        LocalDate result = ValidationUtil.getValidatedDateInput(scanner);

        assertEquals(LocalDate.of(2025, 1, 25), result);
    }

    @Test
    void getValidatedDateInput_InvalidDate_PromptsAgain() {
        String invalidDate = "invalid-date\n25-01-2025\n";
        System.setIn(new ByteArrayInputStream(invalidDate.getBytes()));
        Scanner scanner = new Scanner(System.in);

        LocalDate result = ValidationUtil.getValidatedDateInput(scanner);

        assertEquals(LocalDate.of(2025, 1, 25), result);
    }

    // Test for getValidatedEmailInput()
    @Test
    void getValidatedEmailInput_ValidEmail_ReturnsEmail() {
        String validEmail = "example@test.com\n";
        System.setIn(new ByteArrayInputStream(validEmail.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String result = ValidationUtil.getValidatedEmailInput(scanner);

        assertEquals("example@test.com", result);
    }

    @Test
    void getValidatedEmailInput_InvalidEmail_PromptsAgain() {
        String invalidEmail = "invalid-email\nexample@test.com\n";
        System.setIn(new ByteArrayInputStream(invalidEmail.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String result = ValidationUtil.getValidatedEmailInput(scanner);

        assertEquals("example@test.com", result);
    }

    // Test for getValidatedAgeInput()
    @Test
    void getValidatedAgeInput_ValidAge_ReturnsAge() {
        String validAge = "25\n";
        System.setIn(new ByteArrayInputStream(validAge.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int result = ValidationUtil.getValidatedAgeInput(scanner);

        assertEquals(25, result);
    }

    @Test
    void getValidatedAgeInput_InvalidAge_PromptsAgain() {
        String invalidAge = "invalid\n30\n";
        System.setIn(new ByteArrayInputStream(invalidAge.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int result = ValidationUtil.getValidatedAgeInput(scanner);

        assertEquals(30, result);
    }

    // Test for getValidatedCityInput()
    @Test
    void getValidatedCityInput_ValidCity_ReturnsCity() {
        String validCity = "Delhi\n";
        System.setIn(new ByteArrayInputStream(validCity.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String result = ValidationUtil.getValidatedCityInput(scanner, "Enter origin city:", searchService, true);

        assertEquals("Delhi", result);
    }

    @Test
    void getValidatedCityInput_InvalidCity_PromptsAgain() {
        String invalidCity = "InvalidCity\nDelhi\n";
        System.setIn(new ByteArrayInputStream(invalidCity.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String result = ValidationUtil.getValidatedCityInput(scanner, "Enter origin city:", searchService, true);

        assertEquals("Delhi", result);
    }

    // Test for getValidatedFullName()
    @Test
    void getValidatedFullName_ValidName_ReturnsName() {
        String validName = "John Doe\n";
        System.setIn(new ByteArrayInputStream(validName.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String result = ValidationUtil.getValidatedFullName(scanner);

        assertEquals("John Doe", result);
    }

    @Test
    void getValidatedFullName_InvalidName_PromptsAgain() {
        String invalidName = "InvalidName\nJohn Doe\n";
        System.setIn(new ByteArrayInputStream(invalidName.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String result = ValidationUtil.getValidatedFullName(scanner);

        assertEquals("John Doe", result);
    }

    // Test for getValidatedFlightNumber()
    @Test
    void getValidatedFlightNumber_ValidInput_ReturnsFlightNumber() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AI101", "Delhi", "Mumbai", "06:00 AM", "08:00 AM", 9000.0, 5, LocalDate.of(2025, 1, 25)));

        String validFlightNumber = "1\n";
        System.setIn(new ByteArrayInputStream(validFlightNumber.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int result = ValidationUtil.getValidatedFlightNumber(scanner, flights);

        assertEquals(1, result);
    }

    @Test
    void getValidatedFlightNumber_InvalidInput_PromptsAgain() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AI101", "Delhi", "Mumbai", "06:00 AM", "08:00 AM", 9000.0, 5, LocalDate.of(2025, 1, 25)));

        String invalidInput = "invalid\n1\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int result = ValidationUtil.getValidatedFlightNumber(scanner, flights);

        assertEquals(1, result);
    }

    // Test for getValidatedSeatsInput()
    @Test
    void getValidatedSeatsInput_ValidSeats_ReturnsSeats() {
        String validSeats = "3\n";
        System.setIn(new ByteArrayInputStream(validSeats.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int result = ValidationUtil.getValidatedSeatsInput(scanner, 5);

        assertEquals(3, result);
    }

    @Test
    void getValidatedSeatsInput_InvalidSeats_PromptsAgain() {
        String invalidSeats = "invalid\n6\n3\n";
        System.setIn(new ByteArrayInputStream(invalidSeats.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int result = ValidationUtil.getValidatedSeatsInput(scanner, 5);

        assertEquals(3, result);
    }
}
