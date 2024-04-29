package com.davidbonelo.pages;

import com.davidbonelo.models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends CommonFunctions{
    private final By firstNameInputLocator = By.id("firstName");
    private final By lastNameInputLocator = By.id("lastName");
    // input[value="Male"] + label
    // private final By submitButtonLocator = By.id("submit");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Student student) {
        typeInto(firstNameInputLocator, student.getFirstName());
        typeInto(lastNameInputLocator, student.getLastName());
    }

}
