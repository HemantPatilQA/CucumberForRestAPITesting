package com.qaautomater.springbootcucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TutorialStepDefinition extends TutorialServiceApplicationTests {

    private static Response response;
    @Given("the tutorial-service is up and running")
    public void theTutorialServiceIsUpAndRunning() {
        System.out.println("1. The Tutorial-service is up and running");
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = port;
    }

    @When("the user sends a valid request to create tutorial")
    public void theUserSendsAValidRequestToCreateTutorial(DataTable dataTable) {
        System.out.println("2. The user sends a valid request to create Tutorial");
        System.out.println(dataTable.asList().get(0) + " :: " + dataTable.asList().get(1) + " :: " + dataTable.asList().get(2));


        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"name\":\"" + dataTable.asList().get(0) + "\", \"description\":\"" + dataTable.asList().get(1) +
                "\", \"published\":" + dataTable.asList().get(2) +"}").post("/api/tutorials");
    }

    @Then("A new tutorial is created and user is notified with new Id")
    public void aNewTutorialIsCreatedAndUserIsNotifiedWithNewId() {
        System.out.println("3. A new Tutorial is created and user is notified with new Id");
        String jsonString = response.asString();
        System.out.println("New Tutorial Id : " + JsonPath.from(jsonString).get("id"));
    }

    @And("Validate response has status code as {int}")
    public void validateResponseHasStatusCodeAs(int iResponseCode) {
        System.out.println("4. Validate response has status code as : " + response.getStatusCode());
    }
}
