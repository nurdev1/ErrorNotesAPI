package com.odk.errornotesapi.controller;

import com.odk.errornotesapi.Service.ServiceSolution;
import com.odk.errornotesapi.Service.ServiceUtilisateur;
import com.odk.errornotesapi.modele.Solution;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Solution")
public class ControllerSolution {
    private final ServiceSolution serviceSolution;
    final private ServiceUtilisateur serviceUtilisateur;


    @PostMapping("/Ajouter")
    public String soumettreSolution(@RequestBody Solution solution){
        return serviceSolution.soumettreSolution(solution);
    }
    @GetMapping("/AfficherSolution")
    public List<Solution> VoirSolution(){

        return serviceSolution.Voirsolution();
    }
    @DeleteMapping("/Suprimer")
    public String Supprimer(@PathVariable Long id_solution){
        return serviceSolution.Supprimer(id_solution);

    }


}
