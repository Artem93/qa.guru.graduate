package qa.guru.graduate.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {

    private static final String accessToken = "USERIAANMBJLM907QMO1BSKVHM6KBR7LOGHJEQH56IF841VV0D1RFLC3CAGF7I9L";
    public static final String bearer = "Bearer " + accessToken;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.hh.ru/";
    }
}
