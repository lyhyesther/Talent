package com.ly.effect.blurry;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ly.effect.blurry.internal.BlurFactor;
import com.ly.effect.blurry.internal.BlurTask;
import com.ly.effect.blurry.internal.Helper;

/**
 * 模糊效果类
 */
public class Blurry {
    private static final String TAG = "Blurry";

    /**
     * 从container中移除Bluury view
     *
     * @param container
     */
    public static void delete(ViewGroup container) {
        View blurryView = container.findViewWithTag(TAG);
        if (blurryView != null) container.removeView(blurryView);
    }

    public static class Composer {
        private boolean animate;
        private boolean async;
        private View blurredView;
        private Context context;
        private int duration = 300;
        private BlurFactor factor;
        private ImageComposer.ImageComposerListener listener;

        public Composer(Context ctx) {
            context = ctx;
            blurredView = new View(ctx);
            blurredView.setTag(TAG);
            factor = new BlurFactor();
        }

        public void addView(ViewGroup container, Drawable drawable) {
            Helper.setBackground(container, drawable);
            container.addView(blurredView);
            if (animate) {
                Helper.animate(blurredView, duration);
            }
        }

        public Composer animate() {
            this.animate = true;
            return this;
        }

        public Composer animate(int duration) {
            animate = true;
            this.duration = duration;
            return this;
        }

        public Composer async() {
            async = true;
            return this;
        }

        public Composer async(ImageComposer.ImageComposerListener listener) {
            async = true;
            this.listener = listener;
            return this;
        }

        public ImageComposer capture(View view) {
            return new Blurry.ImageComposer.ImageComposerListener();
        }

        public Composer color(int color) {
            factor.color = color;
            return this;
        }

        public Blurry.BitmapComposer from() {

        }


    }

    public static class ImageComposer {
        private boolean async;
        private View capture;
        private Context context;
        private BlurFactor factor;
        private ImageComposerListener listtener;

        public ImageComposer(Context ctx, View capture, BlurFactor factor, boolean async, ImageComposerListener listener) {
            context = ctx;
            this.capture = capture;
            this.factor = factor;
            this.async = async;
            this.listtener = listener;
        }

        public void into(ImageView imageView) {
            factor.width = capture.getMeasuredWidth();
            factor.height = capture.getMeasuredHeight();
            if (async){
                new BlurTask(capture, factor, new BlurTask.Callback() {
                    @Override
                    public void done(BitmapDrawable bitmapDrawable) {
                        if (listtener!=null){
                           //todo  listtener.
                        }
                    }
                })
            }
        }

        public interface ImageComposerListener {

        }
    }

    public static class BitmapComposer {

    }
}
