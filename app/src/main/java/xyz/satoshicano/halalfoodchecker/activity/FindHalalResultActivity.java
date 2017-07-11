package xyz.satoshicano.halalfoodchecker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import xyz.satoshicano.halalfoodchecker.R;

public class FindHalalResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_halal_result);
        Intent intent = getIntent();
        String image_url = intent.getStringExtra("image_url");
        Log.d("CAKE_IMAGE", image_url);
        ImageView resultImageView = (ImageView) findViewById(R.id.result_image_view);
        Glide.with(this).load(image_url).into(resultImageView);
        Toast.makeText(this, "This is no Halal Food", Toast.LENGTH_LONG).show();
    }

}
