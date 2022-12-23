package com.example.gestiondeticket.dtos.respenses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatchRespenseDtos {
    private Long id;
    private String ref;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
    private String equipe1;
    private String equipe2;
    private String lieux;
}
