package com.example.navigation.tabLayoutViewPager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.navigation.R;
import com.example.navigation.adapter.ViewPagerAdapterWithFragmentStateAdapter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabLayoutActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        tabLayout = findViewById(R.id.tabLayoutId);
        viewPager2 = findViewById(R.id.viewPager);

        viewPager2.setAdapter(new ViewPagerAdapterWithFragmentStateAdapter(this));

        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {

                            case 0: {
                                //tab.setText("Home");
                                tab.setIcon(R.drawable.nev_bottom_home);
                                BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                                //badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                                badgeDrawable.setVisible(true);
                                break;
                            }
                            case 1: {
                                //tab.setText("Account");
                                tab.setIcon(R.drawable.nev_bottom_account);
                                BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                                //badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                                badgeDrawable.setNumber(8);
                                badgeDrawable.setVisible(true);
                                break;
                            }
                            case 2: {
                                //tab.setText("Contacts");
                                tab.setIcon(R.drawable.nev_bottom_contacts);
                                BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                                //badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                                badgeDrawable.setNumber(100);
                                badgeDrawable.setMaxCharacterCount(3);
                                badgeDrawable.setVisible(true);
                                break;
                            }
                            case 3: {
                                //tab.setText("Settings");
                                tab.setIcon(R.drawable.nev_bottom_settings);

                                break;
                            }
                            case 4: {
                                //tab.setText("Shopping");
                                tab.setIcon(R.drawable.nev_bottom_shopping);
                                BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                                //badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                                badgeDrawable.setNumber(1000);
                                badgeDrawable.setMaxCharacterCount(4);
                                badgeDrawable.setVisible(true);
                                break;
                            }


                        }
                    }
                }
        );

        mediator.attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable = tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });



    }
}
