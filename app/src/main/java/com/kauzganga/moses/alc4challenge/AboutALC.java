package com.kauzganga.moses.alc4challenge;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.ClientCertRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

public class AboutALC extends AppCompatActivity {

    WebView webViewAboutAlc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webViewAboutAlc = (WebView) findViewById(R.id.about_webview);
        webViewAboutAlc.setWebChromeClient(new WebChromeClient());
        webViewAboutAlc.setWebViewClient(new WebViewClient());
        webViewAboutAlc.getSettings().setJavaScriptEnabled(true);
        webViewAboutAlc.getSettings().setDomStorageEnabled(true);
        webViewAboutAlc.setWebViewClient(new AlcWebView());
        //loads the Andela page
        webViewAboutAlc.loadUrl("https://andela.com/alc/");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class AlcWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                       SslError error) {
            handler.proceed();
        }
    }
}
