package xyz.satoshicano.halalfoodchecker.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import android.widget.Toast

import com.bumptech.glide.Glide
import xyz.satoshicano.halalfoodchecker.R

class FindHalalResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_halal_result)
        val intent = intent
        val image_url = intent.getStringExtra("image_url")
        Log.d("CAKE_IMAGE", image_url)
        val resultImageView = findViewById(R.id.result_image_view) as ImageView
        Glide.with(this).load(image_url).into(resultImageView)
        Toast.makeText(this, "This is no Halal Food", Toast.LENGTH_LONG).show()
    }

}
