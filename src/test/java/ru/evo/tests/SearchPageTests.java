package ru.evo.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import ru.evo.helpers.DriverUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("searchpage")
@Owner("anikknik")
@Severity(SeverityLevel.BLOCKER)
@Feature("Страница поиска фильмов с фильтрами")
@Story("Возможность найти фильмы по различным заданным критериям")
public class SearchPageTests extends TestBase {

    @Test
    @DisplayName("Проверка успешного открытия страницы расширенного поиска")
    void checkSearchPage() {
        step("Проверить, что заголовок блока поиска называется \"Расширенный поиск\"", () ->
                $("h1 .text-orange").shouldHave(text("Расширенный поиск"))
        );
    }

    @Test
    @DisplayName("Проверка наличия в расширенном поиске блока \"Искать фильм\"")
    void findFilmBlock() {
        step("Проверить, что в блоке \"Расширенный поиск\" " +
                "присутствует блок с названием \"Искать фильм\"", () ->
                $("#searchAdv").shouldHave(text("Искать фильм:"))
        );
    }

    @Test
    @DisplayName("Поиск фильма по названию кириллицей")
    void findCyrillicTitle() {
        step("Ввести в поле поиска \"Искать фильм:\" \"Робокоп\" и нажать Поиск", () -> {
            $("#find_film").setValue("Робокоп");
            $(".el_18.submit.nice_button").click();
        });
        step("Проверить, что в блоке \"Скорее всего, вы ищете:\" " +
                "отображается фильм \"Робокоп 1987\"", () ->
                $(".element.most_wanted").shouldHave(text("Робокоп"))
                        .shouldHave(text("1987"))
        );
    }

    @Test
    @DisplayName("Поиск фильма по названию латиницей")
    void findLatinTitle() {
        step("Ввести в поле поиска \"Искать фильм:\" \"Robocop\" и нажать Поиск", () -> {
            $("#find_film").setValue("Robocop");
            $(".el_18.submit.nice_button").click();
        });
        step("Проверить, что в блоке \"Скорее всего, вы ищете:\" " +
                "отображается фильм \"Робокоп 1987\"", () ->
                $(".element.most_wanted").shouldHave(text("Робокоп"))
                        .shouldHave(text("1987"))
        );
    }

    @Test
    @Description("Негативная проверка строки поиска рандомным набором букв")
    @DisplayName("Поиск фильма с названием из набора букв разного регистра")
    void findRandomLetterTitle() {
        step("Ввести в поле поиска \"Искать фильм:\" \"aAdawAW\" и нажать Поиск", () -> {
            $("#find_film").setValue("aAdawAW");
            $(".el_18.submit.nice_button").click();
        });
        step("Проверить, что на странице отобразилась надпись " +
                "\"К сожалению, по вашему запросу ничего не найдено...\"", () ->
                $("#block_left_pad h2")
                        .shouldHave(text("К сожалению, по вашему запросу ничего не найдено..."))
        );
    }

    @Test
    @Description("Негативная проверка строки поиска символами")
    @DisplayName("Поиск фильма с названием из символов")
    void findRandomSymbolsTitle() {
        step("Ввести в поле поиска \"Искать фильм:\" \"&$%\" и нажать Поиск", () -> {
            $("#find_film").setValue("&$%");
            $(".el_18.submit.nice_button").click();
        });
        step("Проверить, что на странице отобразилась надпись " +
                "\"К сожалению, по вашему запросу ничего не найдено...\"", () ->
                $("#block_left_pad h2")
                        .shouldHave(text("К сожалению, по вашему запросу ничего не найдено..."))
        );
    }

    @Disabled("Пример. Нужно переписать")
    @Test
    @DisplayName("Проверка заголовка страницы")
    void titleTest() {
        step("Page title should have text 'Security check'", () -> {
            String expectedTitle = "Security check"; // expected:"Расширенный поиск"
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Проверка отсутствия ошибок в консоли")
    void consoleShouldNotHaveErrorsTest() {
        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}