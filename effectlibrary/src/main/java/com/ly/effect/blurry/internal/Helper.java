package com.ly.effect.blurry.internal;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;

public class Helper {

    /**
     * alpha动画View
     */
    public static void animate(View view, int duration) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        alphaAnimation.setDuration(duration);
        view.startAnimation(alphaAnimation);
    }

    /**
     * 判断整型数字中是否有0
     *
     * @param args
     */
    public static boolean hasZero(int... args) {
        int length = args.length;
        int i = 0;
        while (i < length) {
            if (args[i] == 0) {
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * @param view
     * @param drawable
     */
    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
