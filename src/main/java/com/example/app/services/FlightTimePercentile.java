package com.example.app.services;

import com.example.app.entities.Tickets;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class FlightTimePercentile {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
    private final TicketsReader ticketsReader = new TicketsReader();
    Tickets tickets = ticketsReader.read();
    long differences = 0;
    long [] myArray = new long[tickets.getTickets().size()];
    int i = 0;

    public void arrayMakeElements() {

        for (int i = 0; i < tickets.getTickets().size(); i++){
            String departureDate = tickets.getTickets().get(i).getDepartureDate();
            String departureTime = tickets.getTickets().get(i).getDepartureTime();
            String departureDateTime = departureDate + " " + departureTime;
            long departure = LocalDateTime.parse(departureDateTime, formatter).toEpochSecond(ZoneOffset.UTC);

            String arrivalDate = tickets.getTickets().get(i).getArrivalDate();
            String arrivalTime = tickets.getTickets().get(i).getArrivalTime();
            String arrivalDateTime = arrivalDate + " " + arrivalTime;
            long arrival = LocalDateTime.parse(arrivalDateTime, formatter).toEpochSecond(ZoneOffset.UTC);

            differences = (arrival - departure) / 60;
            arrayAddElement();
            }
    }

    public void arrayAddElement() {
        long differences = this.differences;
        if (myArray[i] == 0){
            myArray[i] = differences;
            i += 1;
        }



    }

    public void calculatePercentile(){
        Arrays.sort(myArray);
        double n = ((double) 90 / 100) * tickets.getTickets().size();
        int percentileIndex = (int) n;
        long result = myArray[percentileIndex];
        System.out.println("\n90th percentile of flight time between Vladivostok and Tel-Aviv is:");
        System.out.printf("Hours:%d Minutes:%d", result / 60, result % 60);

    }

}
