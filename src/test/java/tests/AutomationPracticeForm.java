package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.*;

public class AutomationPracticeForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void sucessfulFillPracticeFormTest (){
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(genterWrapper)
                .typeUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .typeSubjectsInput("M",subjectsInput)
                .setHobbies(hobbiesWrapper)
                .selectPicture(picture)
                .setStateAndCity(state,city)
                .typeCurrentAddress(currentAddress)
                .submitForm()

                //Checkings
                .checkCompleatedForm("Thanks for submitting the form")
                .checkResponsiveTable(firstName, lastName,
                        userEmail,
                        genterWrapper,
                        userNumber,
                        day, month, year,
                        subjectsInput,
                        hobbiesWrapper,
                        picture,
                        currentAddress,
                        state, city);
    }



}
