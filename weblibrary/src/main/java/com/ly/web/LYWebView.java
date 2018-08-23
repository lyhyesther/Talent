package com.ly.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 *
 *
 * */
public class LYWebView extends WebView {
    private WebSettings mSettings;

    public LYWebView(Context context) {
        super(context);
    }

    public LYWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LYWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init() {
        mSettings = getSettings();
        //设置加载的html要与js交互
        mSettings.setJavaScriptEnabled(true);
        //自适应屏幕，缩放至屏幕的大小
        mSettings.setLoadWithOverviewMode(true);
        mSettings.setUseWideViewPort(true);

        //设置可以访问文件
        mSettings.setAllowFileAccess(true);
        //支持允许JS弹窗
        mSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //设置自动加载图片
        mSettings.setLoadsImagesAutomatically(true);
        //设置编码格式
        mSettings.setDefaultTextEncodingName("utf-8");


        //缓存策略
//        当加载 html 页面时，WebView会在/data/data/包名目录下生成 database 与 cache 两个文件夹
//        请求的 URL记录保存在 WebViewCache.db，而 URL的内容是保存在 WebViewCache 文件夹下
//        是否启用缓存：
        //缓存模式如下：
        //LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
        //LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
        //LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
        //LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。

//        if (NetStatusUtil.isConnected(getApplicationContext())) {
//            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//根据cache-control决定是否从网络上取数据。
//        } else {
//            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//没网，则从本地获取，即离线加载
//        }

        mSettings.setDomStorageEnabled(true); // 开启 DOM storage API 功能
        mSettings.setDatabaseEnabled(true);   //开启 database storage API 功能
        mSettings.setAppCacheEnabled(true);//开启 Application Caches 功能
//        设置缓存路径
//        mSettings.setAppCachePath();
        try {
            mSettings.setSavePassword(false);
        } catch (Exception e) {
        }
    }

    @Override
    public void evaluateJavascript(String script, @Nullable ValueCallback<String> resultCallback) {
        super.evaluateJavascript(script, resultCallback);
    }

    /***
     * 默认的WebViewClient实现
     * */
    public static class LYWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //防止调用系统浏览器
            view.loadUrl(url);
            return true;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            //防止调用系统浏览器
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            //开始载入页面
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            //在加载页面资源时会调用，每一个资源（比如图片）的加载都会调用一次
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //在页面加载结束时调用
            //JS代码调用一定要在 onPageFinished（） 回调之后才能调用，否则不会调用
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            //加载页面的服务器出现错误时（如404）调用
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            //webView默认是不处理https请求的，页面显示空白，需要进行如下设置
            handler.proceed();    //表示等待证书响应
            // handler.cancel();      //表示挂起连接，为默认方式
            // handler.handleMessage(null);    //可做其他处理
        }
    }
    /**
     * 辅助 WebView 处理 Javascript 的对话框,网站图标,网站标题等等
     * */
    public static class LYWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            //获得网页的加载进度
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            //获取Web页中的标题
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            //js 中的alert对话框
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            return super.onJsConfirm(view, url, message, result);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }
    }
}
