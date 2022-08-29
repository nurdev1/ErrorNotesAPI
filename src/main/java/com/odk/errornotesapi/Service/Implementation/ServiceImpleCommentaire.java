package com.odk.errornotesapi.Service.Implementation;

import com.odk.errornotesapi.Repository.RepositoryCommentaire;
import com.odk.errornotesapi.Service.ServiceCommentaire;
import com.odk.errornotesapi.exception.exceptionCommentaire;
import com.odk.errornotesapi.exception.exceptionProbleme;
import com.odk.errornotesapi.modele.Commentaire;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImpleCommentaire implements ServiceCommentaire {

   private final RepositoryCommentaire repositoryCommentaire;
    @Override
    public Commentaire AjouterCommenaire(Commentaire commentaire) {
        return repositoryCommentaire.save(commentaire);
    }

    @Override
    public void SupprimerCommenaire(Long id) {
        boolean admi=true;
        Optional<Commentaire> commentaire = this.repositoryCommentaire.findById(id);
        if(!commentaire.isPresent()&&  admi ){
                throw new exceptionCommentaire(String.format("commentaire  supprimé avec succès"+id));
            } this.repositoryCommentaire.delete(commentaire.get()); 
    }


    @Override
    public Commentaire CommenterUnCommentaire(Commentaire commentaire) {
        return null;
    }

    @Override
    public List<Commentaire> Afficher() {
        return repositoryCommentaire.findAll();
    }
}
