package com.odk.errornotesapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//appliquée à la classe permet de remplacer un fichier de configuration classique en XML
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)

                .select()
                .apis(RequestHandlerSelectors.basePackage("com.odk.errornotesapi"))
                .paths(PathSelectors.any())
                .build();
    }
    //select permet d'initialiser une classe du nom de ApiSelectorBuilder qui donne accès aux méthodes de personnalisation suivantes
    /*Elle permet de filtrer la documentation à exposer selon les contrôleurs. Ainsi, vous pouvez cacher la documentation
     d'une partieprivée ou interne de votre API. Dans ce cas, nous avons utilisé RequestHandlerSelectors.any(). */
    /*RequestHandlerSelectors est un prédicat (introduit depuis Java 8) qui permet de
    retourner TRUE ou FALSE selon la condition utilisée.*/
    /*RequestHandlerSelectors offre plusieurs autres méthodes, comme annotationPresent qui vous permet de définir une
     annotation en paramètre. Swagger ne documente alors que les classes qu'il utilise. La plus utilisée est basePackage qui
     permet de trier selon le Package. Nous allons voir un exemple juste après.*/
/*paths : cette méthode donne accès à une autre façon de filtrer : selon
    l'URI des requêtes. Ainsi, vous pouvez, par exemple, demander à Swagger de ne documenter que les méthodes
    qui répondent à des requêtes commençant par "/public" .*/
    /*basePackage du prédicat RequestHandlerSelectors afin de demander à Swagger de ne rien documenter
    en dehors du package "web" qui contient notre code
     */
}
