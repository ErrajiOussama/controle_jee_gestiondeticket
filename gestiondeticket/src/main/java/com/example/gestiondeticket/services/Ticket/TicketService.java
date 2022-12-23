package com.example.gestiondeticket.services.Ticket;

import com.example.gestiondeticket.dtos.requests.TicketRequestDto;
import com.example.gestiondeticket.dtos.respenses.TicketResponseDto;

public interface TicketService {
    TicketResponseDto buyTicket(TicketRequestDto ticketInputDto);

    void validateTicket(Long id);
}
