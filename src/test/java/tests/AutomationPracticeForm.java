package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.*;

public class AutomationPracticeForm extends TestBase {

    @Test
    void sucessfulFillPracticeFormTest (){
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__day--" + "0" + day + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("M");
        $(byText(subjectsInput)).click();
        $("#hobbiesWrapper").$(byText(hobbiesWrapper)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

        //Checkings
        $(".modal-header").shouldBe(text(
                "Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender"))
                .parent().shouldHave(text(genterWrapper));
        $(".table-responsive").$(byText("Mobile"))
                .parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text(day + " " + month + ","+ year));
        $(".table-responsive").$(byText("Subjects"))
                .parent().shouldHave(text(subjectsInput));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text(hobbiesWrapper));
        $(".table-responsive").$(byText("Picture"))
                .parent().shouldHave(text(picture));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text(state +" " + city));













    }



}
