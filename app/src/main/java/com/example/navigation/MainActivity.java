package com.example.navigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    BottomNavigationView bottomNavigationView;
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigationId);
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);

        if (savedInstanceState == null){
            fragment = new Profile_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_ContainerId,fragment)
                    .commit();
        }
    }

    BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nev_btm_account :
                    fragment = new Account_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_ContainerId,fragment)
                            .commit();
                    break;
                case R.id.nev_btm_contacts :
                    fragment = new Contacts_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_ContainerId,fragment)
                            .commit();
                    break;
                case R.id.nev_btm_home :
                    fragment = new Profile_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_ContainerId,fragment)
                            .commit();
                    break;
                case R.id.nev_btm_settings :
                    fragment = new Settings_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_ContainerId,fragment)
                            .commit();
                    break;
                case R.id.nev_btm_shopping :
                    fragment = new Shopping_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_ContainerId,fragment)
                            .commit();
                    break;
            }
            return true;
        }
    };

    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId()==R.id.nev_btm_home){
            super.onBackPressed();
        }else {
            bottomNavigationView.setSelectedItemId(R.id.nev_btm_home);
        }
    }
}
