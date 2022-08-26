package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Commentaire;

public interface ServiceCommentaire {
    Commentaire AjouterCommenaire(Commentaire commentaire);
    String SupprimerCommenaire();
    Commentaire CommenterSolution(Commentaire commentaire)

}
