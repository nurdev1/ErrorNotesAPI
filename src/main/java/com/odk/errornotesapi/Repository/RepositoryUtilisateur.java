package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.ERole;
import com.odk.errornotesapi.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryUtilisateur extends JpaRepository<Utilisateur,Long> {
    boolean existsByEmail(String email);
    Utilisateur findByUsername(String username);
    Utilisateur findByEmail(String email);
    boolean existsByPassword(String motdePasse);
}
