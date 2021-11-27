package Model;

public class LeroymerlinFeedback {
    String name, raiting, plusesAndMinuses, text;

    public void setName(String name) {
        this.name = name;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }

    public void setPlusesAndMinuses(String plusesAndMinuses) {
        this.plusesAndMinuses = plusesAndMinuses;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        String out = name + ", оценка " + raiting + "\n" + "Отзыв: " + text + "\n";
        if (!plusesAndMinuses.isEmpty())
            out += plusesAndMinuses + "\n";
        return out;
    }
}