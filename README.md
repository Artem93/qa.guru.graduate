# Проект автоматизации тестирования ресурса HeadHunter

## Содержание
1. [Описание](#описание)
2. [Использованные Технологии и инструменты](#использованные-технологии-и-инструменты)
3. [Запуск тестов](#запуск-тестов)
   - [Локальный запуск тестов](#локальный-запуск-тестов)
   - [Параметры web тестов](#параметры-web-тестов)
   - [Параметры android тестов](#параметры-android-тестов)
   - [Сборка тестов в Jenkins](#сборка-тестов-в-jenkins)
4. [Интеграции](#интеграции)
   - [Интеграция с Allure report](#интеграция-с-allure-report)
   - [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
   - [Уведомления в Telegram](#уведомления-в-telegram)
5. [Технические особенности](#технические-особенности)

## Описание

Проект позволяет запускать Web/ API/ Android тесты сервиса headhunter. Headhunter - сервис, который помогает найти работу и подобрать персонал. <br/>

## Использованные Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="src/test/resources/icons/Idea.svg" width="50"/></a>
<a href="https://www.java.com/"><img alt="Java" height="50" src="src/test/resources/icons/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="src/test/resources/icons/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="src/test/resources/icons/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="src/test/resources/icons/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="src/test/resources/icons/Selenoid.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="src/test/resources/icons/RestAssured.svg" width="50"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="50" src="src/test/resources/icons/browserstack.png" width="50"/></a>
<a href="https://appium.io/"><img alt="Appium" height="50" src="src/test/resources/icons/Appium.svg" width="50"/></a>
<a href="https://developer.android.com/studio"><img alt="Android Studio" height="50" src="src/test/resources/icons/android.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="src/test/resources/icons/Jenkins.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="src/test/resources/icons/Allure_TO.svg" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="src/test/resources/icons/Telegram.png" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="src/test/resources/icons/lombok.png" width="50"/></a>
</div>

## Запуск тестов
### Локальный запуск тестов

Для запуска следует открыть IntelliJ IDEA и выполнить в терминале:

- Для запуска всех тестов
```
gradle clean test
```
или
```
gradle clean test -Dtag=all
```
-  WEB
```
gradle clean -Dtag=web
```
- API
```
gradle clean -Dtag=api 
```
- Mobile
```
gradle clean -Dtag=mobile
```

#### Параметры web тестов

```
-Dbrowser - наименование браузера (значение по умолчанию: chrome)
-DbrowserVersion - номер версии браузера (значение по умолчанию: 129.0)
-Dresolution - размер окна браузера.(значение по умолчанию: 1980x1080)
-DremoteUrl - адрес удаленного сервера, на котором будут запускаться тесты
```

#### Параметры android тестов

```
-DdeviceHost - метод запуска (значение по умолчанию: browserstack). Возможные значения: 
  -- browserstack - для запуска на browserstack
  -- emulation - для запуска на эмуляторе
  -- real - для запуска на реальном устройстве, которое подключено
```
> [!NOTE]
> Дополнительные параметры запуска для browserstack, emulation и real хостов не нужно передавать в формате переменных.
> Благодаря библиотеке owner достаточно менять их в конфигурационных файлах `.properties`, которые лежат в папке `resources`. <br/>

<details>
   <summary>Дополнительные команды:</summary>

1. Выполнить запрос на формирование отчета:

```
gradle allureReport
```

2. Открыть отчет в браузере:

```
gradle allureServe
```

</details>

### Cборка тестов в Jenkins
>#### <b><a target="_blank" href="https:/jenkins.autotests.cloud/view/ArtemLe/job/ArtemLe_HH_web/">Web</a></b>
> Для запуска сборки необходимо перейти в раздел `Build with Parameters`, если требуется выбрать нужные параметры
> BROWSER или RESOLUTION и нажать кнопку `Build`

> #### <b><a target="_blank" href="https://jenkins.autotests.cloud/view/ArtemLe/job/ArtemLeHH%20Mobile/">Mobile</a></b>
> Для запуска сборки необходимо перейти в раздел `Build with Parameters`, если требуется выбрать нужный параметр
> ENV и нажать кнопку `Build`

> #### <b><a target="_blank" href="https://jenkins.autotests.cloud/view/ArtemLe/job/ArtemLeHH%20api/">Api</a></b>
> У сборки нет параметров, достаточно нажать  `Build Now`.

## Интеграции
### Интеграция с <b><a target="_blank" href="https://jenkins.autotests.cloud/view/ArtemLe/job/ArtemLe_HH_web/allure/">Allure report</a></b>
#### Диаграммы прохождения тестов

`ALLURE REPORT` - отображает дату и время теста, общее количество запущенных тестов, а также диаграмму с процентом и
количеством успешных, упавших и сломавшихся в процессе выполнения тестов <br/>
`TREND` - отображает тенденцию выполнения тестов для всех запусков <br/>
`SUITES` - отображает распределение тестов по сьютам <br/>
`CATEGORIES` - отображает распределение неудачных тестов по типам дефектов

#### Пример прохождения автотестов:

   <img src="images/screenshots/allure-suites.png">

### Интеграция с <b><a target="_blank" href="https://allure.autotests.cloud/project/4450/dashboards">Allure TestOps</a></b>
#### Пример прохождения автотестов:

<img src="images/screenshots/allure-testops-dashboards.png">

### Уведомления в Telegram с использованием бота

> Бот, созданный в Telegram, после завершения сборки отправляет сообщение с отчетом о прохождении тестов
>
<img src="images/screenshots/telegram-notification.png">

## Технические особенности

> [!NOTE]
> Убедитесь, что у вас установлены Java, Gradle, IntelliJ IDEA, Appium server.
> Для mobile тестов - подключено устройство или установлен эмулятор и запущен Appium Server

