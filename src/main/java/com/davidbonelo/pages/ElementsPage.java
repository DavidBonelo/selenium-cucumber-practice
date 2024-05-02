package com.davidbonelo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    private final WebDriver driver;

    @FindBy(xpath = "//span[text()='Web Tables']/..")
    WebElement webTablesLI;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebTablesPage navigateToWebTablesPage() {
        webTablesLI.click();
        return new WebTablesPage(driver);
    }
}
