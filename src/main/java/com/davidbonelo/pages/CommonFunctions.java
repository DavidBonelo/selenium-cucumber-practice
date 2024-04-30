package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public abstract class CommonFunctions {
    protected final WebDriver driver;

    protected CommonFunctions(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(By selector) {
        driver.findElement(selector).click();
    }

    protected void typeInto(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void typeIntoAndPressEnter(By locator, String text) {
        driver.findElement(locator).sendKeys(text, Keys.ENTER);
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(locator));
    }
}
