package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonFunctions {
    By formsCardLocator = By.xpath("//h5[text()='Forms']");
    By interactionsCardLocator = By.xpath("//h5[text()='Interactions']");
    By widgetsCardLocator = By.xpath("//h5[text()='Widgets']");
    By elementsCardLocator = By.xpath("//h5[text()='Elements']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public FormsPage navigateToFormsPage() {
        clickElement(formsCardLocator);
        return new FormsPage(driver);
    }

    public InteractionsPage navigateToInteractionsPage(){
        clickElement(interactionsCardLocator);
        return new InteractionsPage(driver);
    }

    public WidgetsPage navigateToWidgetsPage() {
        clickElement(widgetsCardLocator);
        return new WidgetsPage(driver);
    }
    public ElementsPage navigateToElementsPage() {
        clickElement(elementsCardLocator);
        return new ElementsPage(driver);
    }
}
