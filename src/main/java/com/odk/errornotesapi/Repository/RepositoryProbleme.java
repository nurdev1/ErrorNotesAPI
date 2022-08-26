package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProbleme extends JpaRepository<Probleme, Long> {
}
