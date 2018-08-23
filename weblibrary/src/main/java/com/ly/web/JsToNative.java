package com.ly.web;

import android.webkit.JavascriptInterface;

/**
 * 定义JS需要调用的方法
 * */
public class JsToNative {

    /**
     * @param msg JS向java层传递的消息
     * */
    @JavascriptInterface
    public void sendMessage(String msg){

    }
}
