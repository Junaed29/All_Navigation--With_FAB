package com.example.navigation.drawerNavigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.navigation.R;
import com.example.navigation.fragments.Account_Fragment;
import com.example.navigation.fragments.Contacts_Fragment;
import com.example.navigation.fragments.Profile_Fragment_with_fab;
import com.example.navigation.fragments.Settings_Fragment;
import com.example.navigation.fragments.Shopping_Fragment;
import com.google.android.material.navigation.NavigationView;

public class Main2Activity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_layout);

        toolbar = findViewById(R.id.toolBarId);
        drawerLayout = findViewById(R.id.drawerLayoutId);
        navigationView = findViewById(R.id.drawer_navigation_view);
        frameLayout = findViewById(R.id.drawer_navigation_fragment_containerId);

        toolbar.setTitle("Navigation Drawer");
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                Main2Activity.this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(itemSelectedListener);

        if (savedInstanceState == null){
            fragment = new Profile_Fragment_with_fab();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.drawer_navigation_fragment_containerId,fragment)
                    .commit();

            navigationView.setCheckedItem(R.id.nev_drawer_home);
        }
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    NavigationView.OnNavigationItemSelectedListener itemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nev_drawer_account :
                    fragment = new Account_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.drawer_navigation_fragment_containerId,fragment)
                            .commit();
                    break;
                case R.id.nev_drawer_contacts :
                    fragment = new Contacts_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.drawer_navigation_fragment_containerId,fragment)
                            .commit();
                    break;
                case R.id.nev_drawer_home :
                    fragment = new Profile_Fragment_with_fab();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.drawer_navigation_fragment_containerId,fragment)
                            .commit();
                    break;
                case R.id.nev_drawer_settings :
                    fragment = new Settings_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.drawer_navigation_fragment_containerId,fragment)
                            .commit();
                    break;
                case R.id.nev_drawer_shopping :
                    fragment = new Shopping_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.drawer_navigation_fragment_containerId,fragment)
                            .commit();
                    break;

                case R.id.nev_drawer_share :
                    Toast.makeText(Main2Activity.this, "Share", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.nev_drawer_help :
                    Toast.makeText(Main2Activity.this, "Help", Toast.LENGTH_SHORT).show();
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    };
}
