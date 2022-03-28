package com.allstars.trek_app21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;


import com.allstars.trek_app21.databinding.ActivityMainBinding;

import io.ak1.BubbleTabBar;
import io.ak1.OnBubbleClickListener;

public class MainActivity extends AppCompatActivity {
    
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction homeTrans = getSupportFragmentManager().beginTransaction();
        homeTrans.replace(R.id.content,new HomeFragment());
        homeTrans.commit();

        binding.bottomNav.addBubbleListener(i -> {
            Toast.makeText(this, "hello"+ String.valueOf(i), Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (i){
                    case 2131230928:
                        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
                        transaction.replace(R.id.content,new HomeFragment());
                        break;
                    case 2131231081:
                        Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
                        transaction.replace(R.id.content,new SearchFragment());
                        break;
                    case 2131230791:
                        Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                        transaction.replace(R.id.content,new AddFragment());
                        break;
                    case 2131231033:
                        Toast.makeText(this, "notif", Toast.LENGTH_SHORT).show();
                        transaction.replace(R.id.content,new NotifFragment());
                        break;
                    case 2131231057:
                        Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
                        transaction.replace(R.id.content,new ProfileFragment());
                        break;
                }
                transaction.commit();
        });


    }
}