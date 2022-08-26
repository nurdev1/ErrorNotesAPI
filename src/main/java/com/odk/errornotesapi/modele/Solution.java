package com.odk.errornotesapi.modele;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_solution;
    String methode;
    String description;
    String ressource;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_probleme", nullable = false)
    private Probleme probleme;
    @ManyToOne
    Utilisateur utilisateur;
}
