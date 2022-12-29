package com.testautomation.questions;

import com.testautomation.models.users.Users;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUsersQuestion implements Question {

    //implementamso el metodo answeredBy
    @Override
    public Users answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Users.class);//Aqui UsersModel contine todas las propiedades del modelo UsersModel
    }
}
