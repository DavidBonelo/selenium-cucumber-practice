package com.davidbonelo.steps;

import com.davidbonelo.models.Employee;
import com.davidbonelo.pages.ElementsPage;
import com.davidbonelo.pages.HomePage;
import com.davidbonelo.pages.WebTablesPage;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class EmployeeTableSteps extends WebSetup {
    WebTablesPage webTablesPage;
    Employee employee;

    @Given("User is in the employee's page")
    public void userIsInTheEmployeeSPage() {
        try {
            setupDriver();
            HomePage homePage = new HomePage(driver);
            ElementsPage elementsPage = homePage.navigateToElementsPage();
            webTablesPage = elementsPage.navigateToWebTablesPage();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @When("he adds a new record to the table")
    public void heAddsANewRecordToTheTable() {
        try {
            for (int i = 0; i < 10; i++) {
                employee = Employee.createFakeEmployee();
                webTablesPage.addRecord(employee);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @Then("he should see the created record")
    public void heShouldSeeTheCreatedRecord() {
        try {
            Employee lastEmployee = webTablesPage.getLastEmployeeRecord().getEmployee();
            Assertions.assertEquals(employee, lastEmployee);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }
}
