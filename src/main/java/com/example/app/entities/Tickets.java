package com.example.app.entities;

import com.example.app.entities.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tickets {
    private List<Ticket> tickets;

}
