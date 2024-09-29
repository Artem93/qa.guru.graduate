package qa.guru.graduate.tests.web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import qa.guru.graduate.pages.webPages.*;

import static com.codeborne.selenide.Selenide.open;
import static qa.guru.graduate.helpers.Constants.searchRequestQa;

@Epic("Web tests")
@Feature("General page elements")
@DisplayName("General page elements tests")
public class GeneralePageTests extends WebTestBase {

    private final GeneralPage generalPage = new GeneralPage();
    private final EmployerPage employerPage = new EmployerPage();
    private final AreaSwitcherPage areaSwitcherPage = new AreaSwitcherPage();
    private final ModalLoginPage modalLoginPage = new ModalLoginPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Tags({
            @Tag("web"),
            @Tag("all")
    })
    @Owner("Artem Lepkin")
    @Test
    @DisplayName("Проверка кнопок в хедере страницы")
    @AllureId("34664")
    void checkMainHeaderBlockTest() {
        open("");
        generalPage
                .checkVisibleAreaSwitcher()
                .checkVisibleApplicantElement()
                .checkEmployerElement()
                .checkExpertResumeElement()
                .checkApplicantServicesElement();
    }

    @Tags({
            @Tag("web"),
            @Tag("all")
    })
    @Owner("Artem Lepkin")
    @ParameterizedTest(name = "Смена города на {0}")
    @ValueSource(strings = {"Воронеж", "Гомель"})
    @DisplayName("Проверка смены города.")
    @AllureId("34666")
    void checkChangeCityTest(String city) {
        open("");
        generalPage
                .clickAreaSwitcher();
        areaSwitcherPage
                .checkVisibleAreaSwitcher()
                .selectCity(city)
                .checkNotExistAreaSwitcher();
        generalPage.checkAreaSwitcherContainCity(city);

    }

    @Tags({
            @Tag("web"),
            @Tag("all")
    })
    @Owner("Artem Lepkin")
    @Test
    @DisplayName("Переход на страницу для работодателей")
    @AllureId("34667")
    void checkMoveToEmployerPageByHeaderLinkTest() {
        open("");
        generalPage
                .clickEmployerElement();
        employerPage
                .checkVisibleEmployerTitle()
                .checkVisibleEmployerSubtitle()
                .checkVisiblePublishVacancyButton();
    }

    @Tags({
            @Tag("web"),
            @Tag("all")
    })
    @Owner("Artem Lepkin")
    @Test
    @DisplayName("Проверка выполнения поискового запроса")
    @AllureId("34665")
    void checkSearchResultsTest() {
        open("");
        generalPage
                .setSearchRequest(searchRequestQa);
        modalLoginPage
                .closeModalPage();
        searchResultsPage
                .checkCommonTitleContainText(searchRequestQa);
    }
}
