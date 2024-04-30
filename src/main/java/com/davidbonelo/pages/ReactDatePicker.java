package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class ReactDatePicker {
    private final By yearSelectLocator = By.cssSelector(".react-datepicker__year-select");
    private final By monthSelectLocator = By.cssSelector(".react-datepicker__month-select");
    private final WebElement root;

    public ReactDatePicker(WebElement root) {
        this.root = root;
    }

    public void setDate(LocalDate date) {
        selectYear(date.getYear());
        selectMonth(date.getMonth().getValue() - 1);
        selectDay(date.getDayOfMonth());
    }

    private void selectYear(int year) {
        WebElement yearSelector = root.findElement(yearSelectLocator);
        yearSelector.click();
        By yearOptionSelector = By.cssSelector("option[value='" + year + "']");
        yearSelector.findElement(yearOptionSelector).click();
    }

    private void selectMonth(int month) {
        WebElement monthSelector = root.findElement(monthSelectLocator);
        monthSelector.click();
        By monthOptionSelector = By.cssSelector("option[value='" + month + "']");
        monthSelector.findElement(monthOptionSelector).click();
    }

    private void selectDay(int dayOfMonth) {
        By monthDaysLocator = By.cssSelector(".react-datepicker__month");
        WebElement monthDays = root.findElement(monthDaysLocator);
        String dayLocatorString = "//div[text()='" + dayOfMonth + "']";
        String omitOutsideMonthClass =
                "[not(contains(concat(' ',normalize-space(@class),' '),' " + "react" +
                        "-datepicker__day--outside-month '))]";
        By dayLocator = By.xpath(dayLocatorString + omitOutsideMonthClass);
        monthDays.findElement(dayLocator).click();
    }
}
