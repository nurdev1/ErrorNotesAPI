package com.odk.errornotesapi.Service;


import com.odk.errornotesapi.modele.Solution;

import java.util.List;


public interface ServiceSolution {
    String soumettreSolution(Solution solution);
    List<Solution> Voirsolution();
    String Supprimer(Long id_solution);
}
