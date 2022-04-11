package com.example.webtoon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.tabs.TabLayout;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;
import java.util.Collections;

public class FragmentHome extends Fragment {
    Context context;

    TabLayout rankTab;
    private ViewPager2 homebannerView;
    RecyclerView recyclerView_tlswkr, recyclerView_ranking, recyclerView_newcomic, recyclerView_event, recyclerView_hot, recyclerView_ad, recyclerView_shop, recyclerView_ero;
    LinearLayoutManager layoutManager;
    ArrayList<DataHomebanner> homebannerList = new ArrayList<>();
    ArrayList<DataWebtoon> RankList = new ArrayList<>();
    ArrayList<DataHomeAD> homeADList = new ArrayList<>();
    ArrayList<DataHomeShop> shopList = new ArrayList<>();
    ArrayList<DataWebtoon> webtoons = MainActivity.webtoons;
    ArrayList<DataWebtoon> tlswkrList = new ArrayList<>();
    ArrayList<DataWebtoon> newToonList = new ArrayList<>();
    ArrayList<DataWebtoon> eventToonList = new ArrayList<>();
    ArrayList<DataWebtoon> hotToonList = new ArrayList<>();
    ArrayList<DataWebtoon> eroToonList = new ArrayList<>();

    public FragmentHome() {
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
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = view.getContext();

        Toolbar toolbar = view.findViewById(R.id.toolbar_home);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ImageFilterView img_newartist = view.findViewById(R.id.img_newartist);
        Glide.with(context)
                .load("https://ccdn.lezhin.com/v2/inventory_items/6293983166005248/media/subBanner1.webp?width=1180")
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(img_newartist);
        img_newartist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lezhin.com/ko/page/220125_towriter?lz_campaign=220125_towriter&lz_banner=sub2"));
                context.startActivity(intent);
            }
        });

        addHomeBanner();
        homebannerView = view.findViewById(R.id.viewpager_home_banner);
        setHomeBanner();
        // 홈화면 배너 세팅

        SpringDotsIndicator indicator = view.findViewById(R.id.dots_indicator);
        indicator.setViewPager2(homebannerView);
        // 홈화면 배너 인디케이터 설정

        rankTab = view.findViewById(R.id.tab_homeranking);
        rankTab.addTab(rankTab.newTab().setText("실시간"));
        rankTab.addTab(rankTab.newTab().setText("신작"));
        rankTab.addTab(rankTab.newTab().setText("이벤트"));
        // 랭킹 탭 추가

        for (int i = 0; i < webtoons.size(); i++) {
            DataWebtoon item = webtoons.get(i);
            switch (item.getGroup()){
                case "신작":
                    tlswkrList.add(item);
                case "에로":
                    eroToonList.add(item);
                case "핫":
                    hotToonList.add(item);
                case "신규":
                    newToonList.add(item);

            }
            if(item.isEvent())
                eventToonList.add(item);

        }
        // 그룹별로 웹툰리스트 분류 및 지정

        Collections.sort(webtoons);
        for (int i = 0; i < 3; i++) {
            RankList.add(webtoons.get(i));
        }
        recyclerView_ranking = view.findViewById(R.id.recyclerview_home_ranking);
        recyclerView_ranking.setAdapter(new RecyclerAdapterRanking(RankList, context));
        recyclerView_ranking.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_ranking.setLayoutManager(layoutManager);

        rankTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String sTab = tab.getText().toString();
                Log.e(sTab,"Clicked");

                switch (sTab) {
                    case "실시간":
                        RankList.clear();
                        Collections.sort(webtoons);
                        for (int i = 0; i < 3; i++) {
                            RankList.add(webtoons.get(i));
                        }
                        break;
                    case "신작":
                        RankList.clear();
                        Collections.sort(webtoons);
                        int i = 0, j = 0;
                        do {
                            DataWebtoon L = webtoons.get(i);
                            if (L.getFreedate() <= 10) {
                                RankList.add(L);
                                j++;
                            }
                            i++;
                        } while (j < 3);
                        break;
                    case "이벤트":
                        RankList.clear();
                        Collections.sort(webtoons);
                        i = 0;
                        j = 0;
                        do {
                            DataWebtoon L = webtoons.get(i);
                            if (L.isEvent() == true) {
                                RankList.add(L);
                                j++;
                            }
                            i++;
                        } while (j < 3);
                        break;
                }
                    recyclerView_ranking = view.findViewById(R.id.recyclerview_home_ranking);
                    recyclerView_ranking.setAdapter(new RecyclerAdapterRanking(RankList, context));
                    recyclerView_ranking.setHasFixedSize(false);
                    layoutManager = new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView_ranking.setLayoutManager(layoutManager);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        recyclerView_tlswkr = view.findViewById(R.id.recyclerview_tlswkr);
        recyclerView_tlswkr.setAdapter(new RecyclerAdapterTlswkr(tlswkrList, context));
        recyclerView_tlswkr.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_tlswkr.setLayoutManager(layoutManager);

        recyclerView_newcomic = view.findViewById(R.id.recyclerview_newcomic);
        setRecyclerView(recyclerView_newcomic, newToonList, context);

        recyclerView_event = view.findViewById(R.id.recyclerview_event);
        setRecyclerView(recyclerView_event, eventToonList, context);

        recyclerView_hot = view.findViewById(R.id.recyclerview_hot);
        setRecyclerView(recyclerView_hot, hotToonList, context);

        recyclerView_ero = view.findViewById(R.id.recyclerview_ero);
        setRecyclerView(recyclerView_ero, eroToonList, context);

        homeADList.add(new DataHomeAD("https://ccdn.lezhin.com/v2/inventory_items/5108450848997376/media/upperBannerMobile.webp?updated=1648693445000&width=688", "https://www.lezhin.com/ko/page/calendar_202204_all?lz_campaign=calendar_202204_all&lz_banner=hero"));
        homeADList.add(new DataHomeAD("https://ccdn.lezhin.com/v2/inventory_items/6700018502533120/media/upperBannerMobile.webp?updated=1643248229000&width=688", "https://www.lezhin.com/ko/page/2022_check?lz_campaign=2022_check&lz_banner=hero"));
        homeADList.add(new DataHomeAD("https://ccdn.lezhin.com/v2/inventory_items/4851131294744576/media/upperBannerMobile.webp?updated=1626161524000&width=688", "https://www.lezhin.com/ko/naverpay-point"));
        homeADList.add(new DataHomeAD("https://ccdn.lezhin.com/v2/inventory_items/5108450848997376/media/upperBannerMobile.webp?updated=1648693445000&width=688", "https://www.lezhin.com/ko/page/calendar_202204_all?lz_campaign=calendar_202204_all&lz_banner=hero"));

        recyclerView_ad = view.findViewById(R.id.recyclerview_ad);
        recyclerView_ad.setAdapter(new RecyclerAdapterAD(homeADList, context));
        recyclerView_ad.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_ad.setLayoutManager(layoutManager);

        addShopItem();

        recyclerView_shop = view.findViewById(R.id.recyclerview_shop);
        recyclerView_shop.setAdapter(new RecyclerAdapterShop(shopList, context));
        recyclerView_shop.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_shop.setLayoutManager(layoutManager);

    }


    private void addHomeBanner() {
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/6220843452792832/media/upperBannerMobile.webp?updated=1646902046000&width=688",
                new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4907714540535808/images/tall.webp?updated=1646101410301&width=277", "안나 이야기", "김지효", "로맨스", "신작", 0, 41, 10090, false, new String[] {"드라마", "모험", "로맨스"}, "월")));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/5086375147012096/media/upperBannerMobile.webp?updated=1646996970000&width=688",
                new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4907714540535808/images/tall.webp?updated=1646101410301&width=277", "안나 이야기", "김지효", "로맨스", "신작", 0, 41, 10090, false, new String[] {"드라마", "모험", "로맨스"}, "월")));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/6220843452792832/media/upperBannerMobile.webp?updated=1646902046000&width=688",
                new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4907714540535808/images/tall.webp?updated=1646101410301&width=277", "안나 이야기", "김지효", "로맨스", "신작", 0, 41, 10090, false, new String[] {"드라마", "모험", "로맨스"}, "월")));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/6220843452792832/media/upperBannerMobile.webp?updated=1646902046000&width=688",
                new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4907714540535808/images/tall.webp?updated=1646101410301&width=277", "안나 이야기", "김지효", "로맨스", "신작", 0, 41, 10090, false, new String[] {"드라마", "모험", "로맨스"}, "월")));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/6220843452792832/media/upperBannerMobile.webp?updated=1646902046000&width=688",
                new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4907714540535808/images/tall.webp?updated=1646101410301&width=277", "안나 이야기", "김지효", "로맨스", "신작", 0, 41, 10090, false, new String[] {"드라마", "모험", "로맨스"}, "월")));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/6220843452792832/media/upperBannerMobile.webp?updated=1646902046000&width=688",
                new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4907714540535808/images/tall.webp?updated=1646101410301&width=277", "안나 이야기", "김지효", "로맨스", "신작", 0, 41, 10090, false, new String[] {"드라마", "모험", "로맨스"}, "월")));

    }


    private void setHomeBanner() {
        homebannerView.setAdapter(new PageAdapterHomebanner(homebannerList, context));
        homebannerView.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

            }
        });


    }


    private void addShopItem() {
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/123.webp?updated=1647416653806&width=177", "도깨비도 수풀이 있어야 모인다 아크릴 스탠드 4종", "12,500원", "https://j-meeshop.com/product/%EB%8F%84%EA%B9%A8%EB%B9%84%EB%8F%84-%EC%88%98%ED%92%80%EC%9D%B4-%EC%9E%88%EC%96%B4%EC%95%BC-%EB%AA%A8%EC%9D%B8%EB%8B%A4-%EC%95%84%ED%81%AC%EB%A6%B4-%EC%8A%A4%ED%83%A0%EB%93%9C-4%EC%A2%85/194/category/23/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/125.webp?updated=1647416711244&width=177", "Love or Hate 페이크 매거진[+MATE]", "8,900원", "https://j-meeshop.com/product/love-or-hate-%ED%8E%98%EC%9D%B4%ED%81%AC-%EB%A7%A4%EA%B1%B0%EC%A7%84mate/228/category/23/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/105.webp?updated=1647416609444&width=177", "[도서] 불멸의 날들 1권~5권", "9,900원", "https://j-meeshop.com/product/%EB%8F%84%EC%84%9C-%EB%B6%88%EB%A9%B8%EC%9D%98-%EB%82%A0%EB%93%A4-1%EA%B6%8C4%EA%B6%8C/151/category/59/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/110.webp?updated=1647416590796&width=177", "[도서] 신기록 1~5권", "12,600원", "https://j-meeshop.com/product/%EB%8F%84%EC%84%9C-%EC%8B%A0%EA%B8%B0%EB%A1%9D-15%EA%B6%8C/67/category/59/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/103.webp?updated=1647416552020&width=177", "야화첩 그립톡", "8,000원", "https://j-meeshop.com/product/%EC%95%BC%ED%99%94%EC%B2%A9-%EA%B7%B8%EB%A6%BD%ED%86%A1/163/category/23/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/99.webp?updated=1647416509180&width=177", "BJ 알렉스 마스킹 테이프\n", "11,500원", "https://j-meeshop.com/product/bj-%EC%95%8C%EB%A0%89%EC%8A%A4-%EB%A7%88%EC%8A%A4%ED%82%B9-%ED%85%8C%EC%9D%B4%ED%94%84/180/category/23/display/1/"));
    }

    private void setRecyclerView(RecyclerView recyclerView, ArrayList<DataWebtoon> list, Context context){
        recyclerView.setAdapter(new RecyclerAdapterToonList(list, context));
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
    }

}