package com.odk.errornotesapi.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_utilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String numero;
    @Enumerated(EnumType.STRING)
    private Role role;

}
