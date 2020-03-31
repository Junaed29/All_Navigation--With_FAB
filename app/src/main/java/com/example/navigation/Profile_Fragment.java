package com.example.navigation;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_Fragment extends Fragment implements View.OnClickListener {
    private Context context;

    private FloatingActionButton fabOne,fabTwo,fabThree,fabMain;

    private OvershootInterpolator interpolator = new OvershootInterpolator();

    private float translationY = 100f;

    private boolean isMenuOpen = false;

    public Profile_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = container.getContext();
        View view = inflater.inflate(R.layout.fragment_profile_, container, false);

        RelativeLayout relativeLayout = view.findViewById(R.id.profile_fragment_rltiveId);
        relativeLayout.setBackgroundColor(Color.RED);
        initFabMenu(view);

        return view;
    }

    private void initFabMenu(View view){
        fabOne = view.findViewById(R.id.fab_one);
        fabMain = view.findViewById(R.id.fab_main);
        fabTwo = view.findViewById(R.id.fab_two);
        fabThree = view.findViewById(R.id.fab_three);

        fabThree.setVisibility(View.GONE);
        fabTwo.setVisibility(View.GONE);
        fabOne.setVisibility(View.GONE);

        fabOne.setTranslationY(translationY);
        fabTwo.setTranslationY(translationY);
        fabThree.setTranslationY(translationY);

        fabMain.setOnClickListener(this);
        fabOne.setOnClickListener(this);
        fabTwo.setOnClickListener(this);
        fabThree.setOnClickListener(this);
    }

    private void openMenu(){
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(interpolator).rotation(45f).setDuration(400).start();

        fabOne.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(400).start();
        fabOne.setVisibility(View.VISIBLE);
        fabTwo.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(400).start();
        fabTwo.setVisibility(View.VISIBLE);
        fabThree.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(400).start();
        fabThree.setVisibility(View.VISIBLE);
    }

    private void closeMenu(){
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(interpolator).rotation(0f).setDuration(400).start();

        fabOne.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(400).start();
        fabTwo.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(400).start();
        fabThree.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(400).start();
        delay();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
        switch (v.getId()){
            case R.id.fab_main:
                if (isMenuOpen){
                    closeMenu();
                }else {
                    openMenu();
                }
                break;
            case R.id.fab_one:
                break;
            case R.id.fab_two:
                break;
            case R.id.fab_three:
                break;
        }
    }

    private void delay(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fabThree.setVisibility(View.GONE);
                fabOne.setVisibility(View.GONE);
                fabTwo.setVisibility(View.GONE);
            }
        }, 500);
    }

}
