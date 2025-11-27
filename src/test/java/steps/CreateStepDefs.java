package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class CreateStepDefs extends ApiBase {


    @Given("the API is available")
    public void theAPIIsAvailable() {
        response = RestAssured
                .given()
                .when()
                .get("/posts")
                .then()
                .extract()
                .response();

        Assertions.assertEquals(200, response.statusCode(), "API is not available");
    }

    @When("I send a POST request to {string}")
    public void iSendAPOSTRequestTo(String endPoint) {
        payload = new HashMap<>();
        payload.put("userId", 123456789);
        payload.put("title", "Updated Title");
        payload.put("content", "This is the updated content of the post");

        response = RestAssured.given()
                .body(payload)
                .post(endPoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assertions.assertEquals(
                statusCode,
                response.statusCode(),
                "Unexpected status code"
        );
    }

    @And("the response should contain the created post")
    public void theResponseShouldContainTheCreatedPost() {
        Assertions.assertNotNull(
                response.getBody(),
                "Response body is null"
        );
    }


    @And("the response header should be {string}")
    public void theResponseHeaderShouldBe(String expectedContentType) {
        String contentType = response.getHeader("Content-Type");
        assertNotNull(contentType);
        assertTrue(contentType.contains(expectedContentType));
    }


    @And("the created post should have {string} in {string}, {string} in {string}, and {string} in {string}")
    public void theCreatedPostShouldHaveInInAndIn(String expectedTitle, String titleField, String expectedContent, String contentField, int expectedUserId, String userIdField) {
        {

            Map<String, Object> post = response.jsonPath().getMap("$");

            assertEquals(expectedTitle, post.get(titleField));
            assertEquals(expectedContent, post.get(contentField));
            assertEquals(expectedUserId, ((Number) post.get(userIdField)).intValue());
        }
    }
}
