package com.odk.errornotesapi.controller;

import com.odk.errornotesapi.Service.ServiceCommentaire;
import com.odk.errornotesapi.modele.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Permet de donner un prefixe generale à tous mes routes
@RequestMapping(path = "/commentaire")
public class ControllerCommentaire {

    private final ServiceCommentaire serviceCommentaire;

    @Autowired
    public ControllerCommentaire(ServiceCommentaire serviceCommentaire)
    {
        this.serviceCommentaire=serviceCommentaire;
    }
    @PostMapping("/ajout")
    @ResponseStatus(HttpStatus.CREATED)
    public Commentaire add(@RequestBody Commentaire commentaire){
        return this.serviceCommentaire.AjouterCommenaire(commentaire);}
    @GetMapping("/Afficher")
    public List<Commentaire> Afficher(){
        return serviceCommentaire.Afficher();
    }

    @DeleteMapping(path = "/supprimer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void SupprimerProbleme(@PathVariable long id){
        this.serviceCommentaire.SupprimerCommenaire(id); }
}
