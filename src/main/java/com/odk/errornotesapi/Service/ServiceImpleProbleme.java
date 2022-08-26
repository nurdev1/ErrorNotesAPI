package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositoryProbleme;
import com.odk.errornotesapi.Service.ServiceProbleme;
import com.odk.errornotesapi.exception.exceptionProbleme;
import com.odk.errornotesapi.modele.Probleme;

import java.util.List;
import java.util.Optional;

public class ServiceImpleProbleme implements ServiceProbleme {

    RepositoryProbleme repositoryProbleme;
    @Override
    public Probleme SoumettreProbleme(Probleme probleme) {
        return repositoryProbleme.save(probleme);
    }

    @Override
    public List<Probleme> VoirProbleme(Probleme probleme) {
        return repositoryProbleme.findAll();
    }

    @Override
    public List<Probleme> RechercherProblemeParMot(Long id_probleme) {
        return repositoryProbleme.TrouverProblemeParMot(id_probleme);
    }
    public void SupprimerProbleme(Long id){
        boolean admi=true;
        Optional<Probleme> probleme = this.repositoryProbleme.findById(id);
        if(!probleme.isPresent()&& admi){
            throw new exceptionProbleme(String.format("Problème  supprimé avec succès"+id));
        }
        this.repositoryProbleme.delete(probleme.get());

    }

}
