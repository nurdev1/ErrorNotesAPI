package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Commentaire;
import com.odk.errornotesapi.modele.Probleme;

import java.util.ArrayList;
import java.util.List;

public interface ServiceProbleme {
    Probleme SoumettreProbleme(Probleme probleme);
    List<Probleme> VoirProbleme();
    List<Probleme> RechercherProblemeParMot(Long id_probleme);
    void SupprimerProbleme(Long id, String email);
    List<Probleme> Afficher();
    List<Probleme> ProblemeAvecSolution();
}
