package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositoryCommentaire;
import com.odk.errornotesapi.modele.Commentaire;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceImpleCommentaire implements ServiceCommentaire {

   private final RepositoryCommentaire repositoryCommentaire;
    @Override
    public Commentaire AjouterCommenaire(Commentaire commentaire) {
        return repositoryCommentaire.save(commentaire);
    }

    @Override
    public void SupprimerCommenaire( Long id) {
        repositoryCommentaire.deleteById(id);
    }


    @Override
    public List<Commentaire> Afficher() {
        return repositoryCommentaire.findAll();
    }
}
