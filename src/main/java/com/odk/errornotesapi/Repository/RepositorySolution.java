package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorySolution extends JpaRepository<Solution, Long> {



}
