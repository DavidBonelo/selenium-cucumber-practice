package com.davidbonelo.steps;

import com.davidbonelo.pages.DroppablePage;
import com.davidbonelo.pages.HomePage;
import com.davidbonelo.pages.InteractionsPage;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class InteractionsSteps extends WebSetup {
    DroppablePage droppablePage;

    @Given("User is in the droppable page")
    public void userIsInTheDroppablePage() {
        try {
            setupDriver();
            HomePage homePage = new HomePage(driver);
            InteractionsPage interactionsPage = homePage.navigateToInteractionsPage();
            droppablePage = interactionsPage.navigateToDroppablePage();
//            droppablePage = new DroppablePage(driver);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @When("he drags and drops the box to its place")
    public void heDragsAndDropsTheBoxToItsPlace() {
        try {
            droppablePage.moveBoxToPlace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @Then("he should see the droppable place reaction")
    public void heShouldSeeTheDroppablePlaceReaction() {
        try {
            Assertions.assertEquals(droppablePage.getDroppableMessage(), "Dropped!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }
}
