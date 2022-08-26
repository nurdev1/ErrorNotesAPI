package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySolution extends JpaRepository<Solution,Long> {
    Solution TrouverSolution(Long id_solution);
}
