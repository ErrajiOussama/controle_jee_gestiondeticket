package com.example.gestiondeticket.web;


import com.example.gestiondeticket.dtos.requests.MatchRequestDtos;
import com.example.gestiondeticket.dtos.requests.TicketRequestDto;
import com.example.gestiondeticket.dtos.respenses.MatchRespenseDtos;
import com.example.gestiondeticket.dtos.respenses.TicketResponseDto;
import com.example.gestiondeticket.services.Match.MatchService;
import com.example.gestiondeticket.services.Ticket.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {
    private MatchService matchService;
    private TicketService ticketService;

    @MutationMapping
    private MatchRespenseDtos addGame(@Argument MatchRequestDtos gameInputDto) {
        return matchService.ajouterMatch(gameInputDto);
    }

    @QueryMapping
    private List<MatchRespenseDtos> getGames(){
        return matchService.gamesList();
    }


    @MutationMapping
    private TicketResponseDto getTicket(@Argument TicketRequestDto ticketInputDto) {
        return ticketService.buyTicket(ticketInputDto);
    }

    @MutationMapping
    private void updateTicket(@Argument Long id) {
        ticketService.validateTicket(id);
    }
}
