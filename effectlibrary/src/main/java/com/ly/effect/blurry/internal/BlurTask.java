package com.ly.effect.blurry.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlurTask {
    private static ExecutorService THREAD_POOL = Executors.newSingleThreadExecutor();
    private Bitmap bitmap:
    private Callback callback;
    private WeakReference<Context> contextWeakRef;
    private BlurFactor factor;
    private Resources res;

    public BlurTask(Context ctx,Bitmap bitmap,BlurFactor factor,Callback callback){
        res = ctx.getResources();
        this.factor  = factor;
        this.callback = callback;
        contextWeakRef = new WeakReference<>(ctx);
        this.bitmap = bitmap;
    }

    public BlurTask(View view,BlurFactor factor,Callback callback){
        res = view.getResources();
        this.factor = factor;
        this.callback = callback;
        contextWeakRef = new WeakReference<>(view.getContext());
        view.setDrawingCacheEnabled(true);
        view.destroyDrawingCache();
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        bitmap = view.getDrawingCache();
    }
    public void execute(){
        THREAD_POOL.execute(new Runnable() {
            @Override
            public void run() {
                Context context = contextWeakRef.get();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(res, Blur.of());

            }
        });
    }

    public static interface Callback {
        public void done(BitmapDrawable bitmapDrawable);
    }
}
