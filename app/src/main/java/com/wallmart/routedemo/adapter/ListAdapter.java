package com.wallmart.routedemo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wallmart.routedemo.R;
import com.wallmart.routedemo.activity.DetailActivity;

import java.util.ArrayList;

import app.com.mvp.mvp.pojo.RoutesData;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Amit
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private Activity mContext;
    private ArrayList<RoutesData> routes = new ArrayList<>();

    public ListAdapter(Activity mContext, ArrayList<RoutesData> listing){
        this.mContext = mContext;
        routes = listing;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_bus_list,parent,false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position) {

        if (routes.get(position).getImage() != null)
            Picasso.with(mContext).load(routes.get(position).getImage()).fit().into(holder.imgRouteBus);

        holder.tvroute.setText(routes.get(position).getName());

        holder.rootLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("routeInfo", routes.get(position));
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return routes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.image)
        ImageView imgRouteBus;
        @BindView(R.id.rootLL)
        LinearLayout rootLL;
        @BindView(R.id.name_tv)
        TextView tvroute;


        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
