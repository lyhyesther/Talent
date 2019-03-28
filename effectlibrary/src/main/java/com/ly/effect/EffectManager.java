package com.ly.effect;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.ly.effect.materialanimation.data.DataProvider;

/**
 * created by li,24/06/2018
 */
public class EffectManager {
    //**********
    public static class EffectManagerHolder {
        public static EffectManager sEffectManager = new EffectManager();
    }

    private EffectManager() {

    }

    public static EffectManager getInstance() {
        return EffectManagerHolder.sEffectManager;
    }
    //**********

    public void init(Context context){
        DataProvider.getInstance().init(context);
    }
}
