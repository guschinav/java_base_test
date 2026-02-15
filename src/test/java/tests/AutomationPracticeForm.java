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
        $(".react-datepicker__year-select").click();
        $("option[value='1999']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='7']").click();
        $(".react-datepicker__day-names").click();
        $(".react-datepicker__day.react-datepicker__day--010").click();


        $("#subjectsInput").setValue(subjectsInput);
        $(byText("Maths")).click();

        $("#hobbiesWrapper").$(byText(hobbiesWrapper)).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));

        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

        //Checkings
        $(".modal-header").shouldBe(text(
                "Thanks for submitting the form"));
        $$("tr").find(Condition.text("Student Name"))
                .$$("td").get(1).shouldHave(Condition.text(firstName + " " + lastName));
        $$("tr").find(Condition.text("Student Email"))
                .$$("td").get(1).shouldHave(Condition.text(userEmail));
        $$("tr").find(Condition.text("Gender"))
                .$$("td").get(1).shouldHave(Condition.text(genterWrapper));
        $$("tr").find(Condition.text("Mobile"))
                .$$("td").get(1).shouldHave(Condition.text(userNumber));
        $$("tr").find(Condition.text("Date of Birth"))
                .$$("td").get(1).shouldHave(Condition.text("10 August,1999"));
        $$("tr").find(Condition.text("Subjects"))
                .$$("td").get(1).shouldHave(Condition.text("Maths"));
        $$("tr").find(Condition.text("Hobbies"))
                .$$("td").get(1).shouldHave(Condition.text(hobbiesWrapper));
        $$("tr").find(Condition.text("Picture"))
                .$$("td").get(1).shouldHave(Condition.text("map.jpg"));
        $$("tr").find(Condition.text("Address"))
                .$$("td").get(1).shouldHave(Condition.text(currentAddress));
        $$("tr").find(Condition.text("State and City"))
                .$$("td").get(1).shouldHave(Condition.text(state +" " + city));













    }



}
