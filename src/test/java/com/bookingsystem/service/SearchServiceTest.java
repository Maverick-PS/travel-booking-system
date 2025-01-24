package com.bookingsystem.service;

import com.bookingsystem.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    private SearchService searchService;

    @BeforeEach
    void setUp() {
        searchService = new SearchService();
    }

    // Test for isCityValid() method
    @Test
    void isCityValid_ValidOriginCity_ReturnsTrue() {
        assertTrue(searchService.isCityValid("Delhi", true));
    }

    @Test
    void isCityValid_ValidDestinationCity_ReturnsTrue() {
        assertTrue(searchService.isCityValid("Mumbai", false));
    }

    @Test
    void isCityValid_InvalidOriginCity_ReturnsFalse() {
        assertFalse(searchService.isCityValid("Chennai", true));
    }

    @Test
    void isCityValid_InvalidDestinationCity_ReturnsFalse() {
        assertFalse(searchService.isCityValid("Kolkata", false));
    }

    // Test for searchFlights() method
    @Test
    void searchFlights_ValidSearchCriteria_ReturnsMatchingFlights() {
        LocalDate travelDate = LocalDate.of(2025, 1, 25);
        List<Flight> flights = searchService.searchFlights("Delhi", "Mumbai", travelDate);

        assertNotNull(flights);
        assertEquals(2, flights.size());

        assertEquals("AI101", flights.get(0).getFlightId());
        assertEquals("AI102", flights.get(1).getFlightId());
    }

    @Test
    void searchFlights_NoMatchingFlights_ReturnsEmptyList() {
        LocalDate travelDate = LocalDate.of(2025, 1, 30);
        List<Flight> flights = searchService.searchFlights("Delhi", "Mumbai", travelDate);

        assertNotNull(flights);
        assertTrue(flights.isEmpty());
    }

    @Test
    void searchFlights_InvalidOrigin_ReturnsEmptyList() {
        LocalDate travelDate = LocalDate.of(2025, 1, 25);
        List<Flight> flights = searchService.searchFlights("Chennai", "Mumbai", travelDate);

        assertNotNull(flights);
        assertTrue(flights.isEmpty());
    }

    @Test
    void searchFlights_InvalidDestination_ReturnsEmptyList() {
        LocalDate travelDate = LocalDate.of(2025, 1, 25);
        List<Flight> flights = searchService.searchFlights("Delhi", "Kolkata", travelDate);

        assertNotNull(flights);
        assertTrue(flights.isEmpty());
    }
}
