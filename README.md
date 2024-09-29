# Проект автоматизации тестирования сервиса HeadHunter

## Содержание
1. [Описание](#описание)
2. [Ссылки](#ссылки)
3. [Использованные Технологии и инструменты](#использованные-технологии-и-инструменты)
4. [Запуск тестов](#запуск-тестов)
   - [Локальный запуск тестов](#локальный-запуск-тестов)
   - [Параметры web тестов](#параметры-web-тестов)
   - [Параметры android тестов](#параметры-android-тестов)
   - [Сборка тестов в Jenkins](#сборка-тестов-в-jenkins)
5. [Интеграции](#интеграции)
   - [Интеграция с Allure report](#интеграция-с-allure-report)
   - [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
   - [Уведомления в Telegram](#уведомления-в-telegram-с-использованием-бота)
6. [Технические особенности](#технические-особенности)

## Описание

Данный проект направлен на автоматизацию Web/ API/ Android тестов для сервиса headhunter.  <br/>
Headhunter - сервис, который помогает найти работу и подобрать персонал. <br/>

## Ссылки

### Jenkins: 
- Джоба запуска [api автотестов](https://jenkins.autotests.cloud/view/ArtemLe/job/ArtemLeHH%20api/)
- Джоба запуска [android автотестов](https://jenkins.autotests.cloud/view/ArtemLe/job/ArtemLeHH%20Mobile/)
- Джоба запуска [web автотестов](https://jenkins.autotests.cloud/view/ArtemLe/job/ArtemLeHH%20web/)

### Test ops
- Проект [api автотестов](https://allure.autotests.cloud/project/4451)
- Проект [android автотестов](https://allure.autotests.cloud/project/4452)
- Проект [web автотестов](https://allure.autotests.cloud/project/4450/dashboards)

## Использованные Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="src/test/resources/images/Idea.svg" width="50"/></a>
<a href="https://www.java.com/"><img alt="Java" height="50" src="src/test/resources/images/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="src/test/resources/images/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="src/test/resources/images/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="src/test/resources/images/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="src/test/resources/images/Selenoid.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="src/test/resources/images/RestAssured.svg" width="50"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="50" src="src/test/resources/images/browserstack.png" width="50"/></a>
<a href="https://appium.io/"><img alt="Appium" height="50" src="src/test/resources/images/Appium.svg" width="50"/></a>
<a href="https://developer.android.com/studio"><img alt="Android Studio" height="50" src="src/test/resources/images/android.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="src/test/resources/images/Jenkins.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="src/test/resources/images/Allure_TO.svg" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="src/test/resources/images/Telegram.png" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="src/test/resources/images/lombok.png" width="50"/></a>
   <a href="https://telegram.org/"><img alt="Telegram" height="50" src="src/test/resources/images/jira.png" width="50"/></a>
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

### Сборка тестов в Jenkins
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

#### Пример прохождения автотестов:

   <img src="src/test/resources/images/allure_run_example.png">
   <img src="src/test/resources/images/allure_run_example_2.png">

### Интеграция с <b><a target="_blank" href="https://jira.autotests.cloud/browse/">Jira</a></b>

#### Пример задачи в jira:

   <img src="src/test/resources/images/jira_example.png">

### Интеграция с <b><a target="_blank" href="https://allure.autotests.cloud/project/4450/dashboards">Allure TestOps</a></b>
#### Пример прохождения автотестов:

<img src="src/test/resources/images/testops_run_example.png">

### Уведомления в Telegram с использованием бота

> Бот, созданный в Telegram, после завершения сборки отправляет сообщение с отчетом о прохождении тестов
>
<img src="src/test/resources/images/telegram_run_example.png">

## Технические особенности

> [!NOTE]
> Убедитесь, что у вас установлены Java, Gradle, IntelliJ IDEA, Appium server.
> Для mobile тестов - подключено устройство или установлен эмулятор и запущен Appium Server

