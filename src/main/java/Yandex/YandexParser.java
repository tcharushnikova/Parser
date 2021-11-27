package Yandex;

import Parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class YandexParser implements Parser<ArrayList<String>> {
    @Override
    public ArrayList<String> Parse(Document document) {
        return GetImgLinks(document);
    }

    public static ArrayList<String> GetImgLinks(Document document) {
        ArrayList<String> imgLinks = new ArrayList<>();
        Elements images = document.getElementsByClass("serp-item");
        for (Element image : images){
            String data = image.attr("data-bem"),
                    origin = data.substring(data.indexOf("origin")),
                    url = origin.substring(origin.indexOf("url") + 6),
                    pathImage = url.substring(0, url.indexOf("\""));
            imgLinks.add(pathImage);
        }
        return imgLinks;
    }
}