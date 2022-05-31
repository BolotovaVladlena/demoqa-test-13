package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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

        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("ivanov@ivanov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("891111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--001:nth-child(3)").click();
        $("#subjectsInput").setValue("example");
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile (new File("src/test/java/resources/Леди Баг.jpg"));
        $("#currentAddress-wrapper").click();
        $("#currentAddress").val("example");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text("ivanov@ivanov.com"), text("Male"), text("891111111"), text("example"),
                text("1 May,1988"), text("example"), text("Music"),
                text("Леди Баг.jpg"), text("example"), text("NCR Delhi"));
    }
}