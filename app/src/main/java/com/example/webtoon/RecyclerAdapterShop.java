package com.example.webtoon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class RecyclerAdapterShop extends RecyclerView.Adapter<RecyclerAdapterShop.ViewHolder> {
    List<DataHomeShop> list;
    static Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageFilterView image;
        AppCompatTextView title, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_shop);
            title = itemView.findViewById(R.id.tv_shopTitle);
            price = itemView.findViewById(R.id.tv_shopPrice);
        }

        public void bindSliderImage(String src) {
            Glide.with(context)
                    .load(src)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(image);
        }
    }

    public RecyclerAdapterShop(List<DataHomeShop> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterShop.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_shop, viewGroup, false);

        return new RecyclerAdapterShop.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShop.ViewHolder holder, int position) {
        int p = position;
        String src = list.get(position).getSrc();
        holder.bindSliderImage(src);
        holder.title.setText(list.get(position).getTitle());
        holder.price.setText(list.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(p).getLink()));
                context.startActivity(intent);
            }
        });
    }

   @Override
    public int getItemCount() {
       return list == null ? 0 : list.size();
    }
}
