package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUtilisateur extends JpaRepository<Utilisateur,Long> {
}
