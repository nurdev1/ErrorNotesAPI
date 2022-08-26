package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Commentaire;

public interface ServiceCommentaire {
    Commentaire AjouterCommenaire(Commentaire commentaire);
    void SupprimerCommenaire(Long id);
    Commentaire CommenterSolution(Commentaire commentaire);

}
