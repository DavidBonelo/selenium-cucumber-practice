package com.davidbonelo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleSteps {
    @Given("Example state")
    public void exampleState() {
        System.out.println("Step1");
    }

    @When("Example action")
    public void exampleAction() {
    }

    @Then("Example result")
    public void exampleResult() {
    }
}
