package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Commentaire;
import com.odk.errornotesapi.modele.Solution;

import java.util.Optional;

public interface ServiceSolution {
    String soumettreSolution(Solution solution);
    Solution Voirsolution(Long id_solution);
    Commentaire Commenter(Solution solution);
}
