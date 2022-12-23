package com.example.gestiondeticket.entities;

import com.example.gestiondeticket.enums.StatusTicket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String ref;
    @ManyToOne
    private Match match;

    @Enumerated(EnumType.STRING)
    private StatusTicket statusTicket;
}
