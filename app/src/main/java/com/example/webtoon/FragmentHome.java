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
    ArrayList<DataHomeRanking> homeRankList = new ArrayList<>();
    ArrayList<DataHomeRanking> RankList = new ArrayList<>();
    ArrayList<DataToonList> tlswkrList = new ArrayList<>();
    ArrayList<DataToonList> newToonList = new ArrayList<>();
    ArrayList<DataToonList> eventToonList = new ArrayList<>();
    ArrayList<DataToonList> hotToonList = new ArrayList<>();
    ArrayList<DataToonList> eroToonList = new ArrayList<>();
    ArrayList<DataHomeAD> homeADList = new ArrayList<>();
    ArrayList<DataHomeShop> shopList = new ArrayList<>();

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

        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/6720067265167360/media/upperBannerMobile.webp?updated=1648475042000&width=688", ""));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/5199771920039936/media/upperBannerMobile.webp?updated=1648105183000&width=688", ""));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/5416951907418112/media/upperBannerMobile.webp?updated=1648039548000&width=688", ""));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/5741820717105152/media/upperBannerMobile.webp?updated=1646915578000&width=688", ""));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/4940164601544704/media/upperBannerMobile.webp?updated=1646915619000&width=688", ""));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/5086375147012096/media/upperBannerMobile.webp?updated=1646996970000&width=688", ""));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/6220843452792832/media/upperBannerMobile.webp?updated=1646902046000&width=688", ""));
        homebannerList.add(new DataHomebanner("https://ccdn.lezhin.com/v2/inventory_items/5396007090454528/media/upperBannerMobile.webp?updated=1645530656000&width=688", ""));


//        for (int i = 0; i < 5; i++) {
//            homebannerList.add(new DataHomebanner());
//        }

        homebannerView = view.findViewById(R.id.viewpager_home_banner);
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

        SpringDotsIndicator indicator = view.findViewById(R.id.dots_indicator);
        indicator.setViewPager2(homebannerView);

        rankTab = view.findViewById(R.id.tab_homeranking);
        rankTab.addTab(rankTab.newTab().setText("실시간"));
        rankTab.addTab(rankTab.newTab().setText("신작"));
        rankTab.addTab(rankTab.newTab().setText("이벤트"));

        homeRankList.add(new DataHomeRanking("https://ccdn.lezhin.com/v2/comics/260/images/square.webp?updated=1626417228107&width=84", "레바툰", "레바", "일상", 296, 1000000, false));
        homeRankList.add(new DataHomeRanking("https://ccdn.lezhin.com/v2/comics/5876991988465664/images/square.webp?updated=1626145716628&width=84", "도와줘요, 이비씨!", "단투, 쌈바", "판타지", 5, 10500, true));
        homeRankList.add(new DataHomeRanking("https://ccdn.lezhin.com/v2/comics/6528753551540224/images/square.webp?updated=1626417578438&width=84", "환관 제조 일기", "김달", "개그", 8, 10040, false));
        homeRankList.add(new DataHomeRanking("https://ccdn.lezhin.com/v2/comics/4572351621824512/images/square.webp?updated=1648691937722&width=84", "버림받은 황비", "인아, 정유나", "로맨스", 11, 13000, true));
        homeRankList.add(new DataHomeRanking("https://ccdn.lezhin.com/v2/comics/6019972462870528/images/square.webp?updated=1647423574591&width=84", "태후의 남자들", "지진, 대추", "로맨스", 4, 12000, false));
        homeRankList.add(new DataHomeRanking("https://ccdn.lezhin.com/v2/comics/5716170964795392/images/square.webp?updated=1646282764964&width=84", "글라스 러버스", "펭귄쥬스", "학원", 4, 10050, true));
        homeRankList.add(new DataHomeRanking("https://ccdn.lezhin.com/v2/comics/6744486435946496/images/square.webp?updated=1648534750316&width=84", "밥보다 키스", "서울소", "로맨스", 7, 10700, false));

        Collections.sort(homeRankList);
        for (int i = 0; i < 3; i++) {
            RankList.add(homeRankList.get(i));
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
                        Collections.sort(homeRankList);
                        for (int i = 0; i < 3; i++) {
                            RankList.add(homeRankList.get(i));
                        }
                        break;
                    case "신작":
                        RankList.clear();
                        Collections.sort(homeRankList);
                        int i = 0, j = 0;
                        do {
                            DataHomeRanking L = homeRankList.get(i);
                            if (L.getFreedate() <= 10) {
                                RankList.add(L);
                                j++;
                            }
                            i++;
                        } while (j < 3);
                        break;
                    case "이벤트":
                        RankList.clear();
                        Collections.sort(homeRankList);
                        i = 0;
                        j = 0;
                        do {
                            DataHomeRanking L = homeRankList.get(i);
                            if (L.getEvent() == true) {
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



        tlswkrList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5716170964795392/images/tall.webp?updated=1646282764964&width=277", "글라스 러버스", ""));
        tlswkrList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4907714540535808/images/tall.webp?updated=1646101410301&width=277", "안나 이야기", ""));
        tlswkrList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4593648627417088/images/tall.webp?updated=1645171344114&width=277", "무명의 등불", ""));
        tlswkrList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/6738868293664768/images/tall.webp?updated=1644372846453&width=277", "미명의 추적자", ""));
        tlswkrList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/6262255336620032/images/tall.webp?updated=1641430463933&width=277", "골든 아워", ""));
        tlswkrList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/6456906317627392/images/tall.webp?updated=1643185289542&width=277", "집사랑", ""));

        recyclerView_tlswkr = view.findViewById(R.id.recyclerview_tlswkr);
        recyclerView_tlswkr.setAdapter(new RecyclerAdapterTlswkr(tlswkrList, context));
        recyclerView_tlswkr.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_tlswkr.setLayoutManager(layoutManager);

        newToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/6087307181752320/images/tall.webp?updated=1648691869466&width=177", "가극 소녀!! 시즌 제로", ""));
        newToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4572351621824512/images/tall.webp?updated=1648691937722&width=177", "버림 받은 황비", ""));
        newToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/6164732154544128/images/tall.webp?updated=1648691757960&width=177", "까만남자 하얀여자", ""));
        newToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5306262949789696/images/tall.webp?updated=1648691720640&width=177", "신데렐라 클로젯", ""));
        newToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4615173653725184/images/tall.webp?updated=1648691739629&width=177", "[비애] 종달새가 울면 잡아줘", ""));
        newToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5833758283726848/images/tall.webp?updated=1648538449134&width=177", "로맨틱 그래피티", ""));

        recyclerView_newcomic = view.findViewById(R.id.recyclerview_newcomic);
        recyclerView_newcomic.setAdapter(new RecyclerAdapterToonList(newToonList, context));
        recyclerView_newcomic.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_newcomic.setLayoutManager(layoutManager);

        eventToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5089653580955648/images/tall.webp?updated=1641454910693&width=177", "에로만화부!", ""));
        eventToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4535643469840384/images/tall.webp?updated=1623295311178&width=177", "사랑할 수 없는 그녀", ""));
        eventToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4535078004785152/images/tall.webp?updated=1619579409378&width=177", "개기면 죽는다", ""));
        eventToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5564344987877376/images/tall.webp?updated=1647219661399&width=177", "아기가 생겼어요", ""));
        eventToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4978865662394368/images/tall.webp?updated=1646701271933&width=177", "미스 타임", ""));
        eventToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/6480790705209344/images/tall.webp?updated=1620005466771&width=177", "속도위반 대표님", ""));

        recyclerView_event = view.findViewById(R.id.recyclerview_event);
        recyclerView_event.setAdapter(new RecyclerAdapterToonList(eventToonList, context));
        recyclerView_event.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_event.setLayoutManager(layoutManager);

        hotToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5298601528459264/images/tall.webp?updated=1617357521900&width=177", "야화첩 [개정판]", ""));
        hotToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/6607767147184128/images/tall.webp?updated=1621998463311&width=177", "지젤씨의 피", ""));
        hotToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5665181768679424/images/tall.webp?updated=1621229868182&width=177", "인시크릿 [개정판]", ""));
        hotToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4920901046435840/images/tall.webp?updated=1617357405624&width=177", "서는 여자 [개정판]", ""));
        hotToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5080328750563328/images/tall.webp?updated=1621230043167&width=177", "체험! XX의 현장 [개정판]", ""));
        hotToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/6531477824667648/images/tall.webp?updated=1617357490370&width=177", "S플라워 [개정판]", ""));

        recyclerView_hot = view.findViewById(R.id.recyclerview_hot);
        recyclerView_hot.setAdapter(new RecyclerAdapterToonList(hotToonList, context));
        recyclerView_hot.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_hot.setLayoutManager(layoutManager);

        homeADList.add(new DataHomeAD());

        recyclerView_ad = view.findViewById(R.id.recyclerview_ad);
        recyclerView_ad.setAdapter(new RecyclerAdapterAD(homeADList));
        recyclerView_ad.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_ad.setLayoutManager(layoutManager);

        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/123.webp?updated=1647416653806&width=177", "도깨비도 수풀이 있어야 모인다 아크릴 스탠드 4종", "12,500원", "https://j-meeshop.com/product/%EB%8F%84%EA%B9%A8%EB%B9%84%EB%8F%84-%EC%88%98%ED%92%80%EC%9D%B4-%EC%9E%88%EC%96%B4%EC%95%BC-%EB%AA%A8%EC%9D%B8%EB%8B%A4-%EC%95%84%ED%81%AC%EB%A6%B4-%EC%8A%A4%ED%83%A0%EB%93%9C-4%EC%A2%85/194/category/23/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/125.webp?updated=1647416711244&width=177", "Love or Hate 페이크 매거진[+MATE]", "8,900원", "https://j-meeshop.com/product/love-or-hate-%ED%8E%98%EC%9D%B4%ED%81%AC-%EB%A7%A4%EA%B1%B0%EC%A7%84mate/228/category/23/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/105.webp?updated=1647416609444&width=177", "[도서] 불멸의 날들 1권~5권", "9,900원", "https://j-meeshop.com/product/%EB%8F%84%EC%84%9C-%EB%B6%88%EB%A9%B8%EC%9D%98-%EB%82%A0%EB%93%A4-1%EA%B6%8C4%EA%B6%8C/151/category/59/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/110.webp?updated=1647416590796&width=177", "[도서] 신기록 1~5권", "12,600원", "https://j-meeshop.com/product/%EB%8F%84%EC%84%9C-%EC%8B%A0%EA%B8%B0%EB%A1%9D-15%EA%B6%8C/67/category/59/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/103.webp?updated=1647416552020&width=177", "야화첩 그립톡", "8,000원", "https://j-meeshop.com/product/%EC%95%BC%ED%99%94%EC%B2%A9-%EA%B7%B8%EB%A6%BD%ED%86%A1/163/category/23/display/1/"));
        shopList.add(new DataHomeShop("https://ccdn.lezhin.com/v2/banners/section_tall/images/99.webp?updated=1647416509180&width=177", "BJ 알렉스 마스킹 테이프\n", "11,500원", "https://j-meeshop.com/product/bj-%EC%95%8C%EB%A0%89%EC%8A%A4-%EB%A7%88%EC%8A%A4%ED%82%B9-%ED%85%8C%EC%9D%B4%ED%94%84/180/category/23/display/1/"));


        recyclerView_shop = view.findViewById(R.id.recyclerview_shop);
        recyclerView_shop.setAdapter(new RecyclerAdapterShop(shopList, context));
        recyclerView_shop.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_shop.setLayoutManager(layoutManager);

        eroToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5145070025637888/images/tall.webp?updated=1613454282280&width=177", "던전 속 사정", ""));
        eroToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/6269503840780288/images/tall.webp?updated=1617357062741&width=177", "섹서가이즈", ""));
        eroToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5023315744063488/images/tall.webp?updated=1611298014877&width=177", "이 회사에 좋아하는 사람이 있습니다", ""));
        eroToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4920901046435840/images/tall.webp?updated=1617357405624&width=177", "서는 여자 [개정판]", ""));
        eroToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/5292498940919808/images/tall.webp?updated=1620956348589&width=177", "일상생활 가능하세요?", ""));
        eroToonList.add(new DataToonList("https://ccdn.lezhin.com/v2/comics/4636603184644096/images/tall.webp?updated=1639040731647&width=177", "비 마이 게스트", ""));


        recyclerView_ero = view.findViewById(R.id.recyclerview_ero);
        recyclerView_ero.setAdapter(new RecyclerAdapterToonList(eroToonList, context));
        recyclerView_ero.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_ero.setLayoutManager(layoutManager);
    }
}