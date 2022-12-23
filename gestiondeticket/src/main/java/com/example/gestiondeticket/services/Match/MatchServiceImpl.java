package com.example.gestiondeticket.services.Match;


import com.example.gestiondeticket.dtos.requests.MatchRequestDtos;
import com.example.gestiondeticket.dtos.respenses.MatchRespenseDtos;
import com.example.gestiondeticket.entities.Match;
import com.example.gestiondeticket.mappers.MapperService;
import com.example.gestiondeticket.repositories.MatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;
    private MapperService mapperService;

    @Override
    public MatchRespenseDtos ajouterMatch(MatchRequestDtos matchRequestDtos){
        if (matchRequestDtos.getDate() == null || matchRequestDtos.getNombreTickets() == null
                || matchRequestDtos.getLieux()==null || matchRequestDtos.getLieux().isEmpty()
                || matchRequestDtos.getEquipe1() == null || matchRequestDtos.getEquipe1().isEmpty()
                || matchRequestDtos.getEquipe2() == null || matchRequestDtos.getEquipe2().isEmpty())
            throw new RuntimeException("Champs Manque");
        if (matchRequestDtos.getNombreTickets() > 2022 || matchRequestDtos.getNombreTickets() <= 0)
            throw new RuntimeException("Non valide nombre des tickets");
        Match match = new Match();
        match.setDate(matchRequestDtos.getDate());
        match.setLieux(matchRequestDtos.getLieux());
        match.setEquipe1(matchRequestDtos.getEquipe1());
        match.setEquipe2(matchRequestDtos.getEquipe2());
        match.setRef(UUID.randomUUID().toString());
        match.setNombreTickets(matchRequestDtos.getNombreTickets());
        Match savedMatch = matchRepository.save(match);
        return mapperService.fromMatch(savedMatch);
    }
    @Override
    public List<MatchRespenseDtos> gamesList(){
        return matchRepository.findAll().stream().map(
                g -> mapperService.fromMatch(g)
        ).collect(Collectors.toList());
    }
}
