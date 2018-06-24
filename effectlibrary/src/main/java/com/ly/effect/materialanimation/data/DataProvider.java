package com.ly.effect.materialanimation.data;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.ly.effect.R;

import java.util.Arrays;
import java.util.List;

/**
 * created by li,24/06/2018
 */
public class DataProvider {
    private Context mContext;

    //***************************

    /**
     * 静态内部类的方式来实现单例模式，保证懒加载和线程安全。
     */
    public static class DataProviderHolder {
        private static DataProvider sDataProvider = new DataProvider();
    }

    private DataProvider() {

    }

    public static DataProvider getInstance() {
        return DataProviderHolder.sDataProvider;
    }
    //***************************

    public void init(Context context) {
        mContext = context.getApplicationContext();
    }


    public List<AnimTypeBean> getAnimTypeList() {
        return Arrays.asList(
                new AnimTypeBean(AnimType.TRANSITION, "过渡动画（Transition）", ContextCompat.getColor(mContext, R.color.color_C81125)),
                new AnimTypeBean(AnimType.SHAREELEMENT, "共享元素（share element）", ContextCompat.getColor(mContext, R.color.color_C81125)),
                new AnimTypeBean(AnimType.VIEWANIMATION, "View动画（view animation）", ContextCompat.getColor(mContext, R.color.color_C81125)),
                new AnimTypeBean(AnimType.CIRCULARREVEALANIMATION, "反转动画（reveal animation）", ContextCompat.getColor(mContext, R.color.color_C81125))

        );
    }


}
