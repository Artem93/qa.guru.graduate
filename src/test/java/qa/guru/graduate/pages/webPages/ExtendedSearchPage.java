package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import qa.guru.graduate.enums.EducationEnum;
import qa.guru.graduate.enums.SearchByEnum;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ExtendedSearchPage {
    private static final SelenideElement keyWordInput = $("[data-qa=\"vacancysearch__keywords-input\"]");
    private static final SelenideElement searchInNameVacancyCheckbox =
            $("[data-qa=\"control-vacancysearch__search_field-item control-vacancysearch__search_field-item_name\"]").parent();
    private static final SelenideElement searchInNameCompanyCheckbox =
            $("[data-qa=\"control-vacancysearch__search_field-item control-vacancysearch__search_field-item_company_name\"]").parent();
    private static final SelenideElement searchInDescriptionVacancyCheckbox =
            $("[data-qa=\"control-vacancysearch__search_field-item control-vacancysearch__search_field-item_description\"]").parent();
    private static final ElementsCollection regionsAcross = $$("[data-qa=\"bloko-tag__cross\"]");
    private static final SelenideElement submitButton = $("[data-qa=\"advanced-search-submit-button\"]");
    private static final ElementsCollection keyWordsSuggestList = $$(".suggest__item");
    private static final SelenideElement salaryInput = $("[data-qa=\"advanced-search-salary\"]");

    private static final SelenideElement educationNotRequired =
            $("[data-qa=\"advanced-search__education-item-label_not_required_or_not_specified\"]");
    private static final SelenideElement educationSpecial =
            $("[data-qa=\"advanced-search__education-item-label_special_secondary\"]");
    private static final SelenideElement educationHigher =
            $("[data-qa=\"advanced-search__education-item-label_higher\"]");

    @Step("Ввод запроса {keyWord} в инпут")
    public ExtendedSearchPage setKeyWord(String keyWord) {
        keyWordInput.setValue(keyWord);
        return this;
    }

    @Step("Выбор первого варианта из списка поисковых предложений")
    public ExtendedSearchPage clickFirstSuggestKeyWord() {
        keyWordsSuggestList.first().click();
        return this;
    }

    @Step("Ввод зарплаты {salary} в инпут")
    public ExtendedSearchPage setSalary(String salary) {
        salaryInput.setValue(salary);
        return this;
    }

    @Step("Выбор типа поиска {searchBy}")
    public ExtendedSearchPage setSearchByCheckbox(SearchByEnum searchBy) {
        switch (searchBy) {
            case NAME_VACANCY -> searchInNameVacancyCheckbox.click();
            case NAME_COMPANY -> searchInNameCompanyCheckbox.click();
            case DESCRIPTION_VACANCY -> searchInDescriptionVacancyCheckbox.click();
        }
        return this;
    }

    @Step("Выбор степени учёности {education}")
    public ExtendedSearchPage setEducationCheckbox(EducationEnum education) {
        educationNotRequired.scrollTo();
        switch (education) {
            case EDUCATION_NOT_REQUIRED -> educationNotRequired.click();
            case EDUCATION_SPECIAL -> educationSpecial.click();
            case EDUCATION_HIGHER -> educationHigher.click();
        }
        return this;
    }

    @Step("Удаление всех регионов поиска")
    public ExtendedSearchPage removeAllRegions() {
        regionsAcross.first().scrollTo();
        for (SelenideElement el : regionsAcross) {
            el.click();
        }
        return this;
    }

    @Step("Клик по кнопке применения поиска")
    public ExtendedSearchPage clickSubmit() {
        submitButton.click();
        return this;
    }
}
