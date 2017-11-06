package com.wallmart.routedemo.presenter;

import android.content.Context;

import com.wallmart.routedemo.network.NetworkCall;

import java.util.ArrayList;

import app.com.mvp.mvp.RoutesCallback;
import app.com.mvp.mvp.pojo.RoutesData;
import app.com.mvp.mvp.pojo.RoutesResponse;
import app.com.mvp.mvp.presenter.IStopsPresenter;
import app.com.mvp.mvp.view.IStopsView;
import app.com.mvp.mvp.view.View;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Amit on 06-11-2017.
 */

public class MainPresenter implements IStopsPresenter, RoutesCallback{
    IStopsView stopsListView;
    CompositeSubscription subscription;
    Context context;

    @Override
    public void attachView(View view, Context context) {
        stopsListView = (IStopsView) view;
        this.context = context;
        subscription = new CompositeSubscription();
    }

    @Override
    public void onStop() {
        subscription.unsubscribe();
    }

    @Override
    public void callServiceForStops(Context context) {
        NetworkCall networkCall = NetworkCall.getRetrofit(context);
        subscription.add(networkCall.callServiceForRotes(this, true));
    }

    @Override
    public void onSuccess(RoutesResponse<ArrayList<RoutesData>> RoutesData) {
        stopsListView.onStopsFound(RoutesData.getRoutes());
    }

    @Override
    public void onError(String message) {
        stopsListView.onError(message);
    }
}
