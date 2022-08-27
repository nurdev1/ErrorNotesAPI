package com.odk.errornotesapi.controller;

import com.odk.errornotesapi.Service.ServiceCommentaire;
import com.odk.errornotesapi.Service.ServiceProbleme;
import com.odk.errornotesapi.modele.Commentaire;
import com.odk.errornotesapi.modele.Probleme;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
// Permet de donner un prefixe generale à tous mes routes
@RequestMapping(path = "/apierrornotesprobleme", name = "probleme")
@AllArgsConstructor
public class ControllerProbleme {

    final private ServiceProbleme serviceProbleme;

    @PostMapping("/ajout")
    @ResponseStatus(HttpStatus.CREATED)
    public Probleme add(@RequestBody Probleme probleme){
        return this.serviceProbleme.SoumettreProbleme(probleme);
    }
    @GetMapping("/Afficher/{mots}")
    public List<Probleme> Afficher(@PathVariable String mots){

        List<Probleme> problemesAretourner = new ArrayList<>();
        List<Probleme> tousProblemes = serviceProbleme.Afficher();
        /*
        String str = "Welcome:dear guest";
        String[] arrOfStr = str.split(":");
        for (String a: arrOfStr)
            System.out.println(a);
         */
        String[] tabMots = mots.split(":");
        for (Probleme p : tousProblemes){
            for (String m: tabMots){
                if (p.getTitre().contains(m) || p.getDescriptionProbleme().contains(m) || p.getTechnologie().contains(m)){
                    problemesAretourner.add(p);
                }
            }
        }


        return problemesAretourner;
    }



}
