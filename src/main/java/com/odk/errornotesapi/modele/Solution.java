package com.odk.errornotesapi.modele;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_solution;
    String methode;
    String descriptionSolution;
    String ressource;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_probleme", nullable = false)
    private Probleme probleme;

    @OneToMany(
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_solution")
    List<Commentaire> commentaire = new ArrayList<>();
}
