import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTestWithLambdaSteps {

    private final static String user = "catcat4er";
    private final static String rep = "AllureLesson";
    private final static String tab = "Issues";
    private final static int num = 1;

    @Test

    public void issueSearchTest() {

        step("Открываем страницу github ", () -> {
            open("https://github.com/");
            });

        step("В поиске найти адресата", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(user + "/" + rep);
            $(".header-search-input").submit();
            });

        step("Выбрать репозиторий из списка", () -> {
            $(linkText("catcat4er/AllureLesson")).click();
        });

        step("Переходим во вкладку " + tab, () -> {
            $(partialLinkText(tab)).click();
        });

        step("Проверяем наличие # " + num + " " +tab, () -> {
            $(withText("#1")).should(Condition.visible);
        });

    }
}




