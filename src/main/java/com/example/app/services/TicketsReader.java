package com.example.app.services;

import com.example.app.entities.Tickets;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class TicketsReader {
    public Tickets read(){
        ObjectMapper mapper = new ObjectMapper();

        try {

            Tickets ticket = mapper.readValue(new File("C:\\Users\\Leon\\Documents\\java-projects\\tickets-service\\src\\main\\resources\\tickets.json"), Tickets.class);
            return ticket;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Tickets(Collections.emptyList());
    }
}
