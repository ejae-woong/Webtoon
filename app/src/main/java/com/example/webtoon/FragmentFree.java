package com.example.webtoon;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class FragmentFree extends Fragment {
    Context context;
    ArrayList<DataHomeAD> ADlist = new ArrayList<>();
    RecyclerView recyclerView_AD, recyclerView_toon;
    LinearLayoutManager layoutManager;
    public FragmentFree() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_free, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = view.getContext();

        ImageFilterView freebanner = view.findViewById(R.id.img_freebanner);
        Glide.with(context)
                .load("https://ccdn.lezhin.com/files/assets/img/dailyfree-banner2-ko-d.jpg.webp")
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(freebanner);

        addADList();
        recyclerView_AD = view.findViewById(R.id.recyclerview_free_ad);
        recyclerView_AD.setAdapter(new RecyclerAdapterFreeAD(ADlist, context));
        recyclerView_AD.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_AD.setLayoutManager(layoutManager);

    }

    public void addADList() {
        ADlist.add(new DataHomeAD("https://ccdn.lezhin.com/v2/banners/dailyfree/images/23753.webp?updated=1649141334249", ""));
        ADlist.add(new DataHomeAD("https://ccdn.lezhin.com/v2/banners/dailyfree/images/23759.webp?updated=1649141410049", ""));
        ADlist.add(new DataHomeAD("https://ccdn.lezhin.com/v2/banners/dailyfree/images/23765.webp?updated=1649141495697", ""));
    }
}