package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Probleme;

public interface ServiceProbleme {
    Probleme SoumettreProbleme(Probleme probleme);
    Probleme VoirProbleme(Probleme probleme);
    Probleme RechercherProbleme(String titre);
}
