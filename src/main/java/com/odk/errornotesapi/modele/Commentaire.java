package com.odk.errornotesapi.modele;

import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Api("API pour les opérations CRUD sur les commentaires.")

@RestController
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commentaire;
    private String contenu;
    private LocalDateTime dateCommentaire = LocalDateTime.now();

   @ManyToOne
   @JoinColumn(name = "id_solution")
   private Solution solution;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
   @ManyToOne
    @JoinColumn(name = "id_utilisateur")
   private Utilisateur utilisateur;


}
