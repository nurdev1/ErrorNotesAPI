package com.odk.errornotesapi;

import com.odk.errornotesapi.Service.ServiceUtilisateur;
import com.odk.errornotesapi.modele.Role;
import com.odk.errornotesapi.modele.Utilisateur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class ErrorNotesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErrorNotesApiApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    CommandLineRunner start(ServiceUtilisateur serviceUtilisateur) {
        return args -> {
            serviceUtilisateur.addNewRole(new Role(null, "USER_ROLE"));
            serviceUtilisateur.addNewRole(new Role(null, "ADMIN_ROLE"));
            serviceUtilisateur.Inscrire(new Utilisateur(null, "ABLO", "Diallo", "Abdoulaye", "d.abdoulayead28@gmail.com", "1234", "82608734", new ArrayList<>()));
            serviceUtilisateur.Inscrire(new Utilisateur(null, "ALASKO", "Malle", "Alassane", "allasanemalle@gmail.com", "1234", "82608734", new ArrayList<>()));
            serviceUtilisateur.addRoleToUser("ABLO","ADMIN_ROLE");
            serviceUtilisateur.addRoleToUser("ALASKO","USER_ROLE");
        };
    }

 */
}

