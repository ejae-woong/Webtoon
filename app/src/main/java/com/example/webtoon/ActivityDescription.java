package com.example.webtoon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.webtoon.databinding.ActivityDescriptionBinding;

public class ActivityDescription extends AppCompatActivity {
private String src, title, artist, genre;
private String[] tag = new String[5];
private String[] nTag = new String[]{"", "", "", "", ""};
private int age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDescriptionBinding binding = ActivityDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        src = intent.getExtras().getString("src");
        title = intent.getExtras().getString("title");
        artist = intent.getExtras().getString("artist");
        genre = intent.getExtras().getString("genre");
        tag = intent.getExtras().getStringArray("tag");
        age = intent.getExtras().getInt("age");

        Glide.with(this)
                .load(src)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.imgDescription);
        binding.tvDescriptionTitle.setText(title);
        binding.tvDescriptionArtist.setText(artist);
        if (age == 0)
        {
            binding.tvDescriptionGenre.setText(genre + " |  전체 이용가");
        }
        else
        {
            binding.tvDescriptionGenre.setText(genre + " | " + age + "세 이용가");
        }

        for (int i = 0; i < tag.length; i++) {
            nTag[i] = "#" + tag[i].toString();
        }

        if (!nTag[0].isEmpty())
            binding.tvTag1.setText(nTag[0].toString());
        if (!nTag[1].isEmpty())
            binding.tvTag2.setText(nTag[1].toString());
        if (!nTag[2].isEmpty())
            binding.tvTag3.setText(nTag[2].toString());
        if (!nTag[3].isEmpty())
            binding.tvTag4.setText(nTag[3].toString());
        if (!nTag[4].isEmpty())
            binding.tvTag5.setText(nTag[4].toString());

        binding.btnDescriptionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityDescription.super.onBackPressed();
            }
        });
    }
}