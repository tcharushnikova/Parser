package Yandex;

import Parser.ParserSettings;

public class YandexSettings extends ParserSettings {
    public YandexSettings(String search, int start, int end) {
        startPoint = start;
        endPoint = end;
        BASE_URL = "https://yandex.ru/images/search?text=" + search;
        PREFIX = "&p={CurrentId}";
    }
}