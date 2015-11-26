package com.pm10.flexiblespaceoverlapping;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SampleViewHolder extends RecyclerView.ViewHolder{
    Context context;

    @Bind(R.id.name)
    TextView name;

    @Bind(R.id.age)
    TextView age;

    public SampleViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    public void setData(User user){
        name.setText(user.name);
        age.setText(user.age);
    }
}
