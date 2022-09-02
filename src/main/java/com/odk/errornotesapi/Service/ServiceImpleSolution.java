package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositoryProbleme;
import com.odk.errornotesapi.Repository.RepositorySolution;
import com.odk.errornotesapi.Repository.RepositoryUtilisateur;
import com.odk.errornotesapi.modele.Probleme;
import com.odk.errornotesapi.modele.Solution;
import com.odk.errornotesapi.modele.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImpleSolution implements ServiceSolution {
    final private RepositorySolution repositorySolution;
    final private RepositoryUtilisateur repositoryUtilisateur;
    final private RepositoryProbleme repositoryProbleme;
    @Override
    public String soumettreSolution(Solution solution,String email,String titre) {
        Utilisateur utilisateur = repositoryUtilisateur.findByEmail(email);
        Probleme probleme = repositoryProbleme.findByTitre(titre);
        if(probleme.getUtilisateur()== utilisateur){
            solution.setProbleme(probleme);
            repositorySolution.save(solution);
            return "Solution ajoutée avec succès";
        }

         return "Vous avez pas le droit d'ajouté cette solution" ;

    }

    @Override
    public List<Solution> Voirsolution() {
        return repositorySolution.findAll();
    }

    @Override
    public void supprimerSolution(Long id) {

        repositorySolution.deleteById(id);
    }

    @Override
    public String MettreAjour(Solution solution, long id) {
        return null;
    }


}
