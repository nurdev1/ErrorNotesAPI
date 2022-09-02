package com.odk.errornotesapi.controller;

import com.odk.errornotesapi.Service.ServiceCommentaire;
import com.odk.errornotesapi.modele.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Permet de donner un prefixe generale à tous mes routes
@RequestMapping(path = "/Commentaire")
public class ControllerCommentaire {

    private final ServiceCommentaire serviceCommentaire;

    @Autowired
    public ControllerCommentaire(ServiceCommentaire serviceCommentaire)
    {
        this.serviceCommentaire=serviceCommentaire;
    }
    @PostMapping("/Ajouter")
    public Commentaire add(@RequestBody Commentaire commentaire, String email){
        return this.serviceCommentaire.AjouterCommenaire(commentaire,email);}
    @GetMapping("/Afficher")
    public List<Commentaire> AfficherListe(){
        return serviceCommentaire.AfficherListe();
    }
    @DeleteMapping("/Supprimer/{id}")
    public String SupprimerCommenaire(@PathVariable(name = "id") Long id) {

        serviceCommentaire.SupprimerCommenaire(id);

        return "commentaire supprimé avec succès";
    }




}
