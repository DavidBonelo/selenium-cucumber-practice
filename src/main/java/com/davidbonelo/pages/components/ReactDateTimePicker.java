package com.davidbonelo.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.util.List;

public class ReactDateTimePicker {
    private final WebElement root;
    private final JavascriptExecutor jse;

    private final By yearSelectLocator = By.cssSelector(".react-datepicker__year-dropdown" +
            "-container");
    private final By yearOptionsLocator = By.cssSelector(".react-datepicker__year-option");
    private final By monthSelectLocator = By.cssSelector(".react-datepicker__month-dropdown" +
            "-container");
    private final By monthDaysLocator = By.cssSelector(".react-datepicker__month");

    public ReactDateTimePicker(WebElement root, JavascriptExecutor jse) {
        this.root = root;
        this.jse = jse;
    }

    public void setDateTime(LocalDateTime dateTime) {
        selectYear(dateTime.getYear());
        String monthU = dateTime.getMonth().toString();
        String month = monthU.charAt(0) + monthU.substring(1).toLowerCase();
        selectMonth(month);
        selectDay(dateTime.getDayOfMonth());
        selectTime(dateTime.toLocalTime().toString());
    }

    private void selectYear(int year) {
        WebElement yearSelector = root.findElement(yearSelectLocator);
        yearSelector.click();
        searchYear(year, yearSelector).click();
    }

    private WebElement searchYear(int year, WebElement yearsContainer) {
        List<WebElement> years = yearsContainer.findElements(yearOptionsLocator);
        while (true) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (WebElement yearElement : years) {
                Integer yearNumber = parseYear(yearElement);
                if (yearNumber == null) continue;
                if (yearNumber == year) {
                    return yearElement;
                } else if (yearNumber > max) {
                    max = yearNumber;
                } else if (yearNumber < min) {
                    min = yearNumber;
                }
            }
            if (year < min) {
                // click down arrow
                scrollToAndClick(years.get(years.size() - 1));
                years = yearsContainer.findElements(yearOptionsLocator);
            } else if (year > max) {
                // click up arrow
                scrollToAndClick(years.get(0));
                years = yearsContainer.findElements(yearOptionsLocator);
            }
        }
    }

    private Integer parseYear(WebElement yearElement) {
        String yearText = yearElement.getText();
        if (yearText.isEmpty()) return null;
        yearText = yearText.replace("✓", "").trim();
        return Integer.parseInt(yearText);
    }

    private void selectMonth(String month) {
        WebElement monthSelector = root.findElement(monthSelectLocator);
        monthSelector.click();
        By monthOptionSelector = By.xpath("//div[text()='" + month + "']");
        monthSelector.findElement(monthOptionSelector).click();
    }

    // //div[contains(text(),'May')]
    private void selectDay(int dayOfMonth) {
        WebElement monthDays = root.findElement(monthDaysLocator);
        String dayLocatorString = "//div[text()='" + dayOfMonth + "']";
        String omitOutsideMonthClass =
                "[not(contains(concat(' ',normalize-space(@class),' '),' " + "react" +
                        "-datepicker__day--outside-month '))]";
        By dayLocator = By.xpath(dayLocatorString + omitOutsideMonthClass);
        monthDays.findElement(dayLocator).click();
    }

    private void selectTime(String dateTimeString) {
        By timeLocator = By.xpath("//li[text()='" + dateTimeString + "']");
        root.findElement(timeLocator).click();
    }

    private void scrollToAndClick(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }
}
