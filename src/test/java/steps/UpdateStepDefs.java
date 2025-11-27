package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class UpdateStepDefs extends ApiBase {

    @And("the response should contain the updated post data")
    public void theResponseShouldContainTheUpdatedPostData() {
        Map<String, Object> updatedPost = response.jsonPath().getMap("$");
        assertNotNull(updatedPost.get("title"));
        assertNotNull(updatedPost.get("content"));
        assertNotNull(updatedPost.get("userId"));
    }

    @When("I send a PUT request to {string} with the updated payload")
    public void iSendAPUTRequestToWithTheUpdatedPayload(String arg0) {
        payload = new HashMap<>();
        payload.put("title", "Updated Title");
        payload.put("content", "This is the updated body of the post");
        payload.put("userId", 123456789);
        response = RestAssured.given()
                .body(payload)
                .put(arg0);
    }
}
