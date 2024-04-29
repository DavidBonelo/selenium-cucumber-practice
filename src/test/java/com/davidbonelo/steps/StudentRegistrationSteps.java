package com.davidbonelo.steps;

import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StudentRegistrationSteps extends WebSetup {

    @Given("the user is in the registration page")
    public void theUserIsInTheRegistrationPage() {
        setupDriver();
    }

    @When("he enters his information")
    public void heEntersHisInformation() {
    }

    @And("he submits the data")
    public void heSubmitsTheData() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Then("he should see a thanks message")
    public void heShouldSeeAThanksMessage() {
        quitDriver();
    }
}
