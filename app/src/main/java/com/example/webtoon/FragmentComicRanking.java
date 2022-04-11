package com.example.webtoon;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentComicRanking extends Fragment {
    Context context;
    private RecyclerView recyclerView_live, recyclerView_new;
    GridLayoutManager gridLayoutManager;
    ArrayList<DataWebtoon> webtoons = MainActivity.webtoons;


    public FragmentComicRanking() {
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
        return inflater.inflate(R.layout.fragment_comic_ranking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = view.getContext();

        recyclerView_live = view.findViewById(R.id.recyclerview_live);
        setGridRecyclerView(recyclerView_live, webtoons, GridLayoutManager.HORIZONTAL);

        recyclerView_new = view.findViewById(R.id.recyclerview_newranking);
        setGridRecyclerView(recyclerView_new, webtoons, GridLayoutManager.HORIZONTAL);
    }

    private void setGridRecyclerView(RecyclerView recyclerView, ArrayList<DataWebtoon> list, int orientation) {
        recyclerView.setAdapter(new RecyclerAdapterRanking(list, context));
        recyclerView.setHasFixedSize(false);
        gridLayoutManager = new GridLayoutManager(context, 3, orientation, false);
        recyclerView.setLayoutManager(gridLayoutManager);

    }
}