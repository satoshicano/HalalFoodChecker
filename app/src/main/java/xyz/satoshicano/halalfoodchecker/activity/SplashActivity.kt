package xyz.satoshicano.halalfoodchecker.activity

import android.os.Bundle

import xyz.satoshicano.halalfoodchecker.R

import android.app.Activity
import android.content.Intent
import android.os.Handler

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    public override fun onStart() {
        super.onStart()
        val hdl = Handler()
        hdl.postDelayed(splashHandler(), 2000)
    }

    private inner class splashHandler : Runnable {
        override fun run() {
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)
            this@SplashActivity.finish()
        }
    }
}