package com.odk.errornotesapi.Service;

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
        boolean ADMIN_ROLE=true;
        Optional<Commentaire> commentaire = this.repositoryCommentaire.findById(id);
        if(!commentaire.isPresent()&&  ADMIN_ROLE ){
                throw new exceptionCommentaire(String.format("commentaire  supprimé avec succès"+id));
            } this.repositoryCommentaire.delete(commentaire.get()); 
    }


    @Override
    public Commentaire CommenterSolution(Commentaire commentaire) {
        return null;
    }

    @Override
    public List<Commentaire> Afficher() {
        return repositoryCommentaire.findAll();
    }
}
