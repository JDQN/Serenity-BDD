package com.testautomation.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseCode implements Question {

    //Question es un metodo static el cual debuelve un integer
    public static Question<Integer> was(){
        return new ResponseCode();
    }

    //implementamso el metodo answeredBy
    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}



