package util;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CheckMethods {

    public static void checkStatusIs200(Response response) {
	Assert.assertEquals(200, response.getStatusCode());
    }
    
    public static String getLoginFromJson(JsonPath json) {
	return json.get("login");
    }

}
