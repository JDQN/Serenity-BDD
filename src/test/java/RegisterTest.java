import com.testautomation.facts.NetflixPlans;
import com.testautomation.models.users.CreateUserModel;
import com.testautomation.models.users.UpdateUserModel;
import com.testautomation.questions.ResponseCode;
import com.testautomation.tasks.PostRegisterUserTask;
import com.testautomation.tasks.PutRegisterUserTask;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hibernate.sql.Update;
import org.junit.Test;
import org.junit.runner.RunWith;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SerenityRunner.class)
public class RegisterTest {
	
	private static final String REST_API_URL = "https://reqres.in/api";
	
	//Test forma de hacerlos 1
	@Test
	public void RegisterUserTest(){
		Actor julian = Actor.named("Julian QA").whoCan(CallAnApi.at(REST_API_URL));
		
		String resgisterUserInfo = "{\n" +
				                           "    \"name\": \"morpheus\",\n" +
				                           "    \"job\": \"leader\",\n" +
				                           "    \"email\": \"tracey.ramos@reqres.in\",\n" +
				                           "    \"password\": \"serenity\"\n" +
				                           "}";
				
		julian.attemptsTo(
				PostRegisterUserTask.withInfo(resgisterUserInfo)
		);
		
		julian.should(
				//seeThat("el codigo de respuesta", new ResponseCode.was().equalTo(200))
				seeThat("el codigo de respuesta", new ResponseCode(),equalTo(200))
		);
	}
	
	//Test forma de hacerlos 2
	@Test
	public void CreateRegisterUserTest(){
		Actor julian = Actor.named("Julian QA")
            .whoCan(CallAnApi.at(REST_API_URL));
		
		CreateUserModel createUserModel = new CreateUserModel();
		createUserModel.setName("morpheus");
		createUserModel.setJob("leader");
		createUserModel.setEmail("tracey.ramos@reqres.in");
		createUserModel.setPassword("serenity");
		
		julian.attemptsTo(
				PostRegisterUserTask.withInfo(createUserModel)
		);
		
		julian.should(
				seeThat("el codigo de respuesta", new ResponseCode(),equalTo(200))
		);
	}
	
	@Test
	public void UpdateRegisterUserTest(){
		Actor messi = Actor.named("Messi QA")
            .whoCan(CallAnApi.at(REST_API_URL));
		
		UpdateUserModel updateUserInfo = new UpdateUserModel();
		updateUserInfo.setName("morphe");
		updateUserInfo.setJob("lider");
		updateUserInfo.setEmail("tracey.ramos@reqres.in");
		updateUserInfo.setPassword("serenity");
		
		messi.attemptsTo(
				PutRegisterUserTask.withInfo(updateUserInfo)
		);
		
		messi.should(
				seeThat("el codigo de respuesta", new ResponseCode(),equalTo(200))
		);
	}
	
	@Test
	public void factTest(){
		Actor ymina = Actor.named("Y Mina QA")
				              .whoCan(CallAnApi.at(REST_API_URL));
		
		ymina.has(
				NetflixPlans.toViewSeries()
		);
	}
	
}
