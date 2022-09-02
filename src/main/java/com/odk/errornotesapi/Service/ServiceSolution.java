package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Solution;

import java.util.List;

public interface ServiceSolution {
    String soumettreSolution(Solution solution,String email,String titre);
    List<Solution> Voirsolution();
    void supprimerSolution(Long id);
    public String MettreAjour(Solution solution, long id);
}
