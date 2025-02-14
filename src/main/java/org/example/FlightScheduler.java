package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightScheduler {
    static List<Flight> flights = new ArrayList<>();

    /**
     * Initializes the flight schedule by creating and adding flights to the list.
     * Each flight has a unique flight number, a fixed departure location (YUL - Montreal),
     * a destination, and a designated day of operation. Capacity for each flight is 20 boxes.
     */
    public static void loadFlights() {
        flights.add(new Flight(1, "YUL", "YYZ", 1));
        flights.add(new Flight(2, "YUL", "YYC", 1));
        flights.add(new Flight(3, "YUL", "YVR", 1));
        flights.add(new Flight(4, "YUL", "YYZ", 2));
        flights.add(new Flight(5, "YUL", "YYC", 2));
        flights.add(new Flight(6, "YUL", "YVR", 2));
    }

    /**
     * Displays the flight information for all the flights scheduled.
     */

    public static void displayFlights() {
        for (Flight flight : flights) {
            flight.displayFlightInfo();
        }
    }

    /**
     * Schedules orders onto available flights based on destination and capacity constraints.
     *
     * @param orders A map containing order IDs as keys and their respective destination codes as values.
     */
    public static void scheduleOrders(Map<String, String> orders) {
        Map<String, Flight> destinationFlights = new HashMap<>();
        for (Flight flight : flights) {
            destinationFlights.put(flight.arrival, flight);
        }

        for (Map.Entry<String, String> entry : orders.entrySet()) {
            String orderId = entry.getKey();
            String destination = entry.getValue();

            if (destinationFlights.containsKey(destination)) {
                Flight flight = destinationFlights.get(destination);
                if (flight.addOrder(orderId)) {
                    System.out.println("order: " + orderId + ", flightNumber: " + flight.flightNumber + ", departure: " + flight.departure + ", arrival: " + flight.arrival + ", day: " + flight.day);
                } else {
                    System.out.println("order: " + orderId + ", flightNumber: not scheduled");
                }
            } else {
                System.out.println("order: " + orderId + ", flightNumber: not scheduled");
            }
        }
    }
}
