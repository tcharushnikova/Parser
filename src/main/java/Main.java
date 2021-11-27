import Leroymerlin.LeroymerlinNewData;
import Leroymerlin.LeroymerlinParser;
import Leroymerlin.LeroymerlinSettings;
import Nanegative.NanegativeNewData;
import Nanegative.NanegativeParser;
import Nanegative.NanegativeSettings;
import Parser.Completed;
import Parser.ParserWorker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("""
                Выберите действия:
                1) сбор отзывов с сайта nanegative.ru;
                2) сбор информации о товаре с сайта leroymerlin.ru;
                3) скачивание картинки по запросу в google;
                4) выход из программы""");
        int userChoice;
        Scanner inp = new Scanner(System.in);
        do {
            userChoice = inp.nextInt();
            while (userChoice < 1 || userChoice > 4) {
                System.out.print("Введите число от 1 до 4: ");
                userChoice = inp.nextInt();
            }
            switch (userChoice) {
                case 1 -> {
                    ParserWorker<ArrayList<String>> parser = new ParserWorker<ArrayList<String>>();
                    parser.setParser(new NanegativeParser());
                    parser.setParserSettings(new NanegativeSettings());
                    parser.onCompletedList.add(new Completed());
                    parser.onNewDataList.add(new NanegativeNewData());
                    parser.Start();
                    Thread.sleep(10000);
                    parser.Abort();
                }
                case 2 -> {
                    System.out.print("Введите наименование категории: ");
                    inp.nextLine();
                    String category = inp.nextLine();
                    System.out.print("Введите начальный номер страницы для парсинга: ");
                    int start = inp.nextInt();
                    System.out.print("Введите конечный номер страницы для парсинга: ");
                    int end = inp.nextInt();
                    ParserWorker<ArrayList<String>> parser = new ParserWorker<ArrayList<String>>();
                    parser.setParser(new LeroymerlinParser());
                    parser.setParserSettings(new LeroymerlinSettings(category, start, end));
                    parser.onCompletedList.add(new Completed());
                    parser.onNewDataList.add(new LeroymerlinNewData());
                    parser.Start();
                    Thread.sleep(10000);
                    parser.Abort();
                }
                case 3 -> {
                }
            }
        } while (userChoice != 4);
    }
}