package app.com.mvp.mvp.view;

import java.util.ArrayList;

import app.com.mvp.mvp.pojo.RoutesData;

/**
 * Created by Amit.
 */

public interface IStopsView extends View {
    void onStopsFound(ArrayList<RoutesData> routesInfos);
    void onNoData();
}
