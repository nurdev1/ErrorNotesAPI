package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Utilisateur;

import java.util.List;

public interface ServiceUtilisateur {
    String Inscrire(Utilisateur utilisateur);
    String Seconnecter(String email,String password);
    String Sedeconnecter(Utilisateur utilisateur);
    List<Utilisateur> AfficherListe(Utilisateur utilisateur);

}
