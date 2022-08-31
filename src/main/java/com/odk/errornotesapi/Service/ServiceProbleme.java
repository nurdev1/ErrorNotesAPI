package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Probleme;

import java.util.List;

public interface ServiceProbleme {
    Probleme SoumettreProbleme(Probleme probleme);
    List<Probleme> VoirProbleme();
    List<Probleme> RechercherProblemeParMot(Long id_probleme);
    void SupprimerProbleme(Long id);
    List<Probleme> Afficher();
}
