import com.testautomation.models.users.Datum;
import com.testautomation.questions.GetUsersQuestion;
import com.testautomation.questions.ResponseCode;
import com.testautomation.tasks.GetUsersTask;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


@RunWith(SerenityRunner.class)
public class UsersTest {

    private static final String REST_API_URL = "https://reqres.in/api";
  
    @Test
    public void initialTrest(){
        Actor david = Actor.named("David el QA")
                .whoCan(CallAnApi.at(REST_API_URL));

        david.attemptsTo(
                GetUsersTask.fromPage(1)
        );

        //assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
        david.should(
                seeThat("el codigo de respuesta", ResponseCode.was(), equalTo(200))
        );

        //Aqui creamos una variable que nos va a dar el usuario espesifico
        Datum user = new GetUsersQuestion().answeredBy(david)
                .getData()//getData trae todos los datos
                .stream() //con el stream de java puedio hacer el filter
                .filter(x -> x.getId() == 1).findFirst()
                .orElse(null);// nos debuelve un null por si no hay un usuario con id 1

        david.should(
                seeThat("el usuario no es nulo", act -> user, notNullValue())
        );

        david.should(
                seeThat("el email del usuario", act -> user.getEmail(), equalTo("george.bluth@reqres.in")),
                seeThat("el avatar del usuario", act -> user.getAvatar(), equalTo("https://reqres.in/img/faces/1-image.jpg"))
        );
    }
}
