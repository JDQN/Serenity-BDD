import com.testautomation.questions.GetUsersQuestion;
import com.testautomation.questions.ResponseCode;
import com.testautomation.tasks.GetUsersTask;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(SerenityRunner.class)
public class SerenityBddTest {

    private static final String REST_API_URL = "https://reqres.in/api";

    @Test
    public void initialTrest(){
        Actor david = Actor.named("David el QA")
                .whoCan(CallAnApi.at(REST_API_URL));

        david.attemptsTo(
                GetUsersTask.fromPage(2)
        );

        //assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
        david.should(
                seeThat("el codigo de respuesta", ResponseCode.was(), equalTo(200))
        );
    }
}
