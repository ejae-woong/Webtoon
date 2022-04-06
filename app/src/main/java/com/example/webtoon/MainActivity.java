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
                Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            }
            lastTimeBackPressed = System.currentTimeMillis();

    }

    private void addWebtoon() {
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/260/images/tall.jpg?updated=1626417228107&width=132", "레바툰", "레바", "일상", "", 0, 296, 1000000, false, new String[] {"병맛", "코믹", "유쾌함"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4736813649494016/images/tall.webp?updated=1575531204163&width=177", "흑역사 처리반", "단투", "판타지", "", 15, 5, 60500, true, new String[] {"성장물", "코믹", "학원", "저승사자","판타지"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6551967191793664/images/tall.webp?updated=1626417543711&width=177", "바나나툰", "와나나", "일상", "", 15, 8, 40400, false, new String[] {"경험담", "병맛", "코믹", "유쾌함"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4736046550745088/images/tall.webp?updated=1626418392700&width=177", "이름을 말하지 않는 악마", "성범", "판타지", "신규", 15, 11, 43000, true, new String[] {"귀여움", "천사", "악마", "판타지"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4706772223328256/images/tall.webp?updated=1641455289398&width=177", "안피니티 [개정판]", "이지피", "BL", "", 0, 4, 32000, false, new String[] {"떡대공", "BL", "삼각관계"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5337560462458880/images/tall.webp?updated=1645091246680&width=277", "날개 부러진 새의 노래", "서리태", "액션", "", 15, 7, 70700, false, new String[] {"비밀", "영혼바뀜", "고등학교"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4907714540535808/images/tall.webp?updated=1646101410301&width=277", "안나 이야기", "김지효", "로맨스", "신작", 0, 41, 10090, false, new String[] {"드라마", "모험", "로맨스"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4593648627417088/images/tall.webp?updated=1645171344114&width=277", "무명의 등불", "이재", "드라마", "신작", 15, 23, 10085, false, new String[] {"눈물퐁퐁", "시대극", "드라마", "성장물"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6738868293664768/images/tall.webp?updated=1644372846453&width=277", "미명의 추적자", "EMO, 매사", "로맨스", "신작", 15, 2, 20084, true, new String[] {"로맨스", "로판", "능력녀", "역하렘"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6262255336620032/images/tall.webp?updated=1641430463933&width=277", "골든 아워", "박수빈, 박형규, 이국종", "드라마", "신작", 0, 9, 47392, true, new String[] {"병원", "힐링물", "소설원작", "의사"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6456906317627392/images/tall.webp?updated=1643185289542&width=277", "집사랑", "김첨지", "BL", "신작", 0, 7, 9382, true, new String[] {"츤데레수", "메이드", "귀족", "BL"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6087307181752320/images/tall.webp?updated=1648691869466&width=177", "가극 소녀!! 시즌 제로", "사이키 쿠미코", "학원", "신규", 15, 1, 10392, true, new String[] {"드라마", "학원", "성장물"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6164732154544128/images/tall.webp?updated=1648691757960&width=177", "까만남자 하얀여자", "도레앙", "드라마", "신규", 0, 4, 21859, true, new String[] {"드라마", "로맨스", "이웃", "성장물"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5306262949789696/images/tall.webp?updated=1648691720640&width=177", "신데렐라 클로젯", "야나이 와카", "로맨스", "신규", 0, 3, 10093, false, new String[] {"로맨스", "여장남자", "성장물", "달달물"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4615173653725184/images/tall.webp?updated=1648691739629&width=177", "[비애] 종달새가 울면 잡아줘", "엔도 에누", "BL", "신규", 0, 1, 10394, true, new String[] {"상처수", "대형견공", "재회물", "소꿉친구", "첫사랑"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5833758283726848/images/tall.webp?updated=1648538449134&width=177", "로맨틱 그래피티", "밤식", "BL", "신규", 0, 4, 9999, false, new String[] {"귀염수", "선후배", "연상", "코믹"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5716170964795392/images/tall.webp?updated=1646282764964&width=277", "글라스 러버스", "펭귄쥬스", "학원", "", 0, 4, 9999, false, new String[] {"연애", "성장물", "SF", "학원"}));

        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5089653580955648/images/tall.webp?updated=1641454910693&width=177", "에로만화부!", "Canaria, 공란", "학원", "야릇", 15, 4, 83942, false, new String[] {"선후배", "귀여움", "캠퍼스", "유쾌함"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4535643469840384/images/tall.webp?updated=1623295311178&width=177", "사랑할 수 없는 그녀", "Chungfeng Studio, kkworld, zero", "로맨스", "야릇", 15, 6, 38294, true, new String[] {"로맨스", "첫사랑", "달달물", "츤데레", "짝사랑"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4535078004785152/images/tall.webp?updated=1619579409378&width=177", "개기면 죽는다", "마야, 왕기대", "로맨스", "야릇", 15, 2, 4341, false, new String[] {"로맨스"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5564344987877376/images/tall.webp?updated=1647219661399&width=177", "아기가 생겼어요", "강기, 이정", "로맨스", "야릇", 15, 3, 52516, true, new String[] {"로맨스", "소설원작", "연애", "결혼", "원나잇"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4978865662394368/images/tall.webp?updated=1646701271933&width=177", "미스 타임", "경섭, 봉구씨", "로맨스", "야릇", 2, 15, 4837, true, new String[] {"로맨스"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6480790705209344/images/tall.webp?updated=1620005466771&width=177", "속도위반 대표님과 계약아내", "kkworld, flower", "로맨스", "야릇", 15, 16, 29304, true, new String[] {"로맨스", "계약관계", "결혼", "재벌"}));

        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5298601528459264/images/tall.webp?updated=1617357521900&width=177", "야화첩 [개정판]", "변덕", "BL", "핫", 15, 2, 38472, false, new String[] {"BL"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6607767147184128/images/tall.webp?updated=1621998463311&width=177", "지젤씨의 피", "이연지", "판타지", "핫", 15, 1, 12382, true, new String[] {"귀족", "뱀파이어", "다정", "판타지"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5665181768679424/images/tall.webp?updated=1621229868182&width=177", "인시크릿 [개정판]", "이파도", "BL", "핫", 15, 2, 32314, false, new String[] {"BL", "애증", "연예인"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4920901046435840/images/tall.webp?updated=1617357405624&width=177", "서는 여자 [개정판]", "전호윤", "로맨스", "핫", 15, 2, 25132, true, new String[] {"로맨스"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5080328750563328/images/tall.webp?updated=1621230043167&width=177", "체험! XX의 현장 [개정판]", "강언니, 미스피엠", "BL", "핫", 15, 2, 48273, true, new String[] {"미소년", "연예인", "BL"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6531477824667648/images/tall.webp?updated=1617357490370&width=177", "S플라워 [개정판]", "진미", "로맨스", "핫", 15, 2, 32512, true, new String[] {"다각관계", "걸크러시", "로맨스"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5145070025637888/images/tall.webp?updated=1613454282280&width=177", "던전 속 사정", "레바", "판타지", "에로", 15, 2, 86739, false, new String[] {"병맛", "모험", "판타지"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/6269503840780288/images/tall.webp?updated=1617357062741&width=177", "섹서가이즈", "몰라요", "로맨스", "에로", 15, 4, 12313, true, new String[] {"드라마", "로맨스"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5023315744063488/images/tall.webp?updated=1611298014877&width=177", "이 회사에 좋아하는 사람이 있습니다", "에노모토 아카마루", "로맨스", "에로", 15, 2, 23131, true, new String[] {"로맨스", "사내연애", "귀여움", "오피스"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4920901046435840/images/tall.webp?updated=1617357405624&width=177", "서는 여자 [개정판]", "전호윤", "로맨스", "에로", 15, 2, 25132, false, new String[] {"로맨스"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/5292498940919808/images/tall.webp?updated=1620956348589&width=177", "일상생활 가능하세요?", "Alice Crazy", "드라마", "에로", 15, 2, 63527, false, new String[] {"드라마", "사내연애", "오피스"}));
        webtoons.add(new DataWebtoon("https://ccdn.lezhin.com/v2/comics/4636603184644096/images/tall.webp?updated=1639040731647&width=177", "비 마이 게스트", "영모, 티오비", "로맨스", "에로", 15, 1, 42532, true, new String[] {"원나잇", "연애", "썸", "드라마"}));
    }
}