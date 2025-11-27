package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiBase {

    protected static RequestSpecification request;
    protected static Response response;
    protected static Map<String, Object> payload;

    static {
        RestAssured.baseURI = "https://jsonplaceholder.org";

        request = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
    }
}
