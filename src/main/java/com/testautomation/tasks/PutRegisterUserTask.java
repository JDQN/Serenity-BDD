package com.testautomation.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutRegisterUserTask implements Task {
	
	private final Object userInfo;
	
	
	public PutRegisterUserTask(Object userInfo){
		this.userInfo = userInfo;
	}
	
	
	public static Performable withInfo(Object userInfo){
		return instrumented(PostRegisterUserTask.class, userInfo);
	}
	
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Put.to("/users").with(
						requestSpecification -> requestSpecification
		                  .contentType(ContentType.JSON)
		                  .body(userInfo)
				)
		);
	}
}
