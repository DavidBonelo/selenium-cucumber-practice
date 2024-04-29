package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsPage extends CommonFunctions {
    By practiceFormItemSelector = By.xpath("//span[text()='Practice Form']");

    protected FormsPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage navigateToPracticeForm() {
        clickElement(practiceFormItemSelector);
        return new RegisterPage(driver);
    }
}
