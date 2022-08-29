package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorySolution extends JpaRepository<Solution, Long> {


  @Query(value = "SELECT id_utilisateur,titre,description_probleme,description,methode,contenu,date technologie,ressource,etat FROM probleme,solution,commentaire where probleme.id_probleme=solution.id_probleme and commentaire.id_solution = solution.id_solution;",nativeQuery = true)
    List<Solution> Infos();
}
