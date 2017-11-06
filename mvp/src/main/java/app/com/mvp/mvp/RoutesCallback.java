package app.com.mvp.mvp;

import java.util.ArrayList;

import app.com.mvp.mvp.pojo.RoutesData;
import app.com.mvp.mvp.pojo.RoutesResponse;

public interface RoutesCallback{
        void onSuccess(RoutesResponse<ArrayList<RoutesData>> RoutesData);

        void onError(String message);
    }
