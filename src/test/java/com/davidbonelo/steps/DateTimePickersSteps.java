package com.davidbonelo.steps;

import com.davidbonelo.pages.DatePickerPage;
import com.davidbonelo.pages.HomePage;
import com.davidbonelo.pages.WidgetsPage;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimePickersSteps extends WebSetup {
    DatePickerPage datePickerPage;

    @Given("User in in the date picker page")
    public void userInInTheDatePickerPage() {
        try {
            setupDriver();
            HomePage homePage = new HomePage(driver);
            WidgetsPage widgetsPage = homePage.navigateToWidgetsPage();
            datePickerPage = widgetsPage.navigateToDatePickerPage();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @When("he picks the date: {string}")
    public void he_picks_the_date(String date) {
        try {
            LocalDate localDate = LocalDate.parse(date);
            datePickerPage.pickDate(localDate);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @Then("he should see the date field filled with {string}")
    public void he_should_see_the_date_field_filled_with(String dateText) {
        try {
            Assertions.assertEquals(dateText, datePickerPage.getDateText());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }

    @When("he picks the datetime: {string}")
    public void he_picks_the_datetime(String dateTime) {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
            datePickerPage.pickDateTime(localDateTime);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @Then("he should see the datetime field filled with {string}")
    public void he_should_see_the_datetime_field_filled_with(String dateTimeText) {
        try {
            Assertions.assertEquals(dateTimeText, datePickerPage.getDateTimeText());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }
}
