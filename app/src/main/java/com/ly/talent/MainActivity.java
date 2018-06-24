package com.ly.talent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ly.effect.materialanimation.ui.MaterialAnimationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToMaterialAnimation(View view){
        Navgator navgator = new Navgator();
        navgator.navToCommon(this, MaterialAnimationActivity.class);
    }
}
