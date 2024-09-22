package qa.guru.graduate.pages.apiSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import qa.guru.graduate.models.ListOfResumesModel;
import qa.guru.graduate.models.ResumeModel;

import static io.restassured.RestAssured.given;
import static qa.guru.graduate.specification.APISpecification.*;
import static qa.guru.graduate.tests.api.ApiTestBase.bearer;

public class ResumeSteps {

    @Step("Проверка и возврат списка созданных резюме")
    public ListOfResumesModel getAllResumes() {
        return given(requestSpec)
                .header("Authorization", bearer)
                .header("content-type", "application/json")
                .header("HH-User-Agent", "QaGuruDiploma/1.0 (artegor93@mail.com)")
                .when()
                .get("resumes/mine")
                .then()
                .spec(response200Spec)
                .extract().body().as(ListOfResumesModel.class);
    }

    @Step("Создание резюме")
    public ResumeSteps createResume(ResumeModel expectedResume) {
        given(requestSpec)
                .body(expectedResume)
                .header("Authorization", bearer)
                .header("content-type", "application/json")
                .header("HH-User-Agent", "QaGuruDiploma/1.0 (artegor93@mail.com)")
                .when()
                .post("resumes")
                .then()
                .spec(response201Spec);
        return this;
    }

    @Step("Удаление резюме {id}")
    public ResumeSteps deleteResume(String id) {
        given(requestSpec)
                .header("Authorization", bearer)
                .header("content-type", "application/json")
                .header("HH-User-Agent", "QaGuruDiploma/1.0 (artegor93@mail.com)")
                .when()
                .delete("resumes/" + id)
                .then()
                .spec(response204Spec);
        return this;
    }

    @Step("{step}")
    public ResumeSteps comparisonFields(Object expected, Object actual, String step) {
        Assertions.assertEquals(expected, actual);
        return this;
    }
}
