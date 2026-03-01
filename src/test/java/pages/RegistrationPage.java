package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
   CalendarComponent calendar = new CalendarComponent();
   TableResultComponent tableResult = new TableResultComponent();
        // Elements
   private final SelenideElement firstNameInput = $("#firstName");
   private final SelenideElement lastNameInput = $("#lastName");
   private final SelenideElement emailInput = $("#userEmail");
   private final SelenideElement genderContainer = $("#genterWrapper");
   private final SelenideElement userNumberInput = $(("#userNumber"));
   private final SelenideElement subjectsInput = $("#subjectsInput");
   private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
   private final SelenideElement pictureUpload = $("#uploadPicture");
   private final SelenideElement currentAddressInput = $("#currentAddress");
   private final SelenideElement stateAndCityContainer= $("#stateCity-wrapper");
   private final SelenideElement submitButton = $("#submit");
   private final SelenideElement compleatedForm = $(".modal-header");





    // Actions
    public RegistrationPage openPage(){
        open("");
        return this;
    }
    public RegistrationPage clickForms(){
        $$(".card-body").findBy(text("Forms")).click();
        return this;
    }

    public RegistrationPage clickPracticeForm(){
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
        $("#state").click();
        stateAndCityContainer.$(byText(state)).click();
        $("#city").click();
        stateAndCityContainer.$(byText(city)).click();
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

    public  RegistrationPage checkResult (String key, String value){
        tableResult.checkResult(key, value);

        return this;

    }
}






