package com.davidbonelo.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

enum BrowserType {
    CHROME, FIREFOX
}

public class WebSetup {
    private static final String BASE_URL = "https://demoqa.com/";
    protected WebDriver driver;

    protected void setupDriver() {
        driver = getBrowserDriver(BrowserType.CHROME);
        maximize();
        driver.get(BASE_URL);
        maximize();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

    protected void quitDriver() {
        driver.quit();
    }

    private WebDriver getBrowserDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME -> {
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                co.addArguments("--incognito");
                co.addArguments("--disable-notifications");
                return new ChromeDriver(co);
            }
            case FIREFOX -> {
                return new FirefoxDriver();
            }
            default -> throw new IllegalArgumentException("Incorrect browser type");
        }
    }
}
