package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.testdata.TestData.*;

public class AutomationPracticeForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void sucessfulFillPracticeFormTest (){
        registrationPage.openPage()
                .clickForms()
                .clickPracticeForm()
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


    @Test
    void sucessfulFillPracticeFormTestWithFakeData (){
        registrationPage.openPage()
                .clickForms()
                .clickPracticeForm()
                .typeFirstName(firstNameFake)
                .typeLastName(lastNameFake)
                .typeEmail(userEmailFake)
                .setGender(genderWrapperFake)
                .typeUserNumber(userNumberFake)
                .setDateOfBirth(dayFake, monthFake, yearFake)
                .typeSubjectsInput(subjectsInputTypeFake,subjectsInputFake)
                .setHobbies(hobbiesWrapperFake)
                .selectPicture(pictureFake)
                .typeCurrentAddress(currentAddressFake)
                .setStateAndCity(stateFake, cityFake)
                .submitForm()

                //Checkings
                .checkCompleatedForm("Thanks for submitting the form")
                .checkResult("Student Name", firstNameFake + " " + lastNameFake)
                .checkResult("Student Email", userEmailFake)
                .checkResult("Gender", genderWrapperFake)
                .checkResult("Mobile", userNumberFake)
                .checkResult("Date of Birth", dayFake + " " + monthFake + ","+ yearFake)
                .checkResult("Subjects", subjectsInputFake)
                .checkResult("Hobbies", hobbiesWrapperFake)
                .checkResult("Picture", pictureFake)
                .checkResult("Address", currentAddressFake)
                .checkResult("State and City", stateFake + " " + cityFake);

    }



}
