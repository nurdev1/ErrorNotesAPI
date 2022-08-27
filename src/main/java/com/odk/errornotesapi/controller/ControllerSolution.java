package com.odk.errornotesapi.controller;

import com.odk.errornotesapi.Service.ServiceSolution;
import com.odk.errornotesapi.modele.Solution;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/Solution")
public class ControllerSolution {
    private final ServiceSolution serviceSolution;
    @GetMapping("/Trouver")
    Solution Trouver(Long id){
        return serviceSolution.Voirsolution(id);
    }
    @PostMapping("/Ajouter")
    String soumettreSolution(Solution solution){
        return serviceSolution.soumettreSolution(solution);
    }

}
