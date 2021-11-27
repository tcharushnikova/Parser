package Leroymerlin;

import Model.LeroymerlinFeedback;
import Model.Product;
import Parser.Parser;
import Parser.HtmlLoader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class LeroymerlinParser implements Parser<ArrayList<Product>> {
    @Override
    public ArrayList<Product> Parse(Document document) throws IOException {
        return GetProductInfo(document);
    }

    public static ArrayList<Product> GetProductInfo(Document document) throws IOException {
        ArrayList<Product> productsList = new ArrayList<>();
        Elements products = document.getElementsByClass("phytpj4_plp largeCard");
        for (Element productEl : products) {
            Product product = new Product();
            product.setName(productEl.getElementsByClass("t9jup0e_plp p1h8lbu4_plp").text());
            String productLink =
                    productEl.getElementsByClass("bex6mjh_plp b1f5t594_plp iypgduq_plp nf842wf_plp").attr("href");
            product.setFeedbacks(GetFeedbacks(productLink));
            productsList.add(product);
        }
        return productsList;
    }

    static ArrayList<LeroymerlinFeedback> GetFeedbacks(String productPath) throws IOException {
        ArrayList<LeroymerlinFeedback> allFeedbacks = new ArrayList<>();
        HtmlLoader loader = new HtmlLoader(LeroymerlinSettings.BASE_URL.substring(0, 22) + productPath + "/#nav" +
                "-reviews");
        Document document = loader.GetSourceByPage();
        Elements feedbacks = document.getElementsByAttributeValue("itemprop", "review");
        for (Element feedbackEl : feedbacks) {
            LeroymerlinFeedback feedback = new LeroymerlinFeedback();
            feedback.setName(feedbackEl.getElementsByAttributeValue("itemprop", "name").text());
            feedback.setRaiting(feedbackEl.getElementsByAttributeValue("itemprop", "ratingValue").attr("content").substring(0, 1));
            Elements plusesAndMinuses = feedbackEl.getElementsByClass("term-group");
            if (plusesAndMinuses.size() == 2)
                feedback.setPlusesAndMinuses(plusesAndMinuses.get(0).text() + "\n" + plusesAndMinuses.get(1).text());
            else
                feedback.setPlusesAndMinuses(plusesAndMinuses.text());
            feedback.setText(feedbackEl.getElementsByAttributeValue("itemprop", "description").text());
            allFeedbacks.add(feedback);
        }
        return allFeedbacks;
    }
}