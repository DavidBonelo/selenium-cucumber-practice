package com.davidbonelo.pages;

import com.davidbonelo.models.Employee;
import com.davidbonelo.pages.components.EmployeeForm;
import com.davidbonelo.pages.components.EmployeeRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage {
    private final WebDriver driver;
    private final By formModalLocator = By.cssSelector(".modal-content");
    private final By recordsLocator = By.cssSelector(".rt-tr-group > *:not(.-padRow)");
    // Page factory finds the elements with the same id as the variable name
    private WebElement addNewRecordButton;
    private WebElement searchBox;
    @FindBy(css = ".-totalPages")
    private WebElement totalPagesSpan;
    @FindBy(css = "input[aria-label='jump to page']")
    private WebElement currentPageInput;

    private List<WebElement> records;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addRecord(Employee employee) {
        addNewRecordButton.click();
        WebElement formModal = driver.findElement(formModalLocator);
        EmployeeForm employeeForm = new EmployeeForm(formModal);
        employeeForm.submit(employee);
    }

    public Employee deleteRecord(Employee employee) {
        searchByEmail(employee.getEmail());
        EmployeeRecord lastEmployeeRecord = getLastEmployeeRecord();
        lastEmployeeRecord.deleteRecord();
        clearSearchBox();
        return lastEmployeeRecord.getEmployee();
    }

    private void clearSearchBox() {
        searchBox.clear();
        // search appears to trigger only with key events
        searchBox.sendKeys("z", Keys.BACK_SPACE);
//        Actions actions = new Actions(driver);
        // only deletes a word
//        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ESCAPE).keyUp(Keys.CONTROL).perform();
//        actions.sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT)
//        .sendKeys(Keys.BACK_SPACE).perform();
    }

    private void searchByEmail(String email) {
        clearSearchBox();
        searchBox.sendKeys(email);
    }

    public EmployeeRecord getLastEmployeeRecord() {
        goToPage(getTotalPages()); // move to last page
        loadRecords();
        return new EmployeeRecord(records.get(records.size() - 1));
    }

    private void loadRecords() {
        records = driver.findElements(recordsLocator);
    }

    public int getTotalPages() {
        return Integer.parseInt(totalPagesSpan.getText());
    }

    public void goToPage(int pageNumber) {
        currentPageInput.clear();
        currentPageInput.sendKeys("" + pageNumber, Keys.ENTER);
    }
}
