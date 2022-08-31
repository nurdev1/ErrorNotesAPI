package com.odk.errornotesapi.modele;


import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;


@Entity
@Data
@Api("API pour les opérations CRUD sur les utilisateurs.")

@RestController
public class Utilisateur  {
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
