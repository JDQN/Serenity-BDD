import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SerenityRunner.class)
public class SerenityInitialTests {

    /*
    * url base para probar la api
    */
    private static final String REST_API_URL = "https://reqres.in/api";
    @Test
    public void getUsers(){
        Actor juan = Actor.named("JuanQA")
                .whoCan(CallAnApi.at(REST_API_URL));

        juan.attemptsTo(
                Get.resource("/users?page=2")
        );
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
        //assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(400);
    }
}
