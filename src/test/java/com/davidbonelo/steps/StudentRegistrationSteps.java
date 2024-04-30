package com.davidbonelo.steps;

import com.davidbonelo.models.Student;
import com.davidbonelo.models.enums.Hobby;
import com.davidbonelo.pages.FormsPage;
import com.davidbonelo.pages.HomePage;
import com.davidbonelo.pages.RegisterPage;
import com.davidbonelo.setup.WebSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.Map;

import static com.davidbonelo.utils.DateFormatter.parseUSDate;

public class StudentRegistrationSteps extends WebSetup {
    RegisterPage registerPage;
    Student student;

    @Given("the user is in the registration page")
    public void theUserIsInTheRegistrationPage() {
        try {
            setupDriver();
            student = Student.createFakeStudent();
            FormsPage formsPage = new HomePage(driver).navigateToFormsPage();
            registerPage = formsPage.navigateToPracticeForm();
//            driver.get("https://demoqa.com/automation-practice-form");
//            registerPage = new RegisterPage(driver);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @When("he enters his information")
    public void heEntersHisInformation() {
        try {
            registerPage.fillForm(student);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @And("he submits the data")
    public void heSubmitsTheData() {
        try {
            registerPage.submitForm();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quitDriver();
            Assertions.fail();
        }
    }

    @Then("he should see a thanks message")
    public void heShouldSeeAThanksMessage() {
        try {
            Map<String, Object> resultTable = registerPage.getResultTable();
            Assertions.assertEquals("Thanks for submitting the form",
                    registerPage.getThanksMessage());
            String fullName = student.getFirstName() + " " + student.getLastName();
            Assertions.assertEquals(fullName, resultTable.get("Student Name"));
            Assertions.assertEquals(student.getEmail(), resultTable.get("Student Email"));
            Assertions.assertEquals(student.getGender().getValue(), resultTable.get("Gender"));
            Assertions.assertEquals(student.getPhone(), resultTable.get("Mobile"));
            LocalDate birthDate = parseUSDate((String) resultTable.get("Date of Birth"));
            Assertions.assertTrue(student.getBirthDate().isEqual(birthDate));
            String subjects = String.join(", ", student.getSubjects());
            Assertions.assertEquals(subjects, resultTable.get("Subjects"));
            String hobbies = String.join(", ",
                    student.getHobbies().stream().map(Hobby::getValue).toList());
            Assertions.assertEquals(hobbies, resultTable.get("Hobbies"));
            Assertions.assertEquals(student.getAddress(), resultTable.get("Address"));
            String stateAndCity = student.getState() + " " + student.getCity();
            Assertions.assertEquals(stateAndCity, resultTable.get("State and City"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }
}
