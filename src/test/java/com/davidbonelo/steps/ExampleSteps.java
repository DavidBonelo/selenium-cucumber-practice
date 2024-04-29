package com.davidbonelo.steps;

import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleSteps extends WebSetup {
    @Given("Example state")
    public void exampleState() {
        setupDriver();
        System.out.println("Step1");
    }

    @When("Example action")
    public void exampleAction() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Then("Example result")
    public void exampleResult() {
        quitDriver();
    }
}
