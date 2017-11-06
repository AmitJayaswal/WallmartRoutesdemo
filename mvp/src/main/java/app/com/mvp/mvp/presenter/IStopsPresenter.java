package app.com.mvp.mvp.presenter;

import android.content.Context;

import app.com.mvp.mvp.view.View;

/**
 * Created by Amit
 */

public interface IStopsPresenter<T extends View> extends Presenter<T> {
    void callServiceForStops(Context context);
}
