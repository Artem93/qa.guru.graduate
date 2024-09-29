package qa.guru.graduate.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static io.qameta.allure.Allure.step;

public class ApiTestBase {

    private static final String accessToken = "USERR5KDIRAV6H4UDV1LCT56LMEA06V6II7OHK224KIOUNSRR64Q5RB5NHPMM5J2";
    public static final String bearer = "Bearer " + accessToken;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.hh.ru/";
    }
}
