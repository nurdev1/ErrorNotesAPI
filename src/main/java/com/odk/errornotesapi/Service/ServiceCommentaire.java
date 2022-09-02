package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Commentaire;

import java.util.List;

public interface ServiceCommentaire {
    String AjouterCommenaire(Commentaire commentaire, String email);
    String SupprimerCommenaire( Long id, String email);
    List<Commentaire> AfficherListe();

}
