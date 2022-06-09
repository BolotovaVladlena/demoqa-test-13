package pages.components;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
public class checkbox {
    public static void setCheckBox(SelenideElement selenideElement, String value) {
        $(selenideElement).$(byText(value)).click();
    }
}



