package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.testdata.TestData.*;

public class AutomationPracticeForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void sucessfulFillPracticeFormTest (){
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(genderWrapper)
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
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genderWrapper)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + ","+ year)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Hobbies", hobbiesWrapper)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);

    }



}
