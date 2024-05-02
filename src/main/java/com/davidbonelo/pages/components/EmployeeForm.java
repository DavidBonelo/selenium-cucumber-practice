package com.davidbonelo.pages.components;

import com.davidbonelo.models.Employee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeForm {

    @FindBy(id = "firstName")
    WebElement firstNameField;
    @FindBy(id = "lastName")
    WebElement lastNameField;
    @FindBy(id = "userEmail")
    WebElement emailField;
    @FindBy(id = "age")
    WebElement ageField;
    @FindBy(id = "salary")
    WebElement salaryField;
    @FindBy(id = "department")
    WebElement departmentField;
    @FindBy(id = "submit")
    WebElement submitBtn;

    public EmployeeForm(WebElement root) {
        PageFactory.initElements(root, this);
    }

    public void submit(Employee employee) {
        firstNameField.sendKeys(employee.getFirstName());
        lastNameField.sendKeys(employee.getLastName());
        emailField.sendKeys(employee.getEmail());
        ageField.sendKeys(employee.getAge().toString());
        salaryField.sendKeys(employee.getSalary());
        departmentField.sendKeys(employee.getDepartment());
        submitBtn.click();
    }
}
