package com.davidbonelo.pages;

import com.davidbonelo.models.Student;
import com.davidbonelo.models.enums.Gender;
import com.davidbonelo.models.enums.Hobby;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class RegisterPage extends CommonFunctions {
    private final By firstNameInputLocator = By.id("firstName");
    private final By lastNameInputLocator = By.id("lastName");
    private final By emailInputLocator = By.id("userEmail");
    private final By phoneInputLocator = By.id("userNumber");
    private final By subjectInputLocator = By.id("subjectsInput");
    private final By birthDateLocator = By.id("dateOfBirthInput");
    private final By addressInputLocator = By.id("currentAddress");
    private final By stateInputLocator = By.id("react-select-3-input");
    private final By cityInputLocator = By.id("react-select-4-input");
    private final By submitButtonLocator = By.id("submit");
    private final By resultTableLocator = By.cssSelector(".modal-content");
    private SubmitResultTable submitResultTable;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Student student) {
        typeInto(firstNameInputLocator, student.getFirstName());
        typeInto(lastNameInputLocator, student.getLastName());
        typeInto(emailInputLocator, student.getEmail());
        selectGender(student.getGender());
        typeInto(phoneInputLocator, student.getPhone());
        enterDate(student.getBirthDate());
        selectSubjects(student.getSubjects());
        scrollTo(addressInputLocator);
        selectHobbies(student.getHobbies());
        typeInto(addressInputLocator, student.getAddress());
        typeIntoAndPressEnter(stateInputLocator, student.getState());
        typeIntoAndPressEnter(cityInputLocator, student.getCity());
    }

    public void submitForm() {
        scrollTo(submitButtonLocator);
        clickElement(submitButtonLocator);
    }

    public String getThanksMessage() {
        return submitResultTable.getThanksMessage();
    }

    private void selectGender(Gender gender) {
        String genderLocator = formatGenderLocator(gender);
        clickElement(By.cssSelector(genderLocator));
    }

    private void enterDate(LocalDate birthDate) {
        scrollTo(birthDateLocator);
        clickElement(birthDateLocator);
        WebElement datePicker = driver.findElement(By.cssSelector(".react-datepicker-popper"));
        ReactDatePicker reactDatePicker = new ReactDatePicker(datePicker);
        reactDatePicker.setDate(birthDate);
    }

    private void selectSubjects(List<String> subjects) {
        for (String subject : subjects) {
//        typeIntoAndPressEnter(subjectInputLocator, student.getSubjects());
            scrollTo(subjectInputLocator);
            clickElement(subjectInputLocator);
            typeInto(subjectInputLocator, subject);
            driver.findElement(subjectInputLocator).sendKeys(Keys.ENTER);
        }
    }

    private void selectHobbies(List<Hobby> hobbies) {
        for (Hobby hobby : hobbies) {
            String hobbyLocator = formatHobbyLocator(hobby);
            clickElement(By.xpath(hobbyLocator));
        }
    }

    public Map<String, Object> getResultTable() {
        WebElement resultElement = driver.findElement(resultTableLocator);
        submitResultTable = new SubmitResultTable(resultElement);
        return submitResultTable.getResultMap();
    }

    public String formatGenderLocator(Gender gender) {
        String genderRadioLocatorString = "input[value='%s'] + label";
        return String.format(genderRadioLocatorString, gender.getValue());
    }

    private String formatHobbyLocator(Hobby hobby) {
        String hobbyCheckboxLocatorString = "//label[text()='%s']";
        return String.format(hobbyCheckboxLocatorString, hobby.getValue());
    }

//    public String formatGenderLocator(Gender gender) {
//String genderRadioLocatorString = "input[value='%s'] + label";
//        switch (gender) {
//            case MALE -> {
//                return String.format(genderRadioLocatorString, gender.getValue());
//            }
//            case FEMALE -> {
//                return String.format(genderRadioLocatorString, "Female");
//            }
//            case OTHER -> {
//                return String.format(genderRadioLocatorString, "Other");
//            }
//            default -> throw new IllegalStateException("Unexpected value: " + gender);
//        }
//    }
}
