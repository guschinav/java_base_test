package tests.testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {
    public static String firstName = "Vladimir";
    public static String lastName = "Smith";
    public static String userEmail = "vlOdimir@mail.com";
    public static String genderWrapper = "Male";
    public static String userNumber = "0123456789";
    public static String month = "August";
    public static String year = "1999";
    public static String day = "10";
    public static String subjectsInput = "Maths";
    public static String hobbiesWrapper = "Sports";
    public static String currentAddress = "Address";
    public static String state = "NCR";
    public static String city = "Delhi";
    public static String picture = "map.jpg";


    //Fake
    public static String firstNameFake,
            lastNameFake,
            userEmailFake,
            genderWrapperFake,
            userNumberFake,
            monthFake,
            yearFake,
            dayFake,
            subjectsInputFake,
            subjectsInputTypeFake,
            hobbiesWrapperFake,
            pictureFake,
            currentAddressFake,
            stateFake,
            cityFake;

    public static void fakeTestData(){
        Faker faker = new Faker(new Locale("en"));;
        firstNameFake = faker.name().firstName();
        lastNameFake = faker.name().lastName();
        userEmailFake = faker.internet().emailAddress();
        genderWrapperFake = faker.options().option("Male", "Female", "Other");
        userNumberFake = faker.number().digits(10);
        Date birthDate = faker.date().birthday(16, 85);
        SimpleDateFormat yearFormat= new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat= new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat dayFormat= new SimpleDateFormat("dd");
        yearFake = yearFormat.format(birthDate);
        monthFake = monthFormat.format(birthDate);
        dayFake = dayFormat.format(birthDate);

        subjectsInputTypeFake = faker.options().option("M", "Chemi", "Comput", "Comm");
        if (subjectsInputTypeFake.equals("M")){
            subjectsInputFake = "Maths";
        } else if (subjectsInputTypeFake.equals("Chemi")) {
            subjectsInputFake = "Chemistry";
        } else if (subjectsInputTypeFake.equals("Comput")){
            subjectsInputFake = "Computer Science";
        } else {
            subjectsInputFake = "Commerce";
        }

        hobbiesWrapperFake = faker.options().option("Sports", "Reading", "Music");
        pictureFake = faker.options().option("map.jpg", "pam.jpg");
        currentAddressFake = faker.address().fullAddress();

        stateFake = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

        if (stateFake.equals("NCR")) cityFake = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (stateFake.equals("Uttar Pradesh")) cityFake = faker.options().option("Agra", "Lucknow", "Merrut");
        if (stateFake.equals("Haryana")) cityFake = faker.options().option("Karnal", "Panipat");
        if (stateFake.equals("Rajasthan")) cityFake = faker.options().option("Jaipur", "Jaiselmer");




    }








}
