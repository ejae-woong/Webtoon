package com.example.webtoon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class RecyclerAdapterAD extends RecyclerView.Adapter<RecyclerAdapterAD.ViewHolder>{
    List<DataHomeAD> list;
    static Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageFilterView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_AD);
        }

        public void bindSliderImage(String src) {
            Glide.with(context)
                    .load(src)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(image);
        }
    }

    public RecyclerAdapterAD(List<DataHomeAD> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterAD.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ConstraintLayout view = (ConstraintLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_ad, viewGroup, false);

        return new RecyclerAdapterAD.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterAD.ViewHolder holder, int position) {
        int p = position;
        DataHomeAD item = list.get(p);
        String src = item.getSrc();
        holder.bindSliderImage(src);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}
