package qa.guru.graduate.pages.mobileScreens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;
import static qa.guru.graduate.helpers.Constants.loginHeaderText;
import static qa.guru.graduate.helpers.Constants.otherMethodsButtonText;

public class LoginScreen {

    private final SelenideElement otherMethodsButton = $(xpath(String.format("//android.widget.TextView[@text=\"%s\"]", otherMethodsButtonText)));
    private final SelenideElement headerTextView = $(xpath(String.format("//android.widget.TextView[@text=\"%s\"]", loginHeaderText)));

    private static SelenideElement getAuthButton(String header) {
        return $(xpath(String.format("//android.widget.TextView[@text=\"%s\"]", header)));
    }

    @Step("Проверка хедера")
    public LoginScreen checkHeader() {
        headerTextView
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости и кликабельности кнопки {button}")
    public LoginScreen checkAuthButton(String button) {
        getAuthButton(button)
                .shouldBe(visible)
                .shouldBe(clickable);
        return this;
    }

    @Step("Кликк по кнопке 'Другие способы'")
    public LoginScreen clickOtherMethodsButton() {
        otherMethodsButton
                .click();
        return this;
    }
}
