package com.example.webtoon;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentComicDuswo extends Fragment {
    Context context;
    private RecyclerView recyclerView_duswo;
    private LinearLayoutManager layoutManager;
    ArrayList<DataWebtoon> webtoons = MainActivity.webtoons;

    public FragmentComicDuswo() {
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
        return inflater.inflate(R.layout.fragment_comic_duswo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = view.getContext();

        view.findViewById(R.id.scrollable).setHorizontalScrollBarEnabled(false);

        recyclerView_duswo = view.findViewById(R.id.recyclerview_duswo);
        recyclerView_duswo.setAdapter(new RecyclerAdapterDuswo(webtoons, context));
        recyclerView_duswo.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_duswo.setLayoutManager(layoutManager);
    }
}