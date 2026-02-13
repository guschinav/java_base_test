package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm extends TestBase {

    @Test
    void sucessfulFillPracticeFormTest (){
        open("/automation-practice-form");
        $("#firstName").setValue("Vladimir");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("vlOdimir@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("option[value='1999']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='7']").click();
        $(".react-datepicker__day-names").click();
        $(".react-datepicker__day.react-datepicker__day--010").click();


        $("#subjectsInput").setValue("M");
        $(byText("Maths")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/map.jpg"));

        $("#currentAddress").setValue("Address");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();




        //Checkings
        $(".modal-header").shouldBe(text(
                "Thanks for submitting the form"));
        $$("tr").find(Condition.text("Student Name"))
                .$$("td").get(1).shouldHave(Condition.text("Vladimir Smith"));
        $$("tr").find(Condition.text("Student Email"))
                .$$("td").get(1).shouldHave(Condition.text("vlOdimir@mail.com"));
        $$("tr").find(Condition.text("Gender"))
                .$$("td").get(1).shouldHave(Condition.text("Male"));
        $$("tr").find(Condition.text("Mobile"))
                .$$("td").get(1).shouldHave(Condition.text("0123456789"));
        $$("tr").find(Condition.text("Date of Birth"))
                .$$("td").get(1).shouldHave(Condition.text("10 August,1999"));
        $$("tr").find(Condition.text("Subjects"))
                .$$("td").get(1).shouldHave(Condition.text("Maths"));
        $$("tr").find(Condition.text("Hobbies"))
                .$$("td").get(1).shouldHave(Condition.text("Sports"));
        $$("tr").find(Condition.text("Picture"))
                .$$("td").get(1).shouldHave(Condition.text("map.jpg"));
        $$("tr").find(Condition.text("Address"))
                .$$("td").get(1).shouldHave(Condition.text("Address"));
        $$("tr").find(Condition.text("State and City"))
                .$$("td").get(1).shouldHave(Condition.text("NCR Noida"));













    }



}
