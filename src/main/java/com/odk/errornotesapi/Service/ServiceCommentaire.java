package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Commentaire;

import java.util.List;

public interface ServiceCommentaire {
    Commentaire AjouterCommenaire(Commentaire commentaire, String email);
    void SupprimerCommenaire( Long id);
    List<Commentaire> AfficherListe();

}
