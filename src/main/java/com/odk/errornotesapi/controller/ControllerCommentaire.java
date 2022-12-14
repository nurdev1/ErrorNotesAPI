package com.odk.errornotesapi.controller;

import com.odk.errornotesapi.Service.ServiceCommentaire;
import com.odk.errornotesapi.modele.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PostMapping("/ajout")
    public Commentaire add(@RequestBody Commentaire commentaire){
        return this.serviceCommentaire.AjouterCommenaire(commentaire);}
    @GetMapping("/Afficher")
    public List<Commentaire> Afficher(){
        return serviceCommentaire.Afficher();
    }
    @PreAuthorize("hasAuthotity('ADMIN_ROLE')")
    @DeleteMapping("/supprimer/{id}")
    public String SupprimerCommenaire(@PathVariable(name = "id") Long id) {
        serviceCommentaire.SupprimerCommenaire(id);

        return "commentaire supprimé avec succès";
    }


}
