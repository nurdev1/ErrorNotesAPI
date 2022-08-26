package com.odk.errornotesapi.modele;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Probleme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "id_probleme")
    private Long id_probleme;
    private String descriptionProbleme;
    private String technologie;
    private String etat;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Solution solution;

    @ManyToOne
    Utilisateur utilisateur;

}
