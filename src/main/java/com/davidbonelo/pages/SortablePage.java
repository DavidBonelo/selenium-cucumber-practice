package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SortablePage extends CommonFunctions {
    private final By elementsLocator = By.cssSelector("#demo-tabpane-list .list-group-item");

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public void moveElementAfter(String name, int positionIdx) {
        WebElement element = driver.findElement(By.xpath("//div[text()='" + name + "']"));
        WebElement targetLocation = getElementAtPosition(positionIdx);
        new Actions(driver).moveToElement(targetLocation).perform();
        new Actions(driver).dragAndDrop(element, targetLocation).perform();
    }

    public String getItemNameAtPosition(int positionIdx) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement item = getElementAtPosition(positionIdx);
        wait.until(ExpectedConditions.elementToBeClickable(item));
        return item.getText();
    }

    private WebElement getElementAtPosition(int positionIdx) {
        List<WebElement> elements = driver.findElements(elementsLocator);
        System.out.println(elements.size());
        return elements.get(positionIdx - 1);
    }
}
