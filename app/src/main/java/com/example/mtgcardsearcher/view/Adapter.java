package com.example.mtgcardsearcher.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mtgcardsearcher.R;
import com.example.mtgcardsearcher.model.MtgSet;
import com.squareup.picasso.Picasso;


public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private MtgSet set;
    private Context context;
    private OnItemClickListener listener;

    public Adapter(MtgSet set, Context context, OnItemClickListener listener) {
        this.set = set;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_main_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        final String url = this.set.getCards().get(position).getImageUrl();

        Picasso.get().load(url).into(viewHolder.imageView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(set.getCards().get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.set.getCards().size();
    }
}