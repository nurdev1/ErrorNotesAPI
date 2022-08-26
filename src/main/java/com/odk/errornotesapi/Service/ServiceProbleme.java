package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Probleme;

public interface ServiceProbleme {
    String SoumettreProbleme();
    Probleme VoirProbleme(Probleme probleme);
}
