package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Utilisateur;

import java.util.List;

public interface ServiceUtilisateur {
    String Inscrire(Utilisateur utilisateur);
    String Seconnecter(Utilisateur utilisateur);
    String Sedeconnecter(Utilisateur utilisateur);
    List<Utilisateur> Afficher(Utilisateur utilisateur);
}
