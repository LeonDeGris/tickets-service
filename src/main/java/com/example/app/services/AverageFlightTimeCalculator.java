package com.example.app.services;

import com.example.app.entities.Tickets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class AverageFlightTimeCalculator {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
    private final TicketsReader ticketsReader = new TicketsReader();

    public void calculate() {
        Tickets tickets = ticketsReader.read();

        long differencesSum = 0;
        for (int i = 0; i < tickets.getTickets().size(); i++){
            String departureDate = tickets.getTickets().get(i).getDepartureDate();
            String departureTime = tickets.getTickets().get(i).getDepartureTime();
            String departureDateTime = departureDate + " " + departureTime;
            long departure = LocalDateTime.parse(departureDateTime, formatter).toEpochSecond(ZoneOffset.UTC);

            String arrivalDate = tickets.getTickets().get(i).getArrivalDate();
            String arrivalTime = tickets.getTickets().get(i).getArrivalTime();
            String arrivalDateTime = arrivalDate + " " + arrivalTime;
            long arrival = LocalDateTime.parse(arrivalDateTime, formatter).toEpochSecond(ZoneOffset.UTC);


            differencesSum += arrival - departure;
        }

        long result = differencesSum / tickets.getTickets().size();
        System.out.println("The average flight time between Vladivostok and Tel-Aviv is:");
        System.out.printf("Hours:%d Minutes:%d", result / 60 / 60, (result / 60) % 60);
//        long differencesSum = (long) tickets.getTickets().stream()
//                .mapToLong(ticket -> {
//                    long arrivalSeconds = extractEpochSeconds(ticket::getArrivalDate, ticket::getArrivalTime);
//                    long departureSeconds = extractEpochSeconds(ticket::getDepartureDate, ticket::getDepartureTime);
//                    return arrivalSeconds - departureSeconds;
//                })
//                .average()
//                .orElseThrow(RuntimeException::new);
//        System.out.printf("Hours: %d \nMinutes: %d", differencesSum / 60 / 60, (differencesSum / 60) % 60);
    }

//    private long extractEpochSeconds(Supplier<String> dateExtractor, Supplier<String> timeExtractor) {
//        return LocalDateTime
//                .parse(dateExtractor.get() + " " + timeExtractor.get(), formatter)
//                .toEpochSecond(ZoneOffset.UTC);
//    }
}


