package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.testdata.CountryNike;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JUnit5Tests {


    @DisplayName("Тест на отображаемый текст приветствия, на главной странице")
    @EnumSource(CountryNike.class)
    @ParameterizedTest
    void nikeSiteShouldDisplayCorrectText (CountryNike countryNike){
        Configuration.browserSize = "1920x1080";
        open("https://www.nike.com/");

        $("[data-testid='language-tunnel'] button").click();
        $(".css-m1qx52").find(byText(countryNike.name())).click();
        executeJavaScript("window.scrollBy(0, 500);");
        $$("h3[data-qa='title']")
                .findBy(text(countryNike.description))
                .shouldBe(visible);


    }

    static Stream<Arguments> nikeSiteShouldDisplayCorrectButtons () {
        return  Stream.of(
                Arguments.of(CountryNike.Finland, List.of("New",
                        "Men",
                        "Women",
                        "Kids",
                        "Sport",
                        "NikeSKIMS"
                )),
                Arguments.of(CountryNike.México, List.of("Lo Nuevo",
                        "Hombre",
                        "Mujer",
                        "Niños",
                        "Ofertas",
                        "SNKRS"))
        );


    }

    @DisplayName("Тест на отображаемые кнопки на верхней панели ")
    @MethodSource
    @ParameterizedTest(name = "{index} - {0}")
    void nikeSiteShouldDisplayCorrectButtons (CountryNike countryNike, List<String> expectedButtons){
        Configuration.browserSize = "1920x1080";
        open("https://www.nike.com/");

        $("[data-testid='language-tunnel'] button").click();
        $(".css-m1qx52").find(byText(countryNike.name())).click();
        $$(".desktop-category a").filter((visible))
                        .shouldHave(texts(expectedButtons));


    }



    @DisplayName("Тест на смену страны")
    @ValueSource (strings = {
        "Finland", "Romania"
    })
    @ParameterizedTest(name = "{index} - {0}")
    void nikeSiteShouldDisplayCorrectUrl (String param){
        Configuration.browserSize = "1920x1080";
        open("https://www.nike.com/");

        $("[data-testid='language-tunnel'] button").click();
        $(".css-m1qx52").find(byText(param)).click();



    }


}
