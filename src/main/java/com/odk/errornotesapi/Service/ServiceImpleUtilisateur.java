package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.Repository.RepositoryRole;
import com.odk.errornotesapi.Repository.RepositoryUtilisateur;


import com.odk.errornotesapi.modele.Role;
import com.odk.errornotesapi.modele.Utilisateur;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@AllArgsConstructor
@Service
@Transactional
public class ServiceImpleUtilisateur implements ServiceUtilisateur {
    private final RepositoryUtilisateur repositoryUtilisateur;
    private final RepositoryRole repositoryRole;
    private final PasswordEncoder passwordEncoder;

    //Creation d'un nouveau compte
    @Override
    public Utilisateur Inscrire(Utilisateur utilisateur) {
        String pw = utilisateur.getPassword();
        utilisateur.setPassword(passwordEncoder.encode(pw));
        return  repositoryUtilisateur.save(utilisateur);

    }

    @Override
    public Utilisateur Seconnecter(String email,String password) {
     /*  if(repositoryUtilisateur.existsByEmail(email) && repositoryUtilisateur.existsByPassword(password)){
           return repositoryUtilisateur.findByEmail(email);
       };
       if (repositoryUtilisateur.existsByEmail(email) == false){
           return null;
       }
        return null;

      */
        return null;
    }


    @Override
    public Utilisateur loadUserByUsername(String username) {
        return repositoryUtilisateur.findByUsername(username);
    }

    @Override
    public String Sedeconnecter(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public List<Utilisateur> Afficher() {
        return repositoryUtilisateur.findAll();
    }

    @Override
    public Role addNewRole(Role role) {
        return repositoryRole.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Utilisateur utilisateur = repositoryUtilisateur.findByUsername(username);
        Role role = repositoryRole.findByRoleName(roleName);
        utilisateur.getRole().add(role);
    }
}
