package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.AddressComponent;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static tests.testdata.TestData.*;
import static tests.testdata.TestData.city;

public class RegistrationPage {
   CalendarComponent calendar = new CalendarComponent();
   AddressComponent stateAndCity = new AddressComponent();
        // Elements
   private SelenideElement firstNameInput = $(("#firstName"));
   private SelenideElement lastNameInput = $(("#lastName"));
   private SelenideElement emailInput = $(("#userEmail"));
   private SelenideElement genderContainer = $(("#genterWrapper"));
   private SelenideElement userNumberInput = $(("#userNumber"));
   private SelenideElement subjectsInput = $(("#subjectsInput"));
   private SelenideElement hobbiesContainer = $(("#hobbiesWrapper"));
   private SelenideElement pictureUpload = $(("#uploadPicture"));
   private SelenideElement currentAddressInput = $(("#currentAddress"));
   private SelenideElement submitButton = $(("#submit"));
   private SelenideElement compleatedForm = $((".modal-header"));
   private SelenideElement responsiveTable = $((".table-responsive"));




    // Actions
    public RegistrationPage openPage(){
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        return this;
    }

    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderContainer.$(byText(value)).click();
        return this;
    }
    public RegistrationPage typeUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }
    public RegistrationPage typeSubjectsInput(String type, String value){
        subjectsInput.setValue(type);
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setHobbies(String value){
        hobbiesContainer.$(byText(value)).click();
        return this;
    }
    public RegistrationPage selectPicture(String value){
        pictureUpload.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city){
        stateAndCity.setStateAndCity(state,city);
        return this;
    }

    public RegistrationPage submitForm(){
        submitButton.click();
        return this;
    }

    public RegistrationPage checkCompleatedForm(String value){
        compleatedForm.shouldBe(text(value));
        return this;
    }
    private void checkField(String key, String value) {
        responsiveTable
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
    }

    public RegistrationPage checkResponsiveTable(
            String firstName, String lastName,
            String userEmail,
            String gender,
            String userNumber,
            String day, String month, String year,
            String subjectsInput,
            String hobbiesWrapper,
            String picture,
            String currentAddress,
            String state, String city) {

        checkField("Student Name", firstName + " " + lastName);
        checkField("Student Email", userEmail);
        checkField("Gender", gender);
        checkField("Mobile", userNumber);
        checkField("Date of Birth", day + " " + month + ","+ year);
        checkField("Subjects", subjectsInput);
        checkField("Hobbies", hobbiesWrapper);
        checkField("Picture", picture);
        checkField("Address", currentAddress);
        checkField("State and City", state + " " + city);

        return this;
    }
}




