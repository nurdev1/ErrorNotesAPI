package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Commentaire;

import java.util.List;

public interface ServiceCommentaire {
    Commentaire AjouterCommenaire(Commentaire commentaire);
    void SupprimerCommenaire( Long id);
    Commentaire CommenterUnCommentaire(Commentaire commentaire);
    List<Commentaire> Afficher();

}
