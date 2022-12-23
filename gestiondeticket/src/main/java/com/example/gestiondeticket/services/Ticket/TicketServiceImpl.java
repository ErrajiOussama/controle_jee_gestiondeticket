package com.example.gestiondeticket.services.Ticket;

import com.example.gestiondeticket.dtos.requests.TicketRequestDto;
import com.example.gestiondeticket.dtos.respenses.TicketResponseDto;
import com.example.gestiondeticket.entities.Match;
import com.example.gestiondeticket.entities.Ticket;
import com.example.gestiondeticket.enums.StatusTicket;
import com.example.gestiondeticket.mappers.MapperService;
import com.example.gestiondeticket.repositories.MatchRepository;
import com.example.gestiondeticket.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private MapperService mapperService;
    private MatchRepository matchRepository;
    private TicketRepository ticketRepository;

    @Override
    public TicketResponseDto buyTicket(TicketRequestDto ticketInputDto){
        if (ticketInputDto.getMatchId() == null
                || ticketInputDto.getPrice().isNaN() || ticketInputDto.getPrice() <= 0)
            throw new RuntimeException("Field missing");
        Match match = matchRepository.findById(ticketInputDto.getMatchId())
                .orElseThrow(
                        () -> new RuntimeException("Id not found")
                );
        if (match.getNombreTickets() == 0)
            throw new RuntimeException("Ticket sold out");
        Ticket ticket = new Ticket();
        ticket.setPrice(ticketInputDto.getPrice());
        ticket.setStatusTicket(StatusTicket.ACTIVE);
        ticket.setRef(UUID.randomUUID().toString().substring(0,16));
        ticket.setMatch(match);

        match.setNombreTickets(match.getNombreTickets() - 1);
        matchRepository.save(match);
        return mapperService.fromTicket(ticketRepository.save(ticket));
    }

    @Override
    public void validateTicket(Long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id Not Found"));
        if (ticket.getStatusTicket() == StatusTicket.DESACTIVE)
            throw new RuntimeException("Ticket deja valider");
        ticket.setStatusTicket(StatusTicket.DESACTIVE);
        ticketRepository.save(ticket);
    }
}
