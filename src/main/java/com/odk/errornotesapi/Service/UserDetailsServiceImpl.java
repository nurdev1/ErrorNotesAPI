package com.odk.errornotesapi.Service;

import com.odk.errornotesapi.modele.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
   private ServiceUtilisateur serviceUtilisateur;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = serviceUtilisateur.loadUserByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        utilisateur.getRole().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return new User(utilisateur.getUsername(), utilisateur.getPassword(), authorities);

    }
}
