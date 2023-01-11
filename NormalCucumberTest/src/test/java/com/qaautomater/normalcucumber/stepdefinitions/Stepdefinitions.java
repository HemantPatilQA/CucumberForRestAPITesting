package com.qaautomater.normalcucumber.stepdefinitions;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class Stepdefinitions {
    Response response;

    @Given("the tutorial-service is up and running")
    public void theTutorialServiceIsUpAndRunning() {
        System.out.println("1. The tutorial-service is up and running");
        RestAssured.baseURI = "http://localhost:8080/api";
    }

    @When("the user sends a valid request to create tutorial")
    public void theUserSendsAValidRequestToCreateTutorial(DataTable dataTable) {
        System.out.println("2. The user sends a valid request to create tutorial");
        List<List<String>> rows = dataTable.raw();
        System.out.println(rows.get(0).get(0) + " :: " + rows.get(0).get(1) + " :: " + rows.get(0).get(2));


        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"name\":\"" + rows.get(0).get(0) + "\", \"description\":\"" + rows.get(0).get(1) +
                "\", \"published\":" + rows.get(0).get(2) +"}").post("/tutorials");
    }

    @Then("A new tutorial is created and user is notified with new Id")
    public void aNewTutorialIsCreatedAndUserIsNotifiedWithNewId() {
        System.out.println("3. A new Tutorial is created and user is notified with new Id");
        String jsonString = response.asString();
        System.out.println("New Tutorial Id : " + JsonPath.from(jsonString).get("id"));
    }

    @And("Validate response has status code")
    public void validateResponseHasStatusCodeAs() {
        System.out.println("4. Validate response has status code as : " + response.getStatusCode());
    }
}
