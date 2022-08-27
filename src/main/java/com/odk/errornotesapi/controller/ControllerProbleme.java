package com.odk.errornotesapi.controller;


import com.odk.errornotesapi.Service.ServiceProbleme;
import com.odk.errornotesapi.modele.Probleme;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
// Permet de donner un prefixe generale à tous mes routes
@RequestMapping(path = "/apierrornotesprobleme")
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
        String[] tabMots = mots.split(":");
        for (Probleme p : tousProblemes){
            for (String m: tabMots){
                if (p.getTitre().contains(m) || p.getDescriptionProbleme().contains(m) || p.getTechnologie().contains(m)){
                    problemesAretourner.add(p); }
            }
        } return problemesAretourner; }

    @GetMapping(path ="/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Probleme> list(){
        return this.serviceProbleme.VoirProbleme(); }

    @DeleteMapping(path = "/supprimer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void SupprimerProbleme(@PathVariable long id){
        this.serviceProbleme.SupprimerProbleme(id); }



}
