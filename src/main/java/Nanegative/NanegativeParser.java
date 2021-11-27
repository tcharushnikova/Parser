package Nanegative;

import Model.Company;
import Model.NanegativeFeedback;
import Parser.Parser;
import Parser.HtmlLoader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class NanegativeParser implements Parser<ArrayList<Company>> {
    @Override
    public ArrayList<Company> Parse(Document document) throws IOException {
        return GetCompanyInfo(document);
    }

    public static ArrayList<Company> GetCompanyInfo(Document document) throws IOException {
        ArrayList<Company> companiesList = new ArrayList<>();
        Elements companies = document.getElementsByClass("find-list-box");
        for (Element companyEl : companies) {
            Company company = new Company();
            company.setName(companyEl.getElementsByClass("ss").text().substring(9));
            String companyLink = companyEl.getElementsByClass("ss").attr("href");
            company.setFeedbacks(GetFeedbacks(companyLink));
            companiesList.add(company);
        }
        return companiesList;
    }

    static ArrayList<NanegativeFeedback> GetFeedbacks(String companyPath) throws IOException {
        ArrayList<NanegativeFeedback> allFeedbacks = new ArrayList<>();
        HtmlLoader loader = new HtmlLoader(NanegativeSettings.BASE_URL.substring(0, 21) + companyPath);
        Document document = loader.GetSourceByPage();
        Elements feedbacks = document.getElementsByClass("reviewers-box");
        for (Element feedbackEl : feedbacks) {
            NanegativeFeedback feedback = new NanegativeFeedback();
            feedback.setName(feedbackEl.getElementsByAttributeValue("itemprop", "author").text());
            feedback.setRaiting(feedbackEl.getElementsByAttributeValue("itemprop", "ratingValue").text());
            feedback.setPluses(feedbackEl.getElementsByAttributeValue("itemprop", "pro").text());
            feedback.setMinuses(feedbackEl.getElementsByAttributeValue("itemprop", "contra").text());
            feedback.setText(feedbackEl.getElementsByAttributeValue("itemprop", "reviewBody").text());
            allFeedbacks.add(feedback);
        }
        return allFeedbacks;
    }
}