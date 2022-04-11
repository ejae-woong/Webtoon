package com.example.webtoon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class RecyclerAdapterFreeAD extends RecyclerView.Adapter<RecyclerAdapterFreeAD.ViewHolder> {
    List<DataHomeAD> list;
    static Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageFilterView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_free_ad);
        }

        public void bindSliderImage(String src) {
            Glide.with(context)
                    .load(src)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(image);
        }
    }

    public RecyclerAdapterFreeAD(List<DataHomeAD> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterFreeAD.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        FrameLayout view = (FrameLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_free_ad, viewGroup, false);

        return new RecyclerAdapterFreeAD.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int p = position;
        DataHomeAD item = list.get(p);
        String src = item.getSrc();
        holder.bindSliderImage(src);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}
