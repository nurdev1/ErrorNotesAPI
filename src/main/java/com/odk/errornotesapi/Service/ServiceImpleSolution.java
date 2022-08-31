package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositorySolution;
import com.odk.errornotesapi.Repository.RepositoryUtilisateur;
import com.odk.errornotesapi.modele.ERole;
import com.odk.errornotesapi.modele.Solution;
import com.odk.errornotesapi.modele.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.odk.errornotesapi.modele.ERole.ADMIN_ROLE;

@Service
@AllArgsConstructor
public class ServiceImpleSolution implements ServiceSolution {
    final private RepositorySolution repositorySolution;
    final private RepositoryUtilisateur repositoryUtilisateur;
    @Override
    public String soumettreSolution(Solution solution) {
        repositorySolution.save(solution);
        return "Solution ajoutée avec succès";
    }

    public String Supprimer(Long id_solution) {

            repositorySolution.deleteById(id_solution);
            return "Solution avec id = " +id_solution+" supprimé avec succès";
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
