package com.moviles.proof;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    VideoView videoShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoShow = (VideoView) findViewById(R.id.videoShow);


        Bundle b = getIntent().getExtras();
        if (b != null) {
            String uri_Str= b.getString("VID");
            Uri uri = Uri.parse(uri_Str);
            videoShow.setVideoURI(uri);
        }
    }
}
