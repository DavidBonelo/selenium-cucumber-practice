package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InteractionsPage extends CommonFunctions {
    By droppableItemSelector = By.xpath("//span[text()='Droppable']");
    By sortableItemSelector = By.xpath("//span[text()='Sortable']");

    public InteractionsPage(WebDriver driver) {
        super(driver);
    }

    public DroppablePage navigateToDroppablePage() {
        clickElement(droppableItemSelector);
        return new DroppablePage(driver);
    }

    public SortablePage navigateToSortablePage() {
        clickElement(sortableItemSelector);
        return new SortablePage(driver);
    }
}
