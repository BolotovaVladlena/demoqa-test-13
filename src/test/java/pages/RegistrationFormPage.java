package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.Picture;
import pages.components.ResultsTableComponent;
import pages.components.Checkbox;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponent calenderComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public static final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderCheckbox = $("#genterWrapper"),
            numberInput =  $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyCheckbox =  $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGenderCheckbox(String value) {
        checkBoxComponent(genderCheckbox,value);

        return this;
    }

    private void checkBoxComponent(SelenideElement genderCheckbox, String value) {
        $("#genterWrapper").$(byText(value)).click();
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String month, String year, String day) {
        birthDayInput.click();
        calenderComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.sendKeys(value);
        subjectInput.pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbyCheckbox(String value) {
        Checkbox.setCheckBox(hobbyCheckbox,value);

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        Picture.setPicture(pictureInput, value);

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.setValue(value).pressEnter();;

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage pressSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        ResultsTableComponent.checkResult(key, value);

        return this;
    }
}

