package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a flight with a specific route and scheduled day of departure.
 * Each flight has a fixed capacity of 20 boxes.
 */
public class Flight {
    int flightNumber;
    String departure;
    String arrival;
    int day;
    List<String> orders;
    int capacity = 20; //Fixed capacity

    /**
     * Constructs a Flight instance with the given flight number, departure location,
     * destination, and scheduled day.
     *
     * @param flightNumber Unique identifier for the flight.
     * @param departure    The departure airport code.
     * @param arrival      The destination airport code.
     * @param day          The day of the flight schedule.
     */
    public Flight(int flightNumber, String departure, String arrival, int day) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.day = day;
        this.orders = new ArrayList<>();
    }

    /**
     * Adds an order to the flight if capacity is available.
     *
     * @param orderId The unique identifier of the order.
     * @return true if the order was successfully added, false if the flight is full.
     */
    public boolean addOrder(String orderId) {
        if (orders.size() < capacity) {
            orders.add(orderId);
            return true;
        }
        return false;
    }

    /**
     * Displays individual flight details including flight number, departure, arrival, and day.
     */
    public void displayFlightInfo() {
        System.out.println("Flight: " + flightNumber + ", departure: " + departure + ", arrival: " + arrival + ", day: " + day);
    }
}