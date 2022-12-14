package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.Etat;
import com.odk.errornotesapi.modele.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositoryProbleme extends JpaRepository<Probleme, Long> {

    @Query(value = "SELECT * from probleme;",nativeQuery = true)
    public List<Probleme> TrouverProblemeParMot();

}
