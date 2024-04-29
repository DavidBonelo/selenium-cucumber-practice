package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class CommonFunctions {
    protected final WebDriver driver;

    protected CommonFunctions(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(By selector) {
        driver.findElement(selector).click();
    }

    protected void typeInto(By firstNameInputLocator, String text) {
        driver.findElement(firstNameInputLocator).sendKeys(text);
    }
}
