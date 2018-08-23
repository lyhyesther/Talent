

##
对于Android调用JS代码的方法有2种： 
1. 通过WebView的loadUrl（） 
2. 通过WebView的evaluateJavascript（）
该方法比第一种方法效率更高、使用更简洁；该方法的执行不会使页面刷新，而第一种方法（loadUrl ）的执行则会。Android 4.4 后才可使用

对于JS调用Android代码的方法有3种： 
1. 通过WebView的addJavascriptInterface（）进行对象映射 
2. 通过 WebViewClient 的shouldOverrideUrlLoading ()方法回调拦截 url 
3. 通过 WebChromeClient 的onJsAlert()、onJsConfirm()、onJsPrompt（）方法回调拦截JS对话框alert()、confirm()、prompt（） 消息