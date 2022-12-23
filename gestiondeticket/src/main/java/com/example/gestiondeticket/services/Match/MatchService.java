package com.example.gestiondeticket.services.Match;

import com.example.gestiondeticket.dtos.requests.MatchRequestDtos;
import com.example.gestiondeticket.dtos.respenses.MatchRespenseDtos;


import java.util.List;

public interface MatchService {
    MatchRespenseDtos ajouterMatch(MatchRequestDtos matchRequestDtos);

    List<MatchRespenseDtos> gamesList();
}
