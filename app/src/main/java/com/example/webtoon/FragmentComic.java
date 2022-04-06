package com.example.webtoon;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class FragmentComic extends Fragment {
    Context context;

    public FragmentComic() {
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
        return inflater.inflate(R.layout.fragment_comic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = view.getContext();

        Toolbar toolbar = view.findViewById(R.id.toolbar_home);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        TabLayout comicTab = view.findViewById(R.id.tab_comic);
        comicTab.addTab(comicTab.newTab().setText("연재"));
        comicTab.addTab(comicTab.newTab().setText("랭킹"));

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.comic_frame, new FragmentComicDuswo()).commit();
        comicTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                switch(position) {
                    case 0:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.comic_frame, new FragmentComicDuswo()).commit();
                    case 1:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.comic_frame, new FragmentComicRanking()).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}