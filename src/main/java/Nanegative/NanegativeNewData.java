package Nanegative;

import Model.Company;
import Parser.OnNewDataHandler;

import java.util.ArrayList;

public class NanegativeNewData implements OnNewDataHandler<ArrayList<Company>> {
    @Override
    public void OnNewData(Object sender, ArrayList<Company> args) {
        for (Company c : args)
            System.out.println(c);
    }
}
