package AnnotationMethods;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AnnotationMethods {

    private final static String user = "catcat4er";
    private final static String rep = "AllureLesson";
    private final static String tab = "Issues";
    private final static int num = 1;

    @Step("Открываем страницу github ")
    public AnnotationMethods openPG () {
        open("https://github.com/");
        return this;
    }

    @Step ("В поиске найти адресата")
    public AnnotationMethods searchRepository () {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(user + "/" + rep);
        $(".header-search-input").submit();
        return this;
    }

    @Step ("Выбрать репозиторий из списка")
    public AnnotationMethods chooseRepository () {
        $(linkText("catcat4er/AllureLesson")).click();
        return this;
    }

    @Step ("Переходим во вкладку" + tab)
    public AnnotationMethods enterToRepository () {
        $(partialLinkText(tab)).click();
        return this;
    }

    @Step ("Проверяем наличие # "+ num + " " + tab)
    public AnnotationMethods validationIssue () {
        $(withText("#1")).should(Condition.visible);
        return this;
    }

}
