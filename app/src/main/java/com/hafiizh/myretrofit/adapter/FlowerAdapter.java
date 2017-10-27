package com.hafiizh.myretrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hafiizh.myretrofit.R;
import com.hafiizh.myretrofit.model.Flowers;
import com.hafiizh.myretrofit.utilities.Constants;
import com.hafiizh.myretrofit.view.OnSourceItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAFIIZH on 10/27/2017.
 * Author Havea Crenata
 * Email havea.crenata@gmail.com
 * Github https://github.com/crenata
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerHolder> {
    private List<Flowers> flowersList;
    private OnSourceItemClickListener<Flowers> onSourceItemClickListener;

    public FlowerAdapter() {
        flowersList = new ArrayList<>();
    }

    public void addFlowers(Flowers flowers) {
        flowersList.add(flowers);
    }

    public void clear() {
        flowersList.clear();
    }

    public void setOnSourceItemClickListener(OnSourceItemClickListener<Flowers> onSourceItemClickListener) {
        this.onSourceItemClickListener = onSourceItemClickListener;
    }

    @Override
    public FlowerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FlowerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false), onSourceItemClickListener);
    }

    @Override
    public void onBindViewHolder(FlowerHolder holder, int position) {
        Picasso.with(holder.itemView.getContext())
                .load(Constants.PHOTOS + flowersList.get(position).photo)
                .into(holder.image);
        holder.name.setText(flowersList.get(position).name);
        holder.price.setText(flowersList.get(position).price);
        holder.category.setText(flowersList.get(position).category);
        holder.instruction.setText(flowersList.get(position).instructions);
    }

    @Override
    public int getItemCount() {
        return flowersList.size();
    }

    class FlowerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView image;
        public TextView name, price, category, instruction;
        OnSourceItemClickListener<Flowers> onSourceItemClickListener;

        public FlowerHolder(View itemView, OnSourceItemClickListener<Flowers> onSourceItemClickListener) {
            super(itemView);
            this.onSourceItemClickListener = onSourceItemClickListener;
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            price = (TextView) itemView.findViewById(R.id.price);
            category = (TextView) itemView.findViewById(R.id.category);
            instruction = (TextView) itemView.findViewById(R.id.instruction);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onSourceItemClickListener.onSourceItemClick(v, getAdapterPosition(), flowersList);
        }
    }
}
