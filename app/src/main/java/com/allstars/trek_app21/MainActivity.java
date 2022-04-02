package com.allstars.trek_app21;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;


import com.allstars.trek_app21.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

import io.ak1.BubbleTabBar;
import io.ak1.OnBubbleClickListener;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Objects.requireNonNull(getSupportActionBar()).hide();
        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction homeTrans = getSupportFragmentManager().beginTransaction();
        homeTrans.replace(R.id.content,new HomeFragment());
        homeTrans.commit();
        // To open Home page as a default page.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new HomeFragment());
        transaction.commit();

        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()){
                    case R.id.home:
                        fragmentTransaction.replace(R.id.content, new HomeFragment());
                        break;

                    case R.id.notif:
                        fragmentTransaction.replace(R.id.content, new NotifFragment());
                        break;

                    case R.id.add:
                        fragmentTransaction.replace(R.id.content, new AddFragment());
                        break;

                    case R.id.search:
                        fragmentTransaction.replace(R.id.content, new SearchFragment());
                        break;

                    case R.id.profile:
                        fragmentTransaction.replace(R.id.content, new ProfileFragment());
                        break;
                }
                fragmentTransaction.commit();
                return true;
            }
        });
//


    }
}