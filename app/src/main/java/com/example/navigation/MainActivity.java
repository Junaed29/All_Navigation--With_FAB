package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fabOne,fabTwo,fabThree,fabMain;

    OvershootInterpolator interpolator = new OvershootInterpolator();

    float translationY = 100f;
    boolean isMenuOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFabMenu();
    }
    public void initFabMenu(){
        fabOne = findViewById(R.id.fab_one);
        fabMain = findViewById(R.id.fab_main);
        fabTwo = findViewById(R.id.fab_two);
        fabThree = findViewById(R.id.fab_three);

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
        delay(500);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
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

    public void delay(int miliSecond){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fabThree.setVisibility(View.GONE);
                fabOne.setVisibility(View.GONE);
                fabTwo.setVisibility(View.GONE);
            }
        },miliSecond);
    }
}
