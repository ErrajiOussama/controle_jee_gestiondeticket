package com.example.gestiondeticket.dtos.respenses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TicketResponseDto {
    private Long id;
    private Double price;
    private String ref;
    private MatchRespenseDtos matchRespenseDtos;
}
