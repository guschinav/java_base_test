package tests.alluretests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;


public class AllureReportTests {

    private static final String REPOSITORY = "guschinav/java_base_test";
    private static final String ISSUE = "Test Issues";

    @Test
    @DisplayName("Чистый Selenide")
    void selenideIssueCheckTest () {
        Screenshot screenshot = new Screenshot();
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".input-button").click();
        $("#query-builder-test").setValue("guschinav/java_base_test").submit();
        $(".search-title").click();
        $("[data-content='Issues']").click();
        $(byText("Test Issues")).shouldBe(visible);
        screenshot.takeScreenshot();
    }


    @Test
    @DisplayName("Лямбда")
    void lambdaIssueCheckTest () {
        Screenshot screenshot = new Screenshot();
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".input-button").click();
            $("#query-builder-test").setValue(REPOSITORY).submit();
            $(".search-title").click();
        });
        step("Переходим во вкладку Issues", () -> {
            $("[data-content='Issues']").click();
        });


        step("Проверяем что существует Issues в именем" + ISSUE, () -> {
            $(byText(ISSUE)).shouldBe(visible);
        });
        screenshot.takeScreenshot();
    }

    @Test
    @DisplayName("Шаги с аннотацией")
    public void StepIssueCheckTest (){
        WebSteps steps = new WebSteps();
        Screenshot screenshot = new Screenshot();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickTabIssues();
        steps.shouldSeeIssueWithName(ISSUE);
        screenshot.takeScreenshot();
    }


}
