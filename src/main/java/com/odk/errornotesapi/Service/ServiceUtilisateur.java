package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Role;
import com.odk.errornotesapi.modele.Utilisateur;

import java.util.List;

public interface ServiceUtilisateur {
    Utilisateur Inscrire(Utilisateur utilisateur);
    Utilisateur Seconnecter(String email,String password);
    Utilisateur loadUserByUsername(String username);
    String Sedeconnecter(Utilisateur utilisateur);
    List<Utilisateur> Afficher();
    Role addNewRole(Role role);
    void addRoleToUser(String username,String roleName);

}
