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
import org.junit.jupiter.params.provider.EnumSource;
import qa.guru.graduate.enums.EducationEnum;
import qa.guru.graduate.pages.webPages.ExtendedSearchPage;
import qa.guru.graduate.pages.webPages.SearchResultsPage;

import static com.codeborne.selenide.Selenide.open;
import static qa.guru.graduate.enums.SearchByEnum.NAME_VACANCY;
import static qa.guru.graduate.helpers.Constants.*;

@Tags({
        @Tag("web"),
        @Tag("all")
})
@Owner("Артём Лепкин")
@Epic("Веб тесты")
@Feature("Страница расширенного поиска")
@DisplayName("Тесты на расширенный поиск")
public class ExtendedSearchTests extends WebTestBase {

    private final ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Проверка результатов расширенного поиска")
    @AllureId("34658")
    void checkMainHeaderBlockTest() {
        open("/search/vacancy/advanced");
        extendedSearchPage
                .specializationIsLoad()
                .setKeyWord(searchRequestQa)
                .clickFirstSuggestKeyWord()
                .setSearchByCheckbox(NAME_VACANCY)
                .removeAllRegions()
                .clickSubmit();
        searchResultsPage
                .checkAllVacancyTitlesContainText(vacancyTagsQA);
    }

    @ParameterizedTest(name = "Проверка образования {0}")
    @EnumSource(EducationEnum.class)
    @DisplayName("Проверка применения настроек образования расширенного поиска")
    @AllureId("34687")
    void checkApplyEducationSettingsExtendedSearchTest(EducationEnum education) {
        open("/search/vacancy/advanced");
        extendedSearchPage
                .specializationIsLoad()
                .setKeyWord(searchRequestQa)
                .setEducationCheckbox(education)
                .removeAllRegions()
                .clickSubmit();
        searchResultsPage
                .checkFirstVacancyTitleContainText(searchRequestQa)
                .checkCheckedEducationCheckbox(education);
    }

    @Test
    @DisplayName("Проверка применения настроек зарплаты расширенного поиска")
    @AllureId("34660")
    void checkApplySalarySettingsExtendedSearchTest() {
        open("/search/vacancy/advanced");
        extendedSearchPage
                .specializationIsLoad()
                .setKeyWord(searchRequestQa)
                .setSalary(salaryValue)
                .removeAllRegions()
                .clickSubmit();
        searchResultsPage
                .checkValueSelectedSalary(salaryValue);
    }
}
