package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonFunctions {
    By formsCardLocator = By.xpath("//h5[text()='Forms']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public FormsPage navigateToFormsPage() {
        clickElement(formsCardLocator);
        return new FormsPage(driver);
    }
}
