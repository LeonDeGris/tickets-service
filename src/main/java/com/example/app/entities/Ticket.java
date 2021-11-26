package com.example.app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Ticket {


    private String origin;
    @JsonProperty(value = "origin_name")
    private String originName;
    private String destination;
    @JsonProperty(value = "destination_name")
    private String destinationName;
    @JsonProperty(value = "departure_date")
    private String departureDate;
    @JsonProperty(value = "departure_time")
    private String departureTime;
    @JsonProperty(value = "arrival_date")
    private String arrivalDate;
    @JsonProperty(value = "arrival_time")
    private String arrivalTime;
    private String carrier;
    private int stops;
    private int price;



}
