package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.Checkbox;
import pages.components.Picture;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithTEstDataTests {

    CalendarComponent calenderComponent = new CalendarComponent();

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


    public RegistrationFormWithTEstDataTests openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationFormWithTEstDataTests setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormWithTEstDataTests setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormWithTEstDataTests setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormWithTEstDataTests setGenderCheckbox(String value) {
        checkBoxComponent(genderCheckbox,value);

        return this;
    }

    private void checkBoxComponent(SelenideElement genderCheckbox, String value) {
        $("#genterWrapper").$(byText(value)).click();
    }

    public RegistrationFormWithTEstDataTests setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormWithTEstDataTests setBirthDate(String month, String year, String day) {
        birthDayInput.click();
        calenderComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormWithTEstDataTests setSubject(String value) {
        subjectInput.sendKeys(value);
        subjectInput.pressEnter();

        return this;
    }

    public RegistrationFormWithTEstDataTests setHobbyCheckbox(String value) {
        Checkbox.setCheckBox(hobbyCheckbox,value);

        return this;
    }

    public RegistrationFormWithTEstDataTests uploadPicture(String value) {
        Picture.setPicture(pictureInput, value);

        return this;
    }

    public RegistrationFormWithTEstDataTests setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationFormWithTEstDataTests setState(String value) {
        stateInput.setValue(value).pressEnter();;

        return this;
    }

    public RegistrationFormWithTEstDataTests setCity(String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormWithTEstDataTests pressSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationFormWithTEstDataTests checkResult(String key, String value) {
        ResultsTableComponent.checkResult(key, value);

        return this;
    }
}

