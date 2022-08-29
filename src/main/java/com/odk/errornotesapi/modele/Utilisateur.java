package com.odk.errornotesapi.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_utilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String MotdePasse;
    private String numero;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_utilisateur")
    List<Commentaire> commentaire = new ArrayList<>();



}
