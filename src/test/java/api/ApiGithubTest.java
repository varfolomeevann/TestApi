package api;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import util.CheckMethods;
import util.RestUtil;
import util.TestListener;

@Listeners(TestListener.class)
public class ApiGithubTest {
    private Response response;
    private JsonPath json;
    private String user;

    @BeforeMethod
    public void setup() {
	user = "varfolomeevann";
	RestUtil.setBaseURI("https://api.github.com/users/");
	RestUtil.setGiven();
	response = RestUtil.getResponse(user);
	json = RestUtil.getJson(response);
    }

    @Test(description = "Проверка статус кода")
    public void statusCodeTest() {
	CheckMethods.checkStatusIs200(response);
    }

    @Test(description = "Проверка, что получаемая информация соответствует "
    	+ "заданному пользователю")
    public void loginUserTest() {
	String login = CheckMethods.getLoginFromJson(json);
	Assert.assertEquals(login, user);
    }

}
