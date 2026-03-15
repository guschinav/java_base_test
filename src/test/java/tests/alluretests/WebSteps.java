package tests.alluretests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");

    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".input-button").click();
        $("#query-builder-test").setValue(repo).submit();
        $(".search-title").click();

    }
    @Step("Переходим во вкладку Issues")
    public void clickTabIssues() {
        $("[data-content='Issues']").click();

    }
    @Step("Проверяем что существует Issues в именем {name}")
    public void shouldSeeIssueWithName(String name) {
        $(byText(name)).shouldBe(visible);
    }


}
