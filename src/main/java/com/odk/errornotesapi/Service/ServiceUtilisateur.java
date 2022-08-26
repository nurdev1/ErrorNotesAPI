package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Utilisateur;

public interface ServiceUtilisateur {
    String Inscrire(Utilisateur Utilisateur);
    String Seconnecter(Utilisateur utilisateur);
}
