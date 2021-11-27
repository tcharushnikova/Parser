package Model;

public class NanegativeFeedback {
    String name, raiting, pluses, minuses, text;

    public void setName(String name) {
        this.name = name;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }

    public void setPluses(String pluses) {
        this.pluses = pluses;
    }

    public void setMinuses(String minuses) {
        this.minuses = minuses;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return name + ", оценка " + raiting + "\nПлюсы: " + pluses + "\nМинусы: " + minuses + "\nОтзыв: " + text + "\n";
    }
}