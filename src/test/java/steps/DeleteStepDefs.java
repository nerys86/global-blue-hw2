package steps;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;


public class DeleteStepDefs extends ApiBase {
    @When("I send a DELETE request to {string}")
    public void iSendADELETERequestTo(String endPoint) {
        response = RestAssured.given()
                .delete(endPoint);
    }
}
