package Parser;

public interface OnNewDataHandler<T> {
    void OnNewData(Object sender, T e);
}