package demo.webview.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.Random;

/**
 * Created by tech60 on 2017/8/28.
 */

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private WebView mWebView1;
    private WebView mWebView2;
    private WebView mWebView3;
    private WebView mWebView4;

    private String[] ua = new String[]{
            "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
            "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1",
            "Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1",
            "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.8.131 Version/11.11",
            "Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)",
            "Opera/9.80 (Windows NT 5.1; U; zh-cn) Presto/2.9.168 Version/11.50",
            "Mozilla/5.0 (Windows NT 5.1; rv:5.0) Gecko/20100101 Firefox/5.0",
            "Mozilla/5.0 (Windows NT 5.2) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.11 TaoBrowser/2.0 Safari/536.11",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.71 Safari/537.1 LBBROWSER",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; LBBROWSER)",
            "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SV1; QQDownload 732; .NET4.0C; .NET4.0E; 360SE)",
            "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.84 Safari/535.11 SE 2.X MetaSr 1.0",
            "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1",
            "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SV1; QQDownload 732; .NET4.0C; .NET4.0E; SE 2.X MetaSr 1.0)",
            "Opera/9.27 (Windows NT 5.2; U; zh-cn)",
            "Opera/8.0 (Macintosh; PPC Mac OS X; U; en)",
            "Mozilla/5.0 (Macintosh; PPC Mac OS X; U; en) Opera 8.0",
            "Mozilla/5.0 (Windows; U; Windows NT 5.2) Gecko/2008070208 Firefox/3.0.1",
            "Mozilla/5.0 (Windows; U; Windows NT 5.1) Gecko/20070309 Firefox/2.0.0.3",
            "Mozilla/5.0 (Windows; U; Windows NT 5.1) Gecko/20070803 Firefox/1.5.0.12",
            "Mozilla/4.0 (compatible; MSIE 12.0",
            "Mozilla/5.0 (Windows NT 5.1; rv:44.0) Gecko/20100101 Firefox/44.0"
    };

    private String loadurl = "http://yzhsfood.com/a/210.html";
    private String loadurl1 = "http://yzhsfood.com/a/230.html";
    private String loadurl2 = "http://yzhsfood.com/a/240.html";
    private String loadurl3 = "http://yzhsfood.com/a/250.html";
    private String loadurl4 = "http://yzhsfood.com/a/260.html";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        setWebView(mWebView, loadurl);
        setWebView(mWebView1, loadurl1);
        setWebView(mWebView2, loadurl2);
        setWebView(mWebView3, loadurl3);
        setWebView(mWebView4, loadurl4);
    }

    private void setWebView(WebView mWebView, String loadurl) {
        WebSettings settings = mWebView.getSettings();
        //添加UA,  “app/XXX”：是与h5商量好的标识，h5确认UA为app/XXX就认为该请求的终端为App
        Random random = new Random();
        settings.setUserAgentString(ua[random.nextInt(ua.length)]);
        settings.setJavaScriptEnabled(false);

        // 自适应屏幕
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        // 不支持缩放(如果要支持缩放，html页面本身也要支持缩放：不能加user-scalable=no)
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setDisplayZoomControls(true);

        // 隐藏scrollbar
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);

        //设置参数
        settings.setBuiltInZoomControls(true);

        //设置无痕
        settings.setAppCacheEnabled(false);// 设置缓存
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl(loadurl);
        mWebView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent ev) {

                ((WebView) v).requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView1 = (WebView) findViewById(R.id.web_view1);
        mWebView2 = (WebView) findViewById(R.id.web_view2);
        mWebView3 = (WebView) findViewById(R.id.web_view3);
        mWebView4 = (WebView) findViewById(R.id.web_view4);
    }

    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            DataCleanManager.cleanExternalCache(this);
            DataCleanManager.cleanFiles(this);
            DataCleanManager.cleanInternalCache(this);
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

}
