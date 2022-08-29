package com.odk.errornotesapi.Service.Implementation;

import com.odk.errornotesapi.Repository.RepositorySolution;
import com.odk.errornotesapi.Service.ServiceSolution;
import com.odk.errornotesapi.modele.Commentaire;
import com.odk.errornotesapi.modele.Solution;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceImpleSolution implements ServiceSolution {
    final private RepositorySolution repositorySolution;
    @Override
    public String soumettreSolution(Solution solution) {
        repositorySolution.save(solution);
        return "Solution Ajouter avec succès";
    }

    @Override
    public List<Solution> Voirsolution() {

        return repositorySolution.findAll();
    }

    @Override
    public Commentaire Commenter(Solution solution) {

        return null;
    }

    @Override
    public List<Solution> TousLesInfos() {
        return repositorySolution.InformationSolution();
    }
}
