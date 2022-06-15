package pages.components;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
public class Picture {
    public static void setPicture(SelenideElement selenideElement, String value) {
        selenideElement.uploadFile (new File(value));

    }
}
