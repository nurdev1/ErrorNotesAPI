package com.odk.errornotesapi.Service.implementation;

import com.odk.errornotesapi.Repository.RepositorySolution;
import com.odk.errornotesapi.Service.ServiceSolution;
import com.odk.errornotesapi.modele.Commentaire;
import com.odk.errornotesapi.modele.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpleSolution implements ServiceSolution {
    @Autowired
    RepositorySolution repositorySolution;
    @Override
    public String soumettreSolution(Solution solution) {
        repositorySolution.save(solution);
        return "Solution Ajouter avec succès";
    }

    @Override
    public Solution Voirsolution(Long id_solution) {
        return repositorySolution.TrouverSolution(id_solution);
    }

    @Override
    public Commentaire Commenter(Solution solution) {
        return null;
    }
}