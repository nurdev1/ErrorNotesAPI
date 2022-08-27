package com.odk.errornotesapi.modele;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commentaire;
    private String contenu;
    private LocalDateTime date = LocalDateTime.now();
    @ManyToOne
    Utilisateur utilisateur;

    @ManyToOne
    Solution solution;

}
