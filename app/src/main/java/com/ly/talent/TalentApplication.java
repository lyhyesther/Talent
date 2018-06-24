package com.ly.talent;

import android.app.Application;

import com.ly.effect.EffectManager;

/**
 *
 *
 * created by li,24/06/2018
 */
public class TalentApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        initTask();

    }
    private void initTask(){
        EffectManager.getInstance().init(this);
    }

    private void initAsyncTask(){

    }
}
