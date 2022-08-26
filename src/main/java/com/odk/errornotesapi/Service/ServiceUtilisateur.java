package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Utilisateur;

public interface ServiceUtilisateur {
    Utilisateur Inscrire(Utilisateur utilisateur);
    Utilisateur Seconnecter(Utilisateur utilisateur);
}
