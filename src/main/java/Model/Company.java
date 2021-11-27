package Model;

import java.util.ArrayList;

public class Company {
    String name;
    ArrayList<NanegativeFeedback> feedbacks;

    public void setName(String name) {
        this.name = name;
    }

    public void setFeedbacks(ArrayList<NanegativeFeedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(name);
        if (feedbacks.isEmpty())
            out.append(". Отзывов о данной компании пока нет.\n\n");
        else {
            out.append(". Отзывы о данной компании:\n");
            for (NanegativeFeedback feedback : feedbacks)
                out.append(feedback.toString()).append("\n");
        }
        return out + "\n";
    }
}