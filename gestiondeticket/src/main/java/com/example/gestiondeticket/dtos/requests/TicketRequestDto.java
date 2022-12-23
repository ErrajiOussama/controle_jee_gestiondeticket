package com.example.gestiondeticket.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDto {
    private Double price;
    private Long MatchId;
}
