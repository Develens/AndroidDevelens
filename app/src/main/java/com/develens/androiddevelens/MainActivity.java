package com.develens.androiddevelens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.develens.andydevelens.ImageSlider;
import com.develens.andydevelens.PreferenceHelper;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceHelper preferenceHelper = new PreferenceHelper(this, "MAINKEY");
        preferenceHelper.SaveString("KEY", "VALUE");
    }
}
