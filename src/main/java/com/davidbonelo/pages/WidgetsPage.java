package com.davidbonelo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage {
    private final WebDriver driver;

    @FindBy(xpath = "//span[text()='Date Picker']/..")
    WebElement datePickerLI;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DatePickerPage navigateToDatePickerPage(){
        datePickerLI.click();
        return new DatePickerPage(driver);
    }
}
