package devesh.ephrine.selfhypnosis;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class about extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        ColorDrawable colorDrawable = new  ColorDrawable(Color.parseColor("#00BCD4"));
        bar.setBackgroundDrawable(colorDrawable);

        RotateAnimation anim = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(500);
// Start animating the image
        final ImageView splash = (ImageView) findViewById(R.id.imageView4);
        splash.startAnimation(anim);
    }

    public void visit(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://ephrine.blogspot.com")); //Google play store
        startActivity(intent);

    }

    //http://goo.gl/forms/CJvLGFXOEE

    public void contact(View v){

        setContentView(R.layout.web);
        WebView myWebView = (WebView) findViewById(R.id.webView3);
        myWebView.loadUrl("http://goo.gl/forms/CJvLGFXOEE");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new MyWebViewClient());
    }

    private class MyWebViewClient extends WebViewClient {

       ProgressBar p = (ProgressBar) findViewById(R.id.progressBar);

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {



            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs

            //     if (mInterstitialAd.isLoaded()) {
            //        mInterstitialAd.show();
            //     } else {
            //     }
            if (Uri.parse(url).getHost().equals("docs.google.com")) {
                // This is my web site, so do not override; let my WebView load the page
               // dialog = ProgressDialog.show(about.this, "",
               //         "Loading. Please wait...", true);
                p.setVisibility(View.VISIBLE);
                return false;
            }
            if (Uri.parse(url).getHost().equals("goo.gl")) {
                // This is my web site, so do not override; let my WebView load the page
              //  dialog = ProgressDialog.show(about.this, "",
               //         "Loading. Please wait...", true);
                p.setVisibility(View.VISIBLE);
                return false;
            }



            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
          //  dialog = ProgressDialog.show(about.this, "",
            //        "Loading. Please wait...", true);
            p.setVisibility(View.VISIBLE);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
p.setVisibility(View.GONE);
            //dialog.hide();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
