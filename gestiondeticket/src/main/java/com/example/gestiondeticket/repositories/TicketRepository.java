package com.example.gestiondeticket.repositories;

import com.example.gestiondeticket.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
