package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositoryCommentaire;
import com.odk.errornotesapi.Repository.RepositoryUtilisateur;
import com.odk.errornotesapi.modele.Commentaire;
import com.odk.errornotesapi.modele.Probleme;
import com.odk.errornotesapi.modele.Role;
import com.odk.errornotesapi.modele.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceImpleCommentaire implements ServiceCommentaire {

   private final RepositoryCommentaire repositoryCommentaire;
    private final RepositoryUtilisateur repositoryUtilisateur;
    Utilisateur utilisateur;

    @Override
    public String AjouterCommenaire(Commentaire commentaire, String email) {
        if (repositoryUtilisateur.existsByEmail(email)) {
            Utilisateur utilisateur = repositoryUtilisateur.findByEmail(email);
            commentaire.setUtilisateur(utilisateur);
            repositoryCommentaire.save(commentaire);
            return "Problème ajouté avec succès";
        }
        return "Vous avez pas le droits d'ajouter un problème";
    }


    @Override
    public String SupprimerCommenaire( Long id, String email) {

        Probleme probleme = new Probleme();
        if (repositoryUtilisateur.existsByEmail(email)) {
            Utilisateur utilisateur = repositoryUtilisateur.findByEmail(email);
            utilisateur.setRole(Role.valueOf("ADMIN_ROLE"));
            probleme.setUtilisateur(utilisateur);
            repositoryCommentaire.deleteById(id);;
            return "Problème ajouté avec succès";
        }
        return "Vous avez pas le droits de supprimer un problème";
    }


    @Override
    public List<Commentaire> AfficherListe() {

        return repositoryCommentaire.findAll();
    }
}
