package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ScenarioHooks extends ApiBase {

    @Before
    public void setUpScenario() {
        response = null;
    }

    @After
    public void tearDownScenario(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed() && response != null) {
            System.out.println("\n--- Scenario Failed ---");
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response Body:\n" + response.getBody().asPrettyString());
            System.out.println("------------------------\n");
        }
    }

    @AfterStep
    public void logRequestResponse(Scenario scenario) {
        if (ApiBase.payload != null) {
            scenario.log("Request payload: " + ApiBase.payload);
        }
        if (ApiBase.response != null) {
            scenario.log("Response body: " + ApiBase.response.getBody().asString());
        }
    }
}
