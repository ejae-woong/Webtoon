package com.example.webtoon;

import android.content.Context;
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
    List<DataHomeRanking> list;
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

    public RecyclerAdapterRanking(List<DataHomeRanking> list, Context context){
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
        String src = list.get(position).getSrc();
        holder.bindSliderImage(src);
        holder.title.setText(list.get(position).getTitle());
        holder.artist.setText(list.get(position).getArtist());
        holder.genre.setText(list.get(position).getGenre());
        holder.freedate.setText(list.get(position).getFreedate()+"화 무료");
        holder.rank.setText(position+1+"");
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}
