package com.davidbonelo.steps;

import com.davidbonelo.models.Employee;
import com.davidbonelo.pages.ElementsPage;
import com.davidbonelo.pages.HomePage;
import com.davidbonelo.pages.WebTablesPage;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class EmployeeTableSteps extends WebSetup {
    WebTablesPage webTablesPage;
    Employee employee;

    @Before
    public void driverSetup() {
        setupDriver();
    }

    @After
    public void driverTeardown() {
        quitDriver();
    }

    @Given("User is in the employee's page")
    public void userIsInTheEmployeeSPage() {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = homePage.navigateToElementsPage();
        webTablesPage = elementsPage.navigateToWebTablesPage();
    }

    @When("he adds a new record to the table")
    public void heAddsANewRecordToTheTable() {
        for (int i = 0; i < 10; i++) {
            employee = Employee.createFakeEmployee();
            webTablesPage.addRecord(employee);
        }
    }

    @Then("he should see the created record")
    public void heShouldSeeTheCreatedRecord() {
        Employee lastEmployee = webTablesPage.getLastEmployeeRecord().getEmployee();
        Assertions.assertEquals(employee, lastEmployee);
    }
}
