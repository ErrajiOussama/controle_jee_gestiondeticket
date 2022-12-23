package com.example.gestiondeticket.repositories;

import com.example.gestiondeticket.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
