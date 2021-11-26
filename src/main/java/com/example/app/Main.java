package com.example.app;

import com.example.app.services.AverageFlightTimeCalculator;
import com.example.app.services.FlightTimePercentile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args)   {
        SpringApplication.run(Main.class, args);
    }// spring boot starter

    @Override
    public void run(String... args) throws Exception {
        AverageFlightTimeCalculator averageFlightTimeCalculator = new AverageFlightTimeCalculator();
        averageFlightTimeCalculator.calculate();

        FlightTimePercentile flightTimePercentile = new FlightTimePercentile();
        flightTimePercentile.arrayMakeElements();
        flightTimePercentile.calculatePercentile();

    }
}
