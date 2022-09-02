package com.odk.errornotesapi.controller;

import com.odk.errornotesapi.Service.ServiceSolution;
import com.odk.errornotesapi.modele.Probleme;
import com.odk.errornotesapi.modele.Solution;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Solution")
public class ControllerSolution {
    private final ServiceSolution serviceSolution;


    @PostMapping("/Ajouter/{email}/{titre}")
    public String soumettreSolution(@RequestBody Solution solution,@PathVariable String email,@PathVariable String titre){
        return serviceSolution.soumettreSolution(solution,email,titre);
    }
    @GetMapping("/AfficherSolution")
    public List<Solution> VoirSolution(){
        return serviceSolution.Voirsolution();
    }
    @DeleteMapping(path = "/Supprimer/{id}")
    public String supprimerSolution(@PathVariable(name = "id") Long id){
         serviceSolution.supprimerSolution(id);
        return "Solution supprimer avec succès";
    }



}
