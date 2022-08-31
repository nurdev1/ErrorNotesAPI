package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositoryUtilisateur;
import com.odk.errornotesapi.modele.Utilisateur;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceImpleUtilisateur implements ServiceUtilisateur {
    private final RepositoryUtilisateur repositoryUtilisateur;


    //Creation d'un nouveau compte
    @Override
    public String Inscrire(Utilisateur utilisateur) {
        if (repositoryUtilisateur.existsByEmail(utilisateur.getEmail())){
            return "Cet email est deja pris";
        }

        repositoryUtilisateur.save(utilisateur);
        return "Utilisateur enregistrer avec succès";
    }

    @Override
    public String Seconnecter(String email,String password) {
       if(repositoryUtilisateur.existsByEmail(email) && repositoryUtilisateur.existsByPassword(password)){
           return "Connecter avec succès";
       };
       if (repositoryUtilisateur.existsByEmail(email) == false){
           return "Email non trouver";
       }
        return "Mots de passe ou email incorrect";
    }

    @Override
    public String Sedeconnecter(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public List<Utilisateur> Afficher(Utilisateur utilisateur) {
        return repositoryUtilisateur.findAll();
    }
}
