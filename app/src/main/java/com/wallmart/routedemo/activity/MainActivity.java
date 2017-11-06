package com.wallmart.routedemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.wallmart.routedemo.R;
import com.wallmart.routedemo.adapter.ListAdapter;
import com.wallmart.routedemo.presenter.MainPresenter;

import java.util.ArrayList;

import app.com.mvp.mvp.pojo.RoutesData;
import app.com.mvp.mvp.view.IStopsView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IStopsView{

    MainPresenter presenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializePresenter();

        LinearLayoutManager ll = new LinearLayoutManager(this);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(ll);

        presenter.callServiceForStops(this);
    }

    private void showToast(String message){
        Toast.makeText(this, message , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        showToast(message);
    }

    @Override
    public void initializePresenter() {
        presenter = new MainPresenter();
        presenter.attachView(this, this);
    }

    @Override
    public void onStopsFound(ArrayList<RoutesData> routesInfos) {
        if (routesInfos != null && routesInfos.size() > 0){
            ListAdapter routeListAdapter = new ListAdapter(this, routesInfos);
            recyclerView.setAdapter(routeListAdapter);
        }else onError("No routes found");
    }

    @Override
    public void onNoData() {
        onError("No routes found");
    }
}
