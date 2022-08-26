package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Utilisateur;

public interface ServiceUtilisateur {
    String Inscrire(Utilisateur utilisateur);
    String Seconnecter(Utilisateur utilisateur);
}
