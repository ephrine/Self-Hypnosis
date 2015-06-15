package devesh.ephrine.selfhypnosis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class faq extends ActionBarActivity {
    ProgressDialog dialog;

    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        ColorDrawable colorDrawable = new  ColorDrawable(Color.parseColor("#00BCD4"));
        bar.setBackgroundDrawable(colorDrawable);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        WebView myWebView = (WebView) findViewById(R.id.webView2);
        myWebView.loadUrl("https://sites.google.com/site/selfhyptnosis/faq");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new MyWebViewClient());


        mInterstitialAd = new InterstitialAd(this); // interstitial ad
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        // // sample
        // test
        // AD

        //   mInterstitialAd.setAdUnitId("ca-app-pub-6702661245453687/5778651052"); // WARNING
        // !!!!!->
        // My
        // OWN
        // f**kin
        // AD
        // id

        requestNewInterstitial();

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                finish();
            }
        });

    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("YOUR_DEVICE_HASH")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


    private class MyWebViewClient extends WebViewClient {



        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {



            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs

            //     if (mInterstitialAd.isLoaded()) {
            //        mInterstitialAd.show();
            //     } else {
            //     }
            if (Uri.parse(url).getHost().equals("sites.google.com")) {
                // This is my web site, so do not override; let my WebView load the page
                dialog = ProgressDialog.show(faq.this, "",
                        "Loading. Please wait...", true);
                return false;
            }else {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                }
            }



            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            dialog = ProgressDialog.show(faq.this, "",
                    "Loading. Please wait...", true);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            dialog.hide();
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_faq, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            Intent w = new Intent(this, about.class);
            startActivity(w);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
