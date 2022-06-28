package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();

    String currentAddress = faker.witcher().quote();

    String address = faker.address().streetAddress();

    String male = "Male";
    String month = "July";
    String year = "1988";
    String day = "15";

    String hobbyCheckbox = "Music";
    String picture = "src/test/resources/ledibug.jpg";
    String picture1 = "ledibug.jpg";
    String state = "NCR";

    String city = "Delhi";

    String subject = "Maths";

    String number = "9112341567";

    String email = "bbbb@yandex.ru";
}

