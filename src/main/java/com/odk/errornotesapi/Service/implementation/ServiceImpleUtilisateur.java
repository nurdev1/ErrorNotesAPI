package com.odk.errornotesapi.Service.implementation;

import com.odk.errornotesapi.Repository.RepositoryUtilisateur;
import com.odk.errornotesapi.Service.ServiceUtilisateur;
import com.odk.errornotesapi.modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

public class ServiceImpleUtilisateur implements ServiceUtilisateur {
    @Autowired
    private RepositoryUtilisateur repositoryUtilisateur;

    private AuthenticationManager authenticationManager;


    @Override
    public String Inscrire(Utilisateur utilisateur) {
        if(repositoryUtilisateur.existeByEmail(utilisateur.getEmail())){
            System.out.println("Cet email est deja pris");
        }


      /*  utilisateur.setNom(utilisateur.getNom());
        utilisateur.setPrenom(utilisateur.getPrenom());
        utilisateur.setEmail(utilisateur.getEmail());
        utilisateur.setMotdePasse(utilisateur.getMotdePasse());
        utilisateur.setRole(utilisateur.getRole());

        */
        repositoryUtilisateur.save(utilisateur);

        return "Utilisateur inscrit avec succès";
    }

    @Override
    public String Seconnecter(Utilisateur utilisateur) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                utilisateur.getEmail(), utilisateur.getMotdePasse()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "Connecter avec succès";
    }
}
