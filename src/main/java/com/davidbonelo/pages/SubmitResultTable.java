package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubmitResultTable {
    private final WebElement root;
    private final By thanksMessageLocator = By.cssSelector(".modal-header " + "#example-modal" +
            "-sizes-title-lg");
    private final By tableDataSelector = By.cssSelector("table td");

    public SubmitResultTable(WebElement root) {
        this.root = root;
    }

    public String getThanksMessage() {
        return root.findElement(thanksMessageLocator).getText();
    }

    public Map<String, Object> getResultMap() {
        Map<String, Object> resultMap = new HashMap<>();
        List<WebElement> tableCells = root.findElements(tableDataSelector);
        for (int i = 0; i < 20; i += 2) {
            String field = tableCells.get(i).getText();
            Object value = tableCells.get(i + 1).getText();
            resultMap.put(field, value);
        }
        return resultMap;
    }
}
