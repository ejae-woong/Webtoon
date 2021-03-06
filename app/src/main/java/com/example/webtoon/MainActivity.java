package com.example.webtoon;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.webtoon.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private long lastTimeBackPressed;
    public static ArrayList<DataWebtoon> webtoons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addWebtoon();

        bottomNavigationView = binding.bottomNavi;
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new FragmentHome()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bottom1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentHome()).commit();
//                        stack.push(R.id.home);
                        break;
                    case R.id.bottom2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentComic()).commit();
//                        stack.push(R.id.game);
                        break;
                    case R.id.bottom3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentFree()).commit();
//                        stack.push(R.id.newhot);
                        break;
                    case R.id.bottom4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentPresent()).commit();
//                        stack.push(R.id.download);
                        break;
                    case R.id.bottom5:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentDescription()).commit();
//                        stack.push(R.id.download);
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
            if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
                finish();
                return;
            }else{
                Toast.makeText(this, "'??????' ????????? ??? ??? ??? ????????? ???????????????.", Toast.LENGTH_SHORT).show();
            }
            lastTimeBackPressed = System.currentTimeMillis();

    }

    private void addWebtoon() {
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/260/images/tall.jpg?updated=1626417228107&width=132", "?????????", "??????", "??????", "", 0, 296, 1000000, false, new String[] {"??????", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4736813649494016/images/tall.webp?updated=1575531204163&width=177", "????????? ?????????", "??????", "?????????", "", 15, 5, 60500, true, new String[] {"?????????", "??????", "??????", "????????????","?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6551967191793664/images/tall.webp?updated=1626417543711&width=177", "????????????", "?????????", "??????", "", 15, 8, 40400, false, new String[] {"?????????", "??????", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4736046550745088/images/tall.webp?updated=1626418392700&width=177", "????????? ????????? ?????? ??????", "??????", "?????????", "??????", 15, 11, 43000, true, new String[] {"?????????", "??????", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4706772223328256/images/tall.webp?updated=1641455289398&width=177", "???????????? [?????????]", "?????????", "BL", "", 0, 4, 32000, false, new String[] {"?????????", "BL", "????????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5337560462458880/images/tall.webp?updated=1645091246680&width=277", "?????? ????????? ?????? ??????", "?????????", "??????", "", 15, 7, 70700, false, new String[] {"??????", "????????????", "????????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4907714540535808/images/tall.webp?updated=1646101410301&width=277", "?????? ?????????", "?????????", "?????????", "??????", 0, 41, 10090, false, new String[] {"?????????", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4593648627417088/images/tall.webp?updated=1645171344114&width=277", "????????? ??????", "??????", "?????????", "??????", 15, 23, 10085, false, new String[] {"????????????", "?????????", "?????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6738868293664768/images/tall.webp?updated=1644372846453&width=277", "????????? ?????????", "EMO, ??????", "?????????", "??????", 15, 2, 20084, true, new String[] {"?????????", "??????", "?????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6262255336620032/images/tall.webp?updated=1641430463933&width=277", "?????? ??????", "?????????, ?????????, ?????????", "?????????", "??????", 0, 9, 47392, true, new String[] {"??????", "?????????", "????????????", "??????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6456906317627392/images/tall.webp?updated=1643185289542&width=277", "?????????", "?????????", "BL", "??????", 0, 7, 9382, true, new String[] {"????????????", "?????????", "??????", "BL"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6087307181752320/images/tall.webp?updated=1648691869466&width=177", "?????? ??????!! ?????? ??????", "????????? ?????????", "??????", "??????", 15, 1, 10392, true, new String[] {"?????????", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6164732154544128/images/tall.webp?updated=1648691757960&width=177", "???????????? ????????????", "?????????", "?????????", "??????", 0, 4, 21859, true, new String[] {"?????????", "?????????", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5306262949789696/images/tall.webp?updated=1648691720640&width=177", "???????????? ?????????", "????????? ??????", "?????????", "??????", 0, 3, 10093, false, new String[] {"?????????", "????????????", "?????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4615173653725184/images/tall.webp?updated=1648691739629&width=177", "[??????] ???????????? ?????? ?????????", "?????? ??????", "BL", "??????", 0, 1, 10394, true, new String[] {"?????????", "????????????", "?????????", "????????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5833758283726848/images/tall.webp?updated=1648538449134&width=177", "????????? ????????????", "??????", "BL", "??????", 0, 4, 9999, false, new String[] {"?????????", "?????????", "??????", "??????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5716170964795392/images/tall.webp?updated=1646282764964&width=277", "????????? ?????????", "????????????", "??????", "", 0, 4, 9999, false, new String[] {"??????", "?????????", "SF", "??????"}, "???"));

        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5089653580955648/images/tall.webp?updated=1641454910693&width=177", "???????????????!", "Canaria, ??????", "??????", "??????", 15, 4, 83942, false, new String[] {"?????????", "?????????", "?????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4535643469840384/images/tall.webp?updated=1623295311178&width=177", "????????? ??? ?????? ??????", "Chungfeng Studio, kkworld, zero", "?????????", "??????", 15, 6, 38294, true, new String[] {"?????????", "?????????", "?????????", "?????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4535078004785152/images/tall.webp?updated=1619579409378&width=177", "????????? ?????????", "??????, ?????????", "?????????", "??????", 15, 2, 4341, false, new String[] {"?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5564344987877376/images/tall.webp?updated=1647219661399&width=177", "????????? ????????????", "??????, ??????", "?????????", "??????", 15, 3, 52516, true, new String[] {"?????????", "????????????", "??????", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4978865662394368/images/tall.webp?updated=1646701271933&width=177", "?????? ??????", "??????, ?????????", "?????????", "??????", 2, 15, 4837, true, new String[] {"?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6480790705209344/images/tall.webp?updated=1620005466771&width=177", "???????????? ???????????? ????????????", "kkworld, flower", "?????????", "??????", 15, 16, 29304, true, new String[] {"?????????", "????????????", "??????", "??????"}, "???"));

        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5298601528459264/images/tall.webp?updated=1617357521900&width=177", "????????? [?????????]", "??????", "BL", "???", 15, 2, 38472, false, new String[] {"BL"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6607767147184128/images/tall.webp?updated=1621998463311&width=177", "???????????? ???", "?????????", "?????????", "???", 15, 1, 12382, true, new String[] {"??????", "????????????", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5665181768679424/images/tall.webp?updated=1621229868182&width=177", "???????????? [?????????]", "?????????", "BL", "???", 15, 2, 32314, false, new String[] {"BL", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4920901046435840/images/tall.webp?updated=1617357405624&width=177", "?????? ?????? [?????????]", "?????????", "?????????", "???", 15, 2, 25132, true, new String[] {"?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5080328750563328/images/tall.webp?updated=1621230043167&width=177", "??????! XX??? ?????? [?????????]", "?????????, ????????????", "BL", "???", 15, 2, 48273, true, new String[] {"?????????", "?????????", "BL"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6531477824667648/images/tall.webp?updated=1617357490370&width=177", "S????????? [?????????]", "??????", "?????????", "???", 15, 2, 32512, true, new String[] {"????????????", "????????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5145070025637888/images/tall.webp?updated=1613454282280&width=177", "?????? ??? ??????", "??????", "?????????", "??????", 15, 2, 86739, false, new String[] {"??????", "??????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6269503840780288/images/tall.webp?updated=1617357062741&width=177", "???????????????", "?????????", "?????????", "??????", 15, 4, 12313, true, new String[] {"?????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5023315744063488/images/tall.webp?updated=1611298014877&width=177", "??? ????????? ???????????? ????????? ????????????", "???????????? ????????????", "?????????", "??????", 15, 2, 23131, true, new String[] {"?????????", "????????????", "?????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4920901046435840/images/tall.webp?updated=1617357405624&width=177", "?????? ?????? [?????????]", "?????????", "?????????", "??????", 15, 2, 25132, false, new String[] {"?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5292498940919808/images/tall.webp?updated=1620956348589&width=177", "???????????? ????????????????", "Alice Crazy", "?????????", "??????", 15, 2, 63527, false, new String[] {"?????????", "????????????", "?????????"}, "???"));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4636603184644096/images/tall.webp?updated=1639040731647&width=177", "??? ?????? ?????????", "??????, ?????????", "?????????", "??????", 15, 1, 42532, true, new String[] {"?????????", "??????", "???", "?????????"}, "???"));
    }
}