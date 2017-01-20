package com.dump129.recyclerview.with.complex.dashline;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Dump129 on 1/20/2017.
 */

public class SomethingAdapter extends RecyclerView.Adapter<SomethingViewHolder> {
    private List<SomethingData> somethingDataList;

    public SomethingAdapter(List<SomethingData> somethingDataList) {
        this.somethingDataList = somethingDataList;
    }

    @Override
    public SomethingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_card, parent, false);
        return new SomethingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SomethingViewHolder holder, int position) {
        SomethingData data = somethingDataList.get(position);
        holder.tvTitle.setText(data.getTitle());
        holder.tvContent.setText(data.getContent());
        holder.tvReleaseDate.setText(data.getReleaseDate());
        holder.dlvHeader.setVisibility(position == 0 ? View.INVISIBLE : View.VISIBLE);
        holder.dlvFooter.setVisibility(position == getItemCount() - 1 ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return somethingDataList.size();
    }
}
