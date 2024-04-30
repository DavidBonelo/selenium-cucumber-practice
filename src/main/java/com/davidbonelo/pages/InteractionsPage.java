package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InteractionsPage extends CommonFunctions {
    By droppableItemSelector = By.xpath("//span[text()='Droppable']");

    public InteractionsPage(WebDriver driver) {
        super(driver);
    }

    public DroppablePage navigateToDroppablePage() {
        clickElement(droppableItemSelector);
        return new DroppablePage(driver);
    }
}
