package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositoryProbleme;
import com.odk.errornotesapi.Repository.RepositoryUtilisateur;
import com.odk.errornotesapi.modele.Probleme;
import com.odk.errornotesapi.modele.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ServiceImpleProbleme implements ServiceProbleme {

    private final RepositoryProbleme repositoryProbleme;
    private final RepositoryUtilisateur repositoryUtilisateur;
    Utilisateur utilisateur;
    @Override
    public String SoumettreProbleme(Probleme probleme, String email){
        if (repositoryUtilisateur.existsByEmail(email)) {
            Utilisateur utilisateur = repositoryUtilisateur.findByEmail(email);
            probleme.setUtilisateur(utilisateur);
            repositoryProbleme.save(probleme);
            return "Problème ajouté avec succès";
        }
        return "Vous avez pas le droits d'ajouter un problème";
    }

    @Override
    public List<Probleme> VoirProbleme() {
        return repositoryProbleme.findAll();
    }

    @Override
    public List<Probleme> RechercherProblemeParMot(Long id_probleme) {
        return repositoryProbleme.TrouverProblemeParMot();
    }
    public void SupprimerProbleme(Long id, String email){
                repositoryProbleme.deleteById(id);


    }

    @Override
    public List<Probleme> AfficherListe() {
        return repositoryProbleme.findAll();
    }




}
