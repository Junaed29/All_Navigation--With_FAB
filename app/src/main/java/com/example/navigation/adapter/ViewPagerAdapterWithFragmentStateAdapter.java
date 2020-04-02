package com.example.navigation.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.navigation.fragments.Account_Fragment;
import com.example.navigation.fragments.Contacts_Fragment;
import com.example.navigation.fragments.Profile_Fragment_with_fab;
import com.example.navigation.fragments.Settings_Fragment;
import com.example.navigation.fragments.Shopping_Fragment;


public class ViewPagerAdapterWithFragmentStateAdapter extends FragmentStateAdapter {
    public ViewPagerAdapterWithFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0){
            return new Profile_Fragment_with_fab();
        }
        if (position == 1){
            return new Account_Fragment();
        }
        if (position == 2){
            return new Contacts_Fragment();
        }
        if (position == 3){
            return new Settings_Fragment();
        }
        else{
            return new Shopping_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
