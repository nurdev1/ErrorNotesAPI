package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Commentaire;
import com.odk.errornotesapi.modele.Solution;

import java.util.List;
import java.util.Optional;

public interface ServiceSolution {
    String soumettreSolution(Solution solution);
    List<Solution> Voirsolution();
    void supprimerSolution(Long id);
}
