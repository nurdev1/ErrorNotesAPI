package com.odk.errornotesapi.modele;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commentaire;
    private String contenu;
    private LocalDateTime date = LocalDateTime.now();

    /*@ManyToOne(
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_commentaire")
    List<Utilisateur> utilisateur = new ArrayList<>();

    @ManyToOne(
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_commentaire")
    List<Solution> solution = new ArrayList<>();*/

}
