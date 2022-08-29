package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositorySolution extends JpaRepository<Solution, Long> {


  //  @Query(value = "select * from probleme where id =:id_solution;",nativeQuery = true)
   // public Solution TrouverSolution(@Param("id_solution") Long id_solution);
}
