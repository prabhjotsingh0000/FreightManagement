package org.example;

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        //User Story 1:
        //Load pre-determined six flights across two days and display the flights schedule
        FlightScheduler.loadFlights();
        FlightScheduler.displayFlights();

        //User Story 2:
        //Load order based on the flights scheduled across two days and schedule them
        Map<String, String> orders = OrderLoader.loadOrders("coding-assigment-orders.json");
        FlightScheduler.scheduleOrders(orders);
    }
}