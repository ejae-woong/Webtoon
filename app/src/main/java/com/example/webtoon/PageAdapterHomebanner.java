package com.example.webtoon;

import android.content.Context;
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

public class PageAdapterHomebanner extends RecyclerView.Adapter<PageAdapterHomebanner.ViewHolder>{
List<DataHomebanner> list;
Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageFilterView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_homebanner);
        }

        public void bindSliderImage(String src){
            Glide.with(context)
                    .load(src)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(image);
        }
    }

    public PageAdapterHomebanner(List<DataHomebanner> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ConstraintLayout view = (ConstraintLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_homebanner, viewGroup, false);

        return new PageAdapterHomebanner.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String src = list.get(position).getSrc();
        holder.bindSliderImage(src);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


}
