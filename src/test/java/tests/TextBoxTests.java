package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {

        open("/automation-practice-form");

        $("[#firstName]").setValue("Ivan");
        $("[#lastName]").setValue("Ivanov");
        $("[#userEmail]").setValue("ivanov@ivanov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("[#userNumber]").setValue("9111234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--001:nth-child(3)").click();
        $("#subjectsInput").setValue("example");
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile (new File("src/test/resources/ledibug.jpg"));
        $("#currentAddress-wrapper").click();
        $("#currentAddress").val("example");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text("ivanov@ivanov.com"), text("Male"), text("891111111"), text("example"),
                text("15 May,1988"), text("example"), text("Music"),
                text("ledibug.jpg"), text("example"), text("NCR Delhi"));
    }

    @Test
    void successfulTest2() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        registrationFormPage
                .openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivanov@ivanov.com")
                .setGenderCheckbox("Male")
                .setAddress("example")
                .setNumber("9111111111")
                .setBirthDate ("July", "1988", "15" )
                .setSubject("Maths")
                .setHobbyCheckbox("Music")
                .uploadPicture("src/test/resources/ledibug.jpg")
                .setAddress("example")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmitButton()
                .checkResult("Student Name","Ivan Ivanov")
                .checkResult("Student Email","ivanov@ivanov.com")
                .checkResult("Gender","Male")
                .checkResult("Mobile","9111111111")
                .checkResult("Date of Birth","15 July,1988")
                .checkResult("Subjects","Maths")
                .checkResult("Hobbies","Music")
                .checkResult("Picture","ledibug.jpg")
                .checkResult("Address","example")
                .checkResult("State and City","NCR Delhi")


        ;


    }

    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String email = faker.internet().emailAddress();

    String currentAddress = faker.witcher().quote();

    String number = faker.phoneNumber().phoneNumber();
    String subjects = faker.random().toString();
    String address = faker.address().streetAddress();


    @Test
    void successfulTest3() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenderCheckbox("Male")
                .setAddress(address)
                .setNumber(String.valueOf(number))
                .setBirthDate ("July", "1988", "15" )
                .setSubject(subjects)
                .setHobbyCheckbox("Music")
                .uploadPicture("src/test/resources/ledibug.jpg")
                .setAddress(address)
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmitButton()



        ;


    }
}