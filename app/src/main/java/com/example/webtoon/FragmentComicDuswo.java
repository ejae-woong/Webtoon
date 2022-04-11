package com.example.webtoon;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class FragmentComicDuswo extends Fragment {
    Context context;
    Calendar calendar;
    private RecyclerView recyclerView_duswo;
    private LinearLayoutManager layoutManager;
    ArrayList<DataWebtoon> webtoons = MainActivity.webtoons;
    ArrayList<DataWebtoon> webtoon = new ArrayList<>();

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



        RadioGroup tab = view.findViewById(R.id.tab_duswo);
        tab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String day = null;
                switch (i) {
                    case R.id.tab1:
                        day = "월";
                    case R.id.tab2:
                        day = "화";
                    case R.id.tab3:
                        day = "수";
                    case R.id.tab4:
                        day = "목";
                    case R.id.tab5:
                        day = "금";
                    case R.id.tab6:
                        day = "토";
                    case R.id.tab7:
                        day = "일";
                    case R.id.tab8:
                        day = "열흘";
                }
                Log.e("SELECTED DAY", tab.getCheckedRadioButtonId()+"");
                webtoon.clear();
                for (int j = 0; j < webtoons.size(); j++) {
                    if (webtoons.get(j).getDuswo().equals(day))
                        Log.e("DAY", webtoons.get(j).getDuswo());
                        webtoon.add(webtoons.get(j));
                }
                recyclerView_duswo = view.findViewById(R.id.recyclerview_duswo);
                recyclerView_duswo.setAdapter(new RecyclerAdapterDuswo(webtoon, context));
                recyclerView_duswo.setHasFixedSize(false);
                layoutManager = new LinearLayoutManager(context);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView_duswo.setLayoutManager(layoutManager);

            }
        });



    }
}