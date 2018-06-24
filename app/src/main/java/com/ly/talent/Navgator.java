package com.ly.talent;

import android.content.Context;
import android.content.Intent;

/**
 * created by li,24/06/2018
 */
public class Navgator {

    public void navToCommon(Context context,Class<?> cls){
        Intent intent = new Intent(context,cls);
        context.startActivity(intent);
    }
}
