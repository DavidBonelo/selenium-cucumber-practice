package com.davidbonelo.pages.components;

import com.davidbonelo.models.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeeRecord {
    private final WebElement root;
    private final Employee employee;
    @FindBy(css = "span[title='Edit']")
    private WebElement editBtn;
    @FindBy(css = "span[title='Delete']")
    private WebElement deleteBtn;

    public EmployeeRecord(WebElement root) {
        this.root = root;
        this.employee = getEmployeeFromRecord();
        PageFactory.initElements(root, this);
    }

    public Employee getEmployee() {
        return this.employee;
    }

    private Employee getEmployeeFromRecord() {
        List<WebElement> data = this.root.findElements(By.cssSelector(".rt-td"));
        Employee employee = new Employee();
        employee.setFirstName(data.get(0).getText());
        employee.setLastName(data.get(1).getText());
        employee.setAge(Integer.valueOf(data.get(2).getText()));
        employee.setEmail(data.get(3).getText());
        employee.setSalary(data.get(4).getText());
        employee.setDepartment(data.get(5).getText());
        return employee;
    }

    public void deleteRecord() {
        deleteBtn.click();
    }
}
