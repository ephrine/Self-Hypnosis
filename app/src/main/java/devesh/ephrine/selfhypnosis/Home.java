package devesh.ephrine.selfhypnosis;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Home extends ActionBarActivity {

    InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        ColorDrawable colorDrawable = new  ColorDrawable(Color.parseColor("#00BCD4"));
        bar.setBackgroundDrawable(colorDrawable);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        RotateAnimation anim = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(500);
// Start animating the image
        final ImageView splash = (ImageView) findViewById(R.id.imageView2);
        splash.startAnimation(anim);


        mInterstitialAd = new InterstitialAd(this); // interstitial ad



         mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        // // sample
        // test
        // AD

  

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }
public void start(View v){
    Intent we = new Intent(this, MainActivity.class);
    startActivity(we);

}
    public void learn(View v){
        Intent we = new Intent(this, Learn.class);
        startActivity(we);

    }

        public void faq(View v){
        Intent e = new Intent(this, faq.class);
        startActivity(e);

    }
    public void spiral(View v){
        Intent e = new Intent(this, spiral.class);
        startActivity(e);

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


    @Override
    public void onBackPressed() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            finish();
        }

    }
}
