package Leroymerlin;

import Parser.ParserSettings;

public class LeroymerlinSettings extends ParserSettings {
    public LeroymerlinSettings(String category, int start, int end) {
        startPoint = start;
        endPoint = end;
        BASE_URL = "https://leroymerlin.ru/catalogue/" + category;
        PREFIX = "?page={CurrentId}";
    }
}