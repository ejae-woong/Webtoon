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

public class RecyclerAdapterRanking extends RecyclerView.Adapter<RecyclerAdapterRanking.ViewHolder>{
    List<DataWebtoon> list;
    static Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
    ImageFilterView image;
    AppCompatTextView title, artist, genre, freedate, rank;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ranking_banner);
            title = itemView.findViewById(R.id.tv_rank_title);
            artist = itemView.findViewById(R.id.tv_rank_artist);
            genre = itemView.findViewById(R.id.tv_rank_genre);
            freedate = itemView.findViewById(R.id.tv_rank_freedate);
            rank = itemView.findViewById(R.id.tv_rank);
        }

        public void bindSliderImage(String src) {
            Glide.with(context)
                    .load(src)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(image);
        }
    }

    public RecyclerAdapterRanking(List<DataWebtoon> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterRanking.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ConstraintLayout view = (ConstraintLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_ranking, viewGroup, false);

        return new RecyclerAdapterRanking.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterRanking.ViewHolder holder, int position) {
        int p = position;
        DataWebtoon item = list.get(p);
        String src = list.get(p).getSrc();
        holder.bindSliderImage(src);
        holder.title.setText(item.getTitle());
        holder.artist.setText(item.getArtist());
        holder.genre.setText(item.getGenre());
        holder.freedate.setText(item.getFreedate()+"화 무료");
        holder.rank.setText(position+1+"");

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
