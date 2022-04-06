package com.example.webtoon;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
        int p = position;
        DataWebtoon item = list.get(p).getWebtoon();
        String src = list.get(position).getSrc();
        holder.bindSliderImage(src);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Item Clicked", (p+1)+"번째 아이템 선택");
                Intent intent = new Intent(context, ActivityDescription.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("src", item.getSrc());
                intent.putExtra("artist", item.getArtist());
                intent.putExtra("genre", item.getGenre());
                intent.putExtra("age", item.getAge());
                intent.putExtra("tag", item.getTag());

                Log.e("PutExtra", item.getTitle());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


}
