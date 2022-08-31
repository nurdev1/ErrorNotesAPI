package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositorySolution;
import com.odk.errornotesapi.modele.Solution;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceImpleSolution implements ServiceSolution {
    final private RepositorySolution repositorySolution;
    @Override
    public String soumettreSolution(Solution solution) {
        repositorySolution.save(solution);
        return "Solution ajoutée avec succès";
    }

    @Override
    public List<Solution> Voirsolution() {
        return repositorySolution.findAll();
    }

    @Override
    public void supprimerSolution(Long id) {
        repositorySolution.deleteById(id);
    }


}
