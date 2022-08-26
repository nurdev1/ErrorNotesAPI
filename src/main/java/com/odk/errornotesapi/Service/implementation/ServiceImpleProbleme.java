package com.odk.errornotesapi.Service.implementation;

import com.odk.errornotesapi.Repository.RepositoryProbleme;
import com.odk.errornotesapi.Service.ServiceProbleme;
import com.odk.errornotesapi.modele.Probleme;

public class ServiceImpleProbleme implements ServiceProbleme {

    RepositoryProbleme repositoryProbleme;
    @Override
    public Probleme SoumettreProbleme(Probleme probleme) {
        return repositoryProbleme.save(probleme);
    }

    @Override
    public Probleme VoirProbleme(Probleme probleme) {
        return null;
    }

    @Override
    public Probleme RechercherProbleme(String titre) {
        return null;
    }


}
