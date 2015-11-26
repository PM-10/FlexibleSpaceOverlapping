package com.pm10.flexiblespaceoverlapping;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SampleAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<T> items = new ArrayList<>();
    int headerViewCount = 0;

    public SampleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view, parent, false);
        return new SampleViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SampleViewHolder sampleViewHolder = (SampleViewHolder) holder;
        sampleViewHolder.setData((User) items.get(position));
    }


    public void resetAll(ArrayList<T> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void reset(int position, T item) {
        items.set(position, item);
        notifyItemChanged(position + headerViewCount);
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return headerViewCount;

        return items.size() + headerViewCount;
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public T getItem(int position) {
        return items.get(position - headerViewCount);
    }

    public void setHeaderViewCount(int headerViewCount) {
        this.headerViewCount = headerViewCount;
    }
}
