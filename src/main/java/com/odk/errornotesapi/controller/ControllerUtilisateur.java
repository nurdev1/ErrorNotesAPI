package com.odk.errornotesapi.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odk.errornotesapi.JWTUtil;
import com.odk.errornotesapi.Service.ServiceUtilisateur;
import com.odk.errornotesapi.modele.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/Utilisateur")
public class ControllerUtilisateur {
    @Autowired
    private final ServiceUtilisateur serviceUtilisateur;

    @PostMapping("/Inscrire")
    public Utilisateur Inscrire(@RequestBody Utilisateur utilisateur){
        return serviceUtilisateur.Inscrire(utilisateur);
    }
    @PostMapping("/Seconnecter")
    public Utilisateur Seconnecter(@PathVariable String email, @PathVariable String password){
        return serviceUtilisateur.Seconnecter(email,password);
    }
    @GetMapping("/Afficher")
    public List<Utilisateur> Afficher(){
        return serviceUtilisateur.Afficher();
    }

    @GetMapping("/profile")
    public Utilisateur profile(Principal principal){
        return serviceUtilisateur.loadUserByUsername(principal.getName());
    }

    @GetMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String auhToken = request.getHeader(JWTUtil.AUTH_HEADER);
        if(auhToken != null && auhToken.startsWith(JWTUtil.PREFIX)){
            try{
                String jwt = auhToken.substring(JWTUtil.PREFIX.length());
                Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String username = decodedJWT.getSubject();
                Utilisateur utilisateur = serviceUtilisateur.loadUserByUsername(username);
                String jwtAccesToken = JWT.create()
                        .withSubject(utilisateur.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+JWTUtil.EXPIRE_REFRESH_TOKEN))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",utilisateur.getRole().stream().map(r->r.getRoleName()).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String,String> idToken = new HashMap<>();
                idToken.put("acces-token",jwtAccesToken);
                idToken.put("refresh-token",jwt);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(),idToken);

            }catch (Exception e){
                throw e;
            }
        }
        else{
            throw new RuntimeException("Refresh token required!!!");
        }
    }
}
