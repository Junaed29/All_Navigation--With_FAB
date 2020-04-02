package com.example.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigation.bottomNavigation.MainActivity;
import com.example.navigation.drawerNavigation.Main2Activity;
import com.example.navigation.tabLayoutViewPager.TabLayoutActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    public void bottomNavigation(View view) {
        startActivity(new Intent(LauncherActivity.this, MainActivity.class));
    }

    public void drawerNavigation(View view) {
        startActivity(new Intent(LauncherActivity.this, Main2Activity.class));
    }

    public void viewPager(View view) {
        startActivity(new Intent(LauncherActivity.this, TabLayoutActivity.class));
    }
}
