package com.odk.errornotesapi.modele;

import io.swagger.annotations.Api;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Getter
@Setter
@Api("API pour les opérations CRUD sur les Solutions.")

@RestController
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_solution;
    String methode;
    String descriptionSolution;
    String ressource;
    private LocalDateTime dateSolution = LocalDateTime.now();

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_probleme", nullable = false)
    private Probleme probleme;


}
