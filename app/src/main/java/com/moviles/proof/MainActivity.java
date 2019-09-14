
package com.moviles.proof;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**Buttons*/
    private ImageButton cameraId;
    private ImageButton videoId;
    private ImageButton galleryId;

    /**Layouts*/
    private TextView lcameraId;
    private TextView lvideoId;
    private TextView lgalleryId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraId = findViewById(R.id.cameraId);
        videoId = findViewById(R.id.videoId);
        galleryId = findViewById(R.id.galleryId);

        lcameraId = findViewById(R.id.lcameraId);
        lvideoId = findViewById(R.id.lvideoId);
        lgalleryId = findViewById(R.id.lgalleryId);
    }

    public void galleryButton(View view){
        lgalleryId.setTextColor(Color.parseColor("#2E51F0"));
        lcameraId.setTextColor(Color.parseColor("#B8B9BD"));
        lvideoId.setTextColor(Color.parseColor("#B8B9BD"));
    }

    public void cameraButton(View view){
        lcameraId.setTextColor(Color.parseColor("#2E51F0"));
        lvideoId.setTextColor(Color.parseColor("#B8B9BD"));
        lgalleryId.setTextColor(Color.parseColor("#B8B9BD"));
    }
    public void videoButton(View view){
        lvideoId.setTextColor(Color.parseColor("#2E51F0"));
        lgalleryId.setTextColor(Color.parseColor("#B8B9BD"));
        lcameraId.setTextColor(Color.parseColor("#B8B9BD"));
    }

}
