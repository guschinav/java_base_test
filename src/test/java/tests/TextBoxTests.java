package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }



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
