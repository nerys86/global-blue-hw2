package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RetrieveStepDefs extends ApiBase {
    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endPoint) {
        response = RestAssured
                .given()
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();
    }

    @And("the response should contain a list of posts")
    public void theResponseShouldContainAListOfPosts() {
        List<Map<String, Object>> posts = response.jsonPath().getList("$");
        assertFalse(posts.isEmpty());
    }

    @And("each post should have {string}, {string}, {string}, and {string}")
    public void eachPostShouldHaveAnd(String id, String title, String content, String userId) {
        List<Map<String, Object>> posts = response.jsonPath().getList("$");
        for (Map<String, Object> post : posts) {
            assertTrue(post.containsKey(id));
            assertTrue(post.containsKey(title));
            assertTrue(post.containsKey(content));
            assertTrue(post.containsKey(userId));
        }
    }

    @And("a post with ID {int} exists")
    public void aPostWithIDExists(int id) {
        response = RestAssured.given()
                .get("/posts/" + id);
        assertEquals(200, response.getStatusCode());
    }

    @And("the response should contain the post with ID {int}")
    public void theResponseShouldContainThePostWithID(int id) {
        int responseId = response.jsonPath().getInt("id");
        assertEquals(id, responseId);
    }

    @And("the post should have {string}, {string}, and {string}")
    public void thePostShouldHaveAnd(String title, String content, String userId) {
        Map<String, Object> post = response.jsonPath().getMap("$");
        assertTrue(post.containsKey(title));
        assertTrue(post.containsKey(content));
        assertTrue(post.containsKey(userId));
    }
}
