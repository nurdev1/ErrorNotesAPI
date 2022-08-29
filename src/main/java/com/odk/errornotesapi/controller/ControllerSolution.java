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

    @GetMapping("/AfficherSolution")
    public List<Solution> Trouver(){
        return serviceSolution.Voirsolution();
    }
    @PostMapping("/Ajouter")
    public String soumettreSolution(Solution solution){
        return serviceSolution.soumettreSolution(solution);
    }

    @GetMapping(path ="/Information")
    List<Solution> TousLesInfos(){
        return this.serviceSolution.TousLesInfos(); }

}