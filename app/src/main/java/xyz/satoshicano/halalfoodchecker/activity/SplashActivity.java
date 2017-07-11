package xyz.satoshicano.halalfoodchecker.activity;

import android.os.Bundle;

import xyz.satoshicano.halalfoodchecker.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.activity_splash);
    }

    @Override
    public void onStart(){
        super.onStart();
        final Handler hdl = new Handler();
        hdl.postDelayed(new splashHandler(), 2000);
    }

    private class splashHandler implements Runnable {
        public void run() {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        }
    }
}