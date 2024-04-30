package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppablePage extends CommonFunctions {
    private final By draggableLocator = By.id("draggable");
    private final By droppableLocator = By.id("droppable");

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public void moveBoxToPlace() {
        WebElement draggable = driver.findElement(draggableLocator);
        WebElement droppable = driver.findElement(droppableLocator);
        new Actions(driver).dragAndDrop(draggable, droppable).perform();
    }

    public String getDroppableMessage() {
        WebElement droppable = driver.findElement(droppableLocator);
        return droppable.findElement(By.cssSelector("p")).getText();
    }
}
