package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositoryCommentaire;
import com.odk.errornotesapi.Repository.RepositoryProbleme;
import com.odk.errornotesapi.modele.Probleme;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceImpleProbleme implements ServiceProbleme {

    private final RepositoryProbleme repositoryProbleme;
    private final RepositoryCommentaire repositoryCommentaire;
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

        repositoryProbleme.deleteById(id);

    }

    @Override
    public List<Probleme> Afficher() {
        return repositoryProbleme.findAll();
    }




}
