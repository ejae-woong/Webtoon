package com.example.webtoon;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class RecyclerAdapterDuswo extends RecyclerView.Adapter<RecyclerAdapterDuswo.ViewHolder>{
    List<DataWebtoon> list;
    static Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageFilterView image;
        AppCompatTextView title, artist, genre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_duswo);
            title = itemView.findViewById(R.id.tv_duswo_title);
            artist = itemView.findViewById(R.id.tv_duswo_artist);
            genre = itemView.findViewById(R.id.tv_duswo_genre);
        }

        public void bindSliderImage(String src) {
            Glide.with(context)
                    .load(src)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(image);
        }
    }

    public RecyclerAdapterDuswo(List<DataWebtoon> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterDuswo.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ConstraintLayout view = (ConstraintLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_duswo, viewGroup, false);

        return new RecyclerAdapterDuswo.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterDuswo.ViewHolder holder, int position) {
        int p = position;
        DataWebtoon item = list.get(p);
        String src = item.getSrc();
        holder.bindSliderImage(src);
        holder.title.setText(item.getTitle());
        holder.artist.setText(item.getArtist());
        holder.genre.setText(item.getGenre());

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
