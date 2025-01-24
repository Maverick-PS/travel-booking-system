# Flight Booking System

## Project Overview
The Flight Booking System is a console-based application that allows users to search for flights, validate user inputs, and book flights seamlessly. This project demonstrates object-oriented programming principles and includes unit tests to ensure functionality.

## Features
- **Search Flights**: Search for available flights by origin, destination, and travel date.
- **Booking**: Book flights and receive detailed booking information.
- **Input Validation**: Validate user inputs for email, age, travel date, and other details.
- **Unit Testing**: Comprehensive test cases for key components like services and models.

## Project Structure
The project is organized as follows:
```
com.bookingsystem
├── model
│   ├── Flight.java
│   ├── Booking.java
│   └── User.java
├── service
│   ├── BookingService.java
│   └── SearchService.java
├── util
│   └── ValidationUtil.java
└── test
    ├── BookingServiceTest.java
    ├── SearchServiceTest.java
    └── ValidationUtilTest.java
```

## Prerequisites
To run this project, ensure you have the following installed:
1. **Java**: JDK 11 or higher
2. **Maven**: Build tool to manage dependencies and run tests
3. **IDE**: IntelliJ IDEA or any other Java IDE

## Dependencies
The project uses the following dependencies, managed via Maven:
- **JUnit 5**: For unit testing
- **Mockito**: For mocking dependencies during testing

## Getting Started

### 1. Clone project
```Unziping
cd flight-booking-system
```

### 2. Build the Project
Run the following command to build the project and download dependencies:
```bash
mvn clean install
```

### 3. Run the Application
1. Open the project in your IDE.
2. Navigate to the `Main.java` (if provided) or manually invoke the `SearchService` and `BookingService` classes via the console.
3. Use the console prompts to:
    - Enter travel details (origin, destination, travel date).
    - Search for available flights.
    - Book flights after selecting one.

### 4. Run Tests
To execute all test cases:
```bash
mvn test
```
This will run unit tests for services, models, and utilities.

## Functionality Walkthrough

### 1. Search Flights
- Users can search for flights based on:
    - Origin city
    - Destination city
    - Travel date
- Fully booked flights will not be displayed.

### 2. Book Flights
- Users can book flights after:
    - Selecting a flight from search results.
    - Entering their personal details (name, age, email, etc.).
    - Specifying the number of seats to book.

### 3. Input Validation
- **Date**: Ensures the date format is `dd-MM-yyyy`.
- **Email**: Validates proper email format.
- **City**: Confirms city exists in the flight database.
- **Seats**: Ensures the number of seats requested is within available limits.

### 4. Detailed Booking Information
Upon booking, users will receive detailed information about:
- Flight details (origin, destination, departure time, arrival time, price).
- User details (name, age, contact).
- Number of seats booked.
- Total price.

## Example Usage

### Console Interaction
```plaintext
Enter travel date (dd-MM-yyyy):
25-01-2025
Enter origin city:
Delhi
Enter destination city:
Mumbai

Available flights:
1. AI101 | Departure: 06:00 AM | Arrival: 08:00 AM | Price: ₹9000.0 | Seats Available: 5
2. AI102 | Departure: 07:30 PM | Arrival: 09:30 PM | Price: ₹8200.0 | Seats Available: 8

Enter the flight number to book:
1
Enter your full name:
Piyush Kumar
Enter your age:
24
Enter your email:
xyz@example.com
Enter the number of seats you want to book:
4

Booking Details:
Booking ID: B001
User Name: Piyush Kumar
User Age: 24
User Contact: xyz@example.com
User Address: Delhi
Flight ID: AI101
From: Delhi To: Mumbai
Departure: 06:00 AM
Arrival: 08:00 AM
Ticket Price: ₹18000.0
Seats Booked: 2
```
## UML Diagram
![My Image](/travel-booking-system-uml.png)
