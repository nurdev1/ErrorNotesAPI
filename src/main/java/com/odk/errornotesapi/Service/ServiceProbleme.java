package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Probleme;

import java.util.List;

public interface ServiceProbleme {
    String SoumettreProbleme(Probleme probleme, String email);
    List<Probleme> VoirProbleme();
    List<Probleme> RechercherProblemeParMot(Long id_probleme);
    void SupprimerProbleme(Long id,String email);
    List<Probleme> AfficherListe();
}
