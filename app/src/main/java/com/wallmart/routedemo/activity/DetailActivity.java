package com.wallmart.routedemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wallmart.routedemo.R;
import com.wallmart.routedemo.adapter.StopsAdapter;

import app.com.mvp.mvp.pojo.RoutesData;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    RoutesData RoutesData;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.image)
    ImageView routeImage;
    @BindView(R.id.name_tv)
    TextView routeNameTxt;
    @BindView(R.id.acceccible)
    ImageView accessibleImage;
    @BindView(R.id.route_detail_tv)
    TextView routeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        RoutesData = (RoutesData) getIntent().getSerializableExtra("routeInfo");

        if (RoutesData == null)
            finish();

        if (RoutesData.getImage() != null)
            Picasso.with(this).load(RoutesData.getImage()).fit().into(routeImage);
        routeNameTxt.setText(RoutesData.getName());
        if (RoutesData.getAccessible() != null && RoutesData.getAccessible().equalsIgnoreCase("true")){
            accessibleImage.setVisibility(View.VISIBLE);
        }else accessibleImage.setVisibility(View.GONE);

        routeDetails.setText(RoutesData.getDescription());

        LinearLayoutManager ll = new LinearLayoutManager(this);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(ll);

        if (RoutesData.getStops() != null && RoutesData.getStops().size() > 0)
            recyclerView.setAdapter(new StopsAdapter(RoutesData.getStops()));
    }
}
