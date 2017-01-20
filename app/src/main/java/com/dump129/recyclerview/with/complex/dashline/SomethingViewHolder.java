package com.dump129.recyclerview.with.complex.dashline;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Dump129 on 1/20/2017.
 */

class SomethingViewHolder extends RecyclerView.ViewHolder{
    public TextView tvTitle;
    public TextView tvContent;
    public TextView tvReleaseDate;
    public DotLineView dlvHeader;
    public DotLineView dlvFooter;

    public SomethingViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvContent = (TextView) itemView.findViewById(R.id.tvContent);
        tvReleaseDate = (TextView) itemView.findViewById(R.id.tvReleaseDate);
        dlvHeader = (DotLineView) itemView.findViewById(R.id.dlvHeader);
        dlvFooter = (DotLineView) itemView.findViewById(R.id.dlvFooter);
    }
}
