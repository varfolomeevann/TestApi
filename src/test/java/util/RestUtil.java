package util;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;

import com.sun.xml.xsom.impl.Ref.ContentType;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestUtil {
    static Logger log = Logger.getRootLogger();

    public static void setBaseURI(String baseURI) {

	RestAssured.baseURI = baseURI;

    }

    public static void setContentType(io.restassured.http.ContentType type) {
	given().contentType(type);
    }

    public static void setGiven() {
	log.info(given().log().all());
	given();
    }

    public static Response getResponse(String param) {
	log.info("get " + param);
	return get(param);
    }

    public static JsonPath getJson(Response response) {
	String json = response.asString();
	log.info("get json " + json);
	return new JsonPath(json);
    }
}
