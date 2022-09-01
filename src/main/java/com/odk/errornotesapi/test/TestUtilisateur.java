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
/*déclenche le mécanisme permettant de tester les controllers.
 On indique également le ou les controllers concernés.
 */
public class TestUtilisateur {

    @Autowired
    public MockMvc mockMvc;
    /*L’attribut mockMvc est un autre élément important. Il permet d’appeler la
    méthode “perform” qui déclenche la requête.
     */

    @Test
    public void TestGetUtilisateur() throws Exception {
        mockMvc.perform(get("/Utilisateur"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("")));
    }
    /*L’attribut annoté @MockBean a disparu, plus besoin d’un mock pour ServiceUtilisateur,
     car ce dernier a été injecté grâce à @Test.

En plus de vérifier si le statut vaut 200, on vérifie le contenu retourné grâce à jsonPath("$[0].email", is("")).

$ pointe sur la racine de la structure JSON.

[0] indique qu’on veut vérifier le premier élément de la liste.

firstName désigne l’attribut qu’on veut consulter.

is(“...”) est ce que l’on attend comme résultat.*/
}
