package com.odk.errornotesapi.Service.implementation;

import com.odk.errornotesapi.Repository.RepositoryCommentaire;
import com.odk.errornotesapi.Service.ServiceCommentaire;
import com.odk.errornotesapi.modele.Commentaire;

import java.util.Optional;

public class ServiceImpleCommentaire implements ServiceCommentaire {

    RepositoryCommentaire repositoryCommentaire;
    @Override
    public Commentaire AjouterCommenaire(Commentaire commentaire) {
        return repositoryCommentaire.save(commentaire);
    }

    @Override
    public void SupprimerCommenaire(Long id) {
        Optional<Commentaire> commentaire = this.repositoryCommentaire.findById(id);
        if(!commentaire.isPresent()){
         System.out.println("commentaire supprimer avec succès");
        }
        this.repositoryCommentaire.delete(commentaire.get());
    }

    @Override
    public Commentaire CommenterSolution(Commentaire commentaire) {
        return null;
    }
}
