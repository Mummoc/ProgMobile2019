package com.example.mtgcardsearcher.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mtgcardsearcher.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;


    public ViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.item_image);
    }
}
