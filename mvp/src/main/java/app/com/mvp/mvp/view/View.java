package app.com.mvp.mvp.view;

/**
 * Created by Amit.
 */
public interface View {
    void onError(String message);
    void initializePresenter();
}
