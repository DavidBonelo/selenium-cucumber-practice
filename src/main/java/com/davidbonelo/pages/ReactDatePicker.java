package com.davidbonelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.Month;

public class ReactDatePicker {
    private final By yearSelectLocator = By.cssSelector(".react-datepicker__year-select");
    private final By monthSelectLocator = By.cssSelector(".react-datepicker__month-select");
    private final WebElement root;

    public ReactDatePicker(WebElement root) {
        this.root = root;
    }

    public void setDate(LocalDate date) {
        selectYear(date.getYear());
        selectMonth(date.getMonth());
        selectDay(date.getDayOfMonth());
    }

    private void selectYear(int year) {
        WebElement yearSelector = root.findElement(yearSelectLocator);
        yearSelector.click();
        By yearOptionSelector = By.cssSelector("option[value='" + year + "']");
        yearSelector.findElement(yearOptionSelector).click();
    }

    private void selectMonth(Month month) {
        WebElement monthSelector = root.findElement(monthSelectLocator);
        monthSelector.click();
        By monthOptionSelector = By.cssSelector("option[value='" + (month.getValue() - 1) + "']");
        monthSelector.findElement(monthOptionSelector).click();
    }

    private void selectDay(int dayOfMonth) {
        By monthDaysLocator = By.cssSelector(".react-datepicker__month");
        WebElement monthDays = root.findElement(monthDaysLocator);
        By dayLocator = By.xpath("//div[text()='" + dayOfMonth + "']");
        monthDays.findElement(dayLocator).click();
    }
}
