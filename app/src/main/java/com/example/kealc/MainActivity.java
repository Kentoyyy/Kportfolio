package com.example.kealc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView = findViewById(R.id.bottom_navagition);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new AboutFragment()).commit();
        navigationView.setSelectedItemId(R.id.about);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.interest:
                        fragment = new InterestFragment();
                        break;

                    case R.id.skills:
                        fragment = new SkillsFragment();
                        break;

                    case R.id.about:
                        fragment = new AboutFragment();
                        break;

                    case R.id.education:
                        fragment = new EducationFragment();
                        break;

                    case R.id.project:
                        fragment = new ProjectFragment();
                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();

                return  true;
            }
        });
    }
}