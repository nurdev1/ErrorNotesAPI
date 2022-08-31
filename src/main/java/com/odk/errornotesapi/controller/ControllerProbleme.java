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
@RequestMapping(path = "/probleme")
@AllArgsConstructor
public class ControllerProbleme {

    final private ServiceProbleme serviceProbleme;

    @PostMapping("/ajout")
    public Probleme add(@RequestBody Probleme probleme){
        return this.serviceProbleme.SoumettreProbleme(probleme);
    }
    @GetMapping("/ChercherAvecMotCle/{mots}")
    public List<Probleme> Afficher(@PathVariable String mots){
    //On creer un tableau pour mettre la liste des probleme a retrouver et un autre pour tous les probleme
        List<Probleme> problemesAretourner = new ArrayList<>();
        List<Probleme> tousProblemes = serviceProbleme.Afficher();
        //on met le mot donnée dans un tableau et avec la fonction split qui permet de decouper chaque mot
        String[] tabMots = mots.split(":");
        //creation d'un objet probleme et parcour de la liste tous les problemes
        for (Probleme p : tousProblemes){
            //une variable m de type tousprobemes
            for (String m: tabMots){
                //recherche avec la fonction containes si mot objet est dans la liste des probleme contenu dans tousProblemes
                if (p.getTitre().contains(m) || p.getDescriptionProbleme().contains(m) || p.getTechnologie().contains(m)){
                    //apres on ajoute l'objet dans probleme A retourner
                    problemesAretourner.add(p); }
            }
        } return problemesAretourner; }

    @GetMapping(path ="/list")
    public List<Probleme> VoirProbleme(){
        return this.serviceProbleme.VoirProbleme(); }

    @DeleteMapping(path = "/supprimer/{id}")
    public String SupprimerProbleme(@PathVariable long id){
        serviceProbleme.SupprimerProbleme(id);

    return "probleme supprimé avec succès";}

    }

