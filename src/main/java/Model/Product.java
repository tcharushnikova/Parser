package Model;

import java.util.ArrayList;

public class Product {
    String name;
    ArrayList<LeroymerlinFeedback> feedbacks;

    public void setName(String name) {
        this.name = name;
    }

    public void setFeedbacks(ArrayList<LeroymerlinFeedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(name);
        if (feedbacks.isEmpty())
            out.append(". Отзывов о товаре пока нет.\n\n");
        else {
            out.append(". Отзывы о товаре:\n");
            for (LeroymerlinFeedback feedback : feedbacks)
                out.append(feedback.toString()).append("\n");
        }
        return out + "\n";
    }
}