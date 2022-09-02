package com.odk.errornotesapi.controller;

import com.odk.errornotesapi.Service.ServiceUtilisateur;
import com.odk.errornotesapi.modele.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Utilisateur")
public class ControllerUtilisateur {
    @Autowired
    private final ServiceUtilisateur serviceUtilisateur;
    @PostMapping("/Inscrire")
    public String Inscrire(@RequestBody Utilisateur utilisateur){
        return serviceUtilisateur.Inscrire(utilisateur);
    }
    @PostMapping("/Seconnecter/{email}/{password}")
    public String Seconnecter( @PathVariable String email, @PathVariable String password){
        return serviceUtilisateur.Seconnecter(email,password);
    }
    @GetMapping("/Afficher")
    public List<Utilisateur> Afficher(Utilisateur utilisateur){
        return serviceUtilisateur.Afficher(utilisateur);
    }

}
