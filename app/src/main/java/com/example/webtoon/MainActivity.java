package com.example.webtoon;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.webtoon.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private long lastTimeBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
}