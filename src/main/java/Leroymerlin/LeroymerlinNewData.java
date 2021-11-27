package Leroymerlin;

import Model.Product;
import Parser.OnNewDataHandler;

import java.util.ArrayList;

public class LeroymerlinNewData implements OnNewDataHandler<ArrayList<Product>> {
    @Override
    public void OnNewData(Object sender, ArrayList<Product> args) {
        for (Product p : args)
            System.out.println(p);
    }
}