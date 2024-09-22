package qa.guru.graduate.tests.web;

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
import static qa.guru.graduate.helpers.Constants.salaryValue;
import static qa.guru.graduate.helpers.Constants.searchRequest;

public class ExtendedSearchPageTests extends WebTestBase {
    private final ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Tags({
            @Tag("web"),
            @Tag("all")
    })
    @Test
    @DisplayName("Проверка результатов расширенного поиска")
    void checkMainHeaderBlock() {
        open("/search/vacancy/advanced");
        extendedSearchPage
                .setKeyWord(searchRequest)
                .clickFirstSuggestKeyWord()
                .setSearchByCheckbox(NAME_VACANCY)
                .removeAllRegions()
                .clickSubmit();
        searchResultsPage
                .checkAllVacancyTitlesContainText(searchRequest);
    }

    @Tags({
            @Tag("web"),
            @Tag("all")
    })
    @ParameterizedTest(name = "Проверка образования {0}")
    @EnumSource(EducationEnum.class)
    @DisplayName("Проверка применения настроек образования расширенного поиска")
    void checkApplyEducationSettingsExtendedSearch(EducationEnum education) {
        open("/search/vacancy/advanced");
        extendedSearchPage
                .setKeyWord(searchRequest)
                .setEducationCheckbox(education)
                .removeAllRegions()
                .clickSubmit();
        searchResultsPage
                .checkFirstVacancyTitleContainText(searchRequest)
                .checkCheckedEducationCheckbox(education);
    }

    @Tags({
            @Tag("web"),
            @Tag("all")
    })
    @Test
    @DisplayName("Проверка применения настроек зараплаты расширенного поиска")
    void checkApplySalarySettingsExtendedSearch() {
        open("/search/vacancy/advanced");
        extendedSearchPage
                .setKeyWord(searchRequest)
                .setSalary(salaryValue)
                .removeAllRegions()
                .clickSubmit();
        searchResultsPage
                .checkValueSelectedSalary(salaryValue);
    }
}
