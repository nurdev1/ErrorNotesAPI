package com.odk.errornotesapi.test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestProbleme {
    @Autowired
    public MockMvc mockMvc;

    @Test
    public void  TestgetProbleme() throws Exception{
            mockMvc.perform(get("/Probleme"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.description_probleme", is("teeet")));
        }
        /*L’attribut annoté @MockBean a disparu, plus besoin d’un mock pour ServiceProbleme,
        car ce dernier a été injecté grâce à @Test.

En plus de vérifier si le statut vaut 200, on vérifie le contenu retourné grâce à jsonPath("$[0].firstName", is("...")).

$ pointe sur la racine de la structure JSON.

[0] indique qu’on veut vérifier le premier élément de la liste.

descriptionProbleme désigne l’attribut qu’on veut consulter.

is(“...”) est ce que l’on attend comme résultat.*/
    }


