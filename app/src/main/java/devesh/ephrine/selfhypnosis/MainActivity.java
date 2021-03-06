package devesh.ephrine.selfhypnosis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //   View decorView = getWindow().getDecorView();

        // int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        //   decorView.setSystemUiVisibility(uiOptions);

        VideoView video = (VideoView) findViewById(R.id.videoView);
        // Load and start the movie
        Uri video1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        video.setVideoURI(video1);
        video.start();
      /*  RotateAnimation anim = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(500);

// Start animating the image
        final ImageView splash = (ImageView) findViewById(R.id.imageView);
        splash.startAnimation(anim);

// Later.. stop the animation
        //  splash.setAnimation(null);

*/
        WindowManager.LayoutParams layout = getWindow().getAttributes();
        layout.screenBrightness = 1F;
        getWindow().setAttributes(layout);

        Context context = getApplicationContext();
        CharSequence text = "Now Look at the center of the eye & read the letters ";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        //  toast.show();


    }
    public void klk(View v){
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        decorView.setSystemUiVisibility(uiOptions);

    }
    public void ready(View v) {
        setContentView(R.layout.video);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
