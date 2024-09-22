package qa.guru.graduate.pages.webPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final SelenideElement loginInput = $("input[data-qa=\"login-input-username\"]");
    private static final SelenideElement passwordInput = $("input[data-qa=\"login-input-password\"]");
    private static final SelenideElement loginWithPasswordButton = $("[data-qa=\"expand-login-by-password\"]");

    @Step
    public LoginPage clickLoginWithPasswordButton() {
        loginWithPasswordButton
                .click();
        return this;
    }

    @Step
    public LoginPage setLogin(String login) {
        loginInput
                .setValue(login);
        return this;
    }


    @Step
    public LoginPage setPassword(String password) {
        passwordInput
                .setValue(password);
        return this;
    }
}
