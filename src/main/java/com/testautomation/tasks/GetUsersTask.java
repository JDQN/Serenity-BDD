package com.testautomation.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;


/*
 * @Class GetUsers implememntamos la Task
 * Tambien implementamos el metodo Performable
*/
public class GetUsersTask implements Task {

    // PAGE es una variable final la cual no va hacer modificada
    private final int PAGE;


    // GetUsers es el constructor
    public GetUsersTask(int page){
        this.PAGE = page;
    }

    //Performable es una metodo static que debiuelve un tipo Performable
    public static Performable fromPage(int page){

        /*
         El metodo instrumented Sirve para que en el reporte se pinten ciertas cosas
         Y poder resivir el parametro en el constructor
        */
        return instrumented(GetUsersTask.class, page);
    }

    /*
    * Con with podemos agregar mas cosas
    * como los header, contentType entre otras
    * @Override ya tendriamos nuestro Task
    */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users?page=" + PAGE)
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                .header("header1", "value1"))
        );

    }

}
