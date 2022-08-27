package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositoryProbleme;
import com.odk.errornotesapi.exception.exceptionProbleme;
import com.odk.errornotesapi.modele.Probleme;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImpleProbleme implements ServiceProbleme {

    private final RepositoryProbleme repositoryProbleme;
    @Override
    public Probleme SoumettreProbleme(Probleme probleme) {
        return repositoryProbleme.save(probleme);
    }

    @Override
    public List<Probleme> VoirProbleme() {
        return repositoryProbleme.findAll();
    }

    @Override
    public List<Probleme> RechercherProblemeParMot(Long id_probleme) {
        return repositoryProbleme.TrouverProblemeParMot();
    }
    public void SupprimerProbleme(Long id){
        boolean ADMIN_ROLE=true;
        Optional<Probleme> probleme = this.repositoryProbleme.findById(id);
        if(!probleme.isPresent()&& ADMIN_ROLE){
            throw new exceptionProbleme(String.format("Problème  supprimé avec succès"+id));
        }
        this.repositoryProbleme.delete(probleme.get());

    }

    @Override
    public List<Probleme> Afficher() {
        return repositoryProbleme.findAll();
    }

}
