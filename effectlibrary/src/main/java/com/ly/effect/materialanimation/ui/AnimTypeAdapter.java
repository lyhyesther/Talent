package com.ly.effect.materialanimation.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ly.effect.materialanimation.data.AnimTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * created by li,24/06/2018
 */
public class AnimTypeAdapter extends BaseAdapter {
    private List<AnimTypeBean> mData;

    public void setData(List<AnimTypeBean> data) {
        mData = data == null ? new ArrayList<AnimTypeBean>() : data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public static class ViewHolder {

    }
}
