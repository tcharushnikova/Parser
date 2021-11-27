package Yandex;

import Parser.OnNewDataHandler;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class YandexNewData implements OnNewDataHandler<ArrayList<String>> {
    private static final String IMAGE_DESTINATION_FOLDER = new File("").getAbsolutePath() + "\\images";

    @Override
    public void OnNewData(Object sender, ArrayList<String> args) {
        File newDirectory = new File(IMAGE_DESTINATION_FOLDER);
        newDirectory.mkdir();
        for (String link : args)
            DownloadImage(link);
    }

    private static void DownloadImage(String strImageURL){
        String strImageName = strImageURL.substring(strImageURL.lastIndexOf("/") + 1);
        try {
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();
            byte[] buffer = new byte[4096];
            int n = -1;
            OutputStream os = new FileOutputStream(IMAGE_DESTINATION_FOLDER + "/" + strImageName);
            while ((n = in.read(buffer)) != -1)
                os.write(buffer, 0, n);
            os.close();
        }
        catch (IOException ignored) {}
    }
}
