package qa.guru.graduate.tests.api;

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
import qa.guru.graduate.pages.apiSteps.EducationalSteps;

import static qa.guru.graduate.helpers.TestData.*;

@Tags({
        @Tag("api"),
        @Tag("all")
})
@Owner("Артём Лепкин")
@Epic("Api автотесты")
@Feature("Ручки образовательных учреждений")
@DisplayName("Тесты на ручки образовательных учреждений")
public class EducationalInstitutionsTests extends ApiTestBase {

    @Test
    @DisplayName("Проверка запроса инфо об учебном заведении с валидным Id")
    @AllureId("34656")
    void positiveEducationalRequestWithIdTest() {
        var testModel = getTestEducationalModelRu();
        var educationalSteps = new EducationalSteps();
        var response = educationalSteps
                .getEducationalItemById(testModel.getItems().get(0).getId());
        educationalSteps
                .comparisonFields(testModel, response, "Проверка ответа на валидность");
    }

    @ValueSource(strings = {";", "q", "я", "string"})
    @ParameterizedTest(name = "Невалидный id '' {0} ''")
    @DisplayName("Проверка запроса инфо об учебном заведении с невалидным Id")
    @AllureId("34653")
    void checkNegativeEducationalRequestTest(String badId) {
        var testModel = getBadArgumentTestEducationalModel();
        var educationalSteps = new EducationalSteps();
        var response = educationalSteps
                .requestEducationalWithBadId(badId);
        educationalSteps
                .comparisonFields(testModel.getErrors(), response.getErrors(), "Проверка корректности вернувшейся ошибки");
    }

    @Test
    @DisplayName("Проверка запроса инфо об учебном заведении с валидным параметрами Id и locale")
    @AllureId("34654")
    void positiveEducationalRequestWithIdAndEnLocaleTest() {
        var testModel = getTestEducationalModelEn();
        var educationalSteps = new EducationalSteps();

        var response = educationalSteps
                .getEducationalItemByIdAndLocale(testModel.getItems().get(0).getId(), "EN");
        educationalSteps
                .comparisonFields(testModel, response, "Проверка ответа на валидность");
    }
}
