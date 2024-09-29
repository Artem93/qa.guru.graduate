package qa.guru.graduate.enums;

public enum AuthButtonsEnum {
    PHONE("По телефону"),
    MAIL("По электронной почте"),
    VK("ВКонтакте"),
    GOSUSLUGI("Войти через Госуслуги"),
    OK("Одноклассники");

    private final String title;

    AuthButtonsEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
