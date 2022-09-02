package com.odk.errornotesapi.controller;


import com.odk.errornotesapi.Service.ServiceProbleme;
import com.odk.errornotesapi.Service.ServiceUtilisateur;
import com.odk.errornotesapi.modele.Probleme;
import com.odk.errornotesapi.modele.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
// Permet de donner un prefixe generale à tous mes routes
@RequestMapping(path = "/Probleme")
@AllArgsConstructor
public class ControllerProbleme {

    final private ServiceProbleme serviceProbleme;
    final private Utilisateur utilisateur;

    @PostMapping("/Ajouter/{email}")
    public String add(@RequestBody Probleme probleme, @PathVariable String email){
        return this.serviceProbleme.SoumettreProbleme(probleme,email);
    }
    @GetMapping("/ChercherAvecMotCle/{mots}")
    public List<Probleme> Chercher(@PathVariable String mots){
    //On creer un tableau pour mettre la liste des probleme a retrouver et un autre pour tous les probleme
        List<Probleme> problemesAretourner = new ArrayList<>();
        List<Probleme> tousProblemes = serviceProbleme.AfficherListe();
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

    @GetMapping(path ="/Afficher")
    public List<Probleme> VoirProbleme(){
        return this.serviceProbleme.VoirProbleme(); }

    @DeleteMapping(path = "/Supprimer/{id}/{email}")
    public String SupprimerProbleme(@PathVariable long id, @PathVariable String email){
        if(!Objects.equals(utilisateur.getEmail(), "fs1@gmail.com")){
        serviceProbleme.SupprimerProbleme(id,email);
            System.out.println("vous ne pouvez supprimer ce role"); }
        return "probleme supprimé avec succès"; }


    }

