package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.testdata.TestData;

import static tests.testdata.TestData.*;

public class AutomationPracticeForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

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
                .typeFirstName(testData.firstNameFake)
                .typeLastName(testData.lastNameFake)
                .typeEmail(testData.userEmailFake)
                .setGender(testData.genderWrapperFake)
                .typeUserNumber(testData.userNumberFake)
                .setDateOfBirth(testData.dayFake, testData.monthFake, testData.yearFake)
                .typeSubjectsInput(testData.subjectsInputTypeFake ,testData.subjectsInputFake)
                .setHobbies(testData.hobbiesWrapperFake)
                .selectPicture(testData.pictureFake)
                .typeCurrentAddress(testData.currentAddressFake)
                .setStateAndCity(testData.stateFake, testData.cityFake)
                .submitForm()

                //Checkings
                .checkCompleatedForm("Thanks for submitting the form")
                .checkResult("Student Name", testData.firstNameFake + " " + testData.lastNameFake)
                .checkResult("Student Email", testData.userEmailFake)
                .checkResult("Gender", testData.genderWrapperFake)
                .checkResult("Mobile", testData.userNumberFake)
                .checkResult("Date of Birth", testData.dayFake + " " + testData.monthFake + ","+ testData.yearFake)
                .checkResult("Subjects", testData.subjectsInputFake)
                .checkResult("Hobbies", testData.hobbiesWrapperFake)
                .checkResult("Picture", testData.pictureFake)
                .checkResult("Address", testData.currentAddressFake)
                .checkResult("State and City", testData.stateFake + " " + testData.cityFake);

    }



}
