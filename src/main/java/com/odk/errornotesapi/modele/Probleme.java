package com.odk.errornotesapi.modele;

import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Api("API pour les opérations CRUD sur les problemes.")

@RestController
public class Probleme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idprobleme;
    private String titre;
    private String descriptionProbleme;
    private String technologie;
    private LocalDateTime dateProbleme = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
   private Utilisateur utilisateur;


}
