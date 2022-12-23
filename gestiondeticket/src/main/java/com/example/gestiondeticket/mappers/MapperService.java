package com.example.gestiondeticket.mappers;

import com.example.gestiondeticket.dtos.respenses.MatchRespenseDtos;
import com.example.gestiondeticket.dtos.respenses.TicketResponseDto;
import com.example.gestiondeticket.entities.Match;
import com.example.gestiondeticket.entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public MatchRespenseDtos fromMatch(Match math){
        MatchRespenseDtos matchRespenseDtos = new MatchRespenseDtos();
        BeanUtils.copyProperties(math, matchRespenseDtos);
        return  matchRespenseDtos;
    }

    public TicketResponseDto fromTicket(Ticket ticket){
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        BeanUtils.copyProperties(ticket, ticketResponseDto);
        ticketResponseDto.setMatchRespenseDtos(fromMatch(ticket.getMatch()));
        return ticketResponseDto;
    }
}
