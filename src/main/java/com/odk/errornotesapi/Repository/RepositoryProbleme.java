package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryProbleme extends JpaRepository<Probleme, Long> {

    @Query(value = "SELECT * from probleme;",nativeQuery = true)
    public List<Probleme> TrouverProblemeParMot();
    @Query(value = "SELECT titre,description_probleme,description,methode,technologie,ressource,etat FROM probleme,solution where probleme.id_probleme=solution.id_probleme;",nativeQuery = true )
    public List<Probleme> ProblemeSolution();
}
