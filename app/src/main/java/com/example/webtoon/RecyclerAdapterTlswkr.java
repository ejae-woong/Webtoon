package com.example.webtoon;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class RecyclerAdapterTlswkr extends RecyclerView.Adapter<RecyclerAdapterTlswkr.ViewHolder> {
    List<DataWebtoon> list;
    static Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageFilterView image;
        AppCompatTextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_tlswkr);
            title = itemView.findViewById(R.id.tv_tlswkrtitle);
        }

        public void bindSliderImage(String src) {
            Glide.with(context)
                    .load(src)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(image);
        }
    }

    public RecyclerAdapterTlswkr(List<DataWebtoon> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterTlswkr.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_tlswkr, viewGroup, false);

        return new RecyclerAdapterTlswkr.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterTlswkr.ViewHolder holder, int position) {
        int p = position;
        String src = list.get(p).getSrc();
        holder.bindSliderImage(src);
        holder.title.setText(list.get(p).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Item Clicked", (p+1)+"번째 아이템 선택");
                Intent intent = new Intent(context, ActivityDescription.class);
                intent.putExtra("title", list.get(p).getTitle());
                intent.putExtra("src", list.get(p).getSrc());
                intent.putExtra("artist", list.get(p).getArtist());
                intent.putExtra("genre", list.get(p).getGenre());
                intent.putExtra("age", list.get(p).getAge());
                intent.putExtra("tag", list.get(p).getTag());

                Log.e("PutExtra", list.get(p).getTitle());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}
