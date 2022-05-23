package ru.evo.tests;

import org.junit.jupiter.api.BeforeEach;
import ru.evo.helpers.AllureAttachments;
import ru.evo.helpers.DriverSettings;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @BeforeEach
    void openSearchPage() {
        step("Открываем страницу поиска", () ->
                open("https://www.kinopoisk.ru/s/")
        );
    }

    @AfterEach
    public void addAttachments() {

        AllureAttachments.screenshotAs("Last Screenshot");
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.pageSource();
        AllureAttachments.addVideo();
        Selenide.closeWebDriver();
    }
}
