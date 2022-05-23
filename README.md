# Пример автоматизации поисковой страницы сервиса Кинопоиск

## :page_with_curl:    Содержание

➠ [Покрытый функционал](#globe_with_meridians-покрытый-функционал)

➠ [Технологический стек](#computer-технологический-стек)

➠ [Запуск тестов из терминала](#technologist-запуск-тестов-из-терминала)

➠ [Удаленный запуск тестов](#удаленный-запуск-тестов)

➠ [Сборка в Jenkins](#Jenkins_sborka)

➠ [Отчет о результатах тестирования в Allure Report](#Allure_report)

➠ [Уведомления в Telegram с использованием бота](#Telegram_report)

➠ [Пример запуска теста в Selenoid](#selenoid_video)
## <a name="globe_with_meridians-покрытый-функционал"></a>:globe_with_meridians: Покрытый функционал

### UI

:white_check_mark: Проверка успешного открытия страницы расширенного поиска
:white_check_mark: Проверка наличия в расширенном поиске блока "Искать фильм"
:white_check_mark: Поиск фильма по названию кириллицей
:white_check_mark: Поиск фильма по названию латиницей
:negative_squared_cross_mark: Поиск фильма с названием из набора букв разного регистра
:negative_squared_cross_mark: Поиск фильма с названием из символов 
:white_check_mark: Проверка отсутствия ошибок в консоли
:ballot_box_with_check: Page title should have header text

:white_check_mark: - позитивные кейсы
:negative_squared_cross_mark: - негативные кейсы
:ballot_box_with_check: - пропущенные (требуется доработка)

## :computer: Технологический стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/sprites/Intelij_IDEA.6aca1163.svg">
<img width="6%" title="Java" src="images/sprites/Java.15d76882.svg">
<img width="6%" title="JUnit5" src="images/sprites/JUnit5.a799eb2a.svg">
<img width="6%" title="Selenide" src="images/sprites/Selenide.0170ac43.png">
<img width="6%" title="Gradle" src="images/sprites/Gradle.22e74204.svg">
<img width="6%" title="GitHub" src="images/sprites/Github.97faa3bc.svg">
<img width="6%" title="Jenkins" src="images/sprites/Jenkins.e8031169.svg">
<img width="6%" title="Selenoid" src="images/sprites/Selenoid.8de18e28.svg">
<img width="6%" title="Allure Report" src="images/sprites/Allure_Report.52dae7a1.png">
<img width="6%" title="Telegram" src="images/sprites/Telegram.06a4926c.svg">
</p>

## :technologist: Запуск тестов из терминала

### Локальный запуск тестов

```
gradle clean searchpage
```

### Удаленный запуск тестов

```
clean
searchpage
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-Dremote=${REMOTE_URL}
```

### Параметры сборки

> <code>BROWSER</code> – браузер, в котором будут выполняться тесты (_по умолчанию - <code>chrome</code>_).
>
> <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты (_по умолчанию - <code>1920x1080</code>_).
>
> <code>BROWSER_VERSION</code> – версия вебдрайвера браузера (_по умолчанию - <code>99</code>_).
>
> <code>REMOTE_URL</code> – адрес удалённого стенда для запуска браузера.

## <img width="4%" title="Jenkins" name="Jenkins_sborka" src="images/sprites/Jenkins.e8031169.svg"> Главная страница сборки [Jenkins](https://jenkins.autotests.cloud/job/12-anikknik-homework13/)

<p align="center">
  <img src="images/screenshots/main_jenkins.png">
</p>

## <img width="4%" title="Allure Report" name="Allure_report" src="images/sprites/Allure_Report.52dae7a1.png"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/12-anikknik-homework13/allure/)

### :pushpin: Стартовая страница Allure-отчета

<p align="center">
<img title="Allure Overview" src="images/screenshots/overview_allure.png">
</p>

### :pushpin: Вид тест-кейсов

<p align="center">
<img title="Allure Behaviors" src="images/screenshots/behaviors_allure.png">
</p>

### :pushpin: Графики тест-ранов

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/graphs_allure.png">
</p>

## <img width="4%" title="Telegram" name="Telegram_report" src="images/sprites/Telegram.06a4926c.svg"> Репорт в Telegram с помощью бота

> После завершения сборки бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом.
<p align="center">

<img title="Telegram Notifications" src="images/screenshots/report_telegram.png">
</p>

## <img width="4%" title="Selenoid" name="selenoid_video" src="images/sprites/Selenoid.8de18e28.svg"> Пример запуска теста в Selenoid

> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="https://user-images.githubusercontent.com/63372457/169886331-a9092355-64da-4aef-b25d-44cab1e1053e.mp4">
</p>

:black_heart: <a target="_blank" href="https://t.me/anikknik">t.me/anikknik</a>
