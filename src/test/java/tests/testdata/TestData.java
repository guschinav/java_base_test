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




        Faker faker = new Faker(new Locale("en"));;
        public  String firstNameFake = faker.name().firstName();
        public  String lastNameFake = faker.name().lastName();
        public  String userEmailFake = faker.internet().emailAddress();
        public  String genderWrapperFake = faker.options().option("Male", "Female", "Other");
        public  String userNumberFake = faker.number().digits(10);
        Date birthDate = faker.date().birthday(16, 85);
        SimpleDateFormat yearFormat= new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat= new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat dayFormat= new SimpleDateFormat("dd");
        public  String yearFake = yearFormat.format(birthDate);
        public  String monthFake = monthFormat.format(birthDate);
        public  String dayFake = dayFormat.format(birthDate);

        public  String subjectsInputTypeFake = faker.options().option("M", "Chemi", "Comput", "Comm");
        public String subjectsInputFake = switch (subjectsInputTypeFake) {
            case "M" -> "Maths";
            case "Chemi" -> "Chemistry";
            case "Comput" -> "Computer Science";
            case "Comm" -> "Commerce";
            default -> null;
    };

        public  String hobbiesWrapperFake = faker.options().option("Sports", "Reading", "Music");
        public  String pictureFake = faker.options().option("map.jpg", "pam.jpg");
        public  String currentAddressFake = faker.address().fullAddress();

        public  String stateFake = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

        public String cityFake = switch (stateFake) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> null;
    };













}
