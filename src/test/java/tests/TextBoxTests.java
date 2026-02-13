package tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {





    @Test
    void sucessfulFillFormTest (){
        open ("/text-box");
        $("[id=userName]").setValue("Vladimir Smith");
        $("[id=userEmail]").setValue("vlOdimir@mail.com");
        $("[id=currentAddress]").setValue("first address 1");
        $("[id=permanentAddress]").setValue("second address 2");
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("Vladimir Smith"));
        $("[id=output] [id=email]").shouldHave(text("vlOdimir@mail.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));


    }
}
