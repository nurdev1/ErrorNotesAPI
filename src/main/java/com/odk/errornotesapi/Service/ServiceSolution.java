package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Commentaire;
import com.odk.errornotesapi.modele.Solution;

public interface ServiceSolution {
    Solution soumettreSolution(Solution solution);
    Solution Voirsolution(Solution solution);
    Commentaire Commenter(Solution solution);
}
