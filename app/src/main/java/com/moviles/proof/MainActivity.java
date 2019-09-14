
package com.moviles.proof;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_VIDEO_CAPTURE = 2;

    /**
     * Buttons
     */
    private ImageButton cameraId;
    private ImageButton videoId;
    private ImageButton galleryId;

    /**
     * Layouts
     */
    private TextView lcameraId;
    private TextView lvideoId;
    private TextView lgalleryId;

    private GridView imageGridViewId;
    private GridAdapter imageAdapter;
    private GridAdapter videoAdapter;

    private ArrayList<Bitmap> images;
    private ArrayList<Uri> videos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new ArrayList<>();
        videos = new ArrayList<>();

        lcameraId = (TextView) findViewById(R.id.lcameraId);
        lvideoId = (TextView) findViewById(R.id.lvideoId);
        lgalleryId = (TextView) findViewById(R.id.lgalleryId);

        imageGridViewId = (GridView) findViewById(R.id.captureGridView);
        imageAdapter = new GridAdapter(this,images,null);
        imageGridViewId.setAdapter(imageAdapter);
        videoAdapter = new GridAdapter(this,null,videos);


    }

    public void galleryButton(View view) {
        lgalleryId.setTextColor(Color.parseColor("#2E51F0"));
        lcameraId.setTextColor(Color.parseColor("#B8B9BD"));
        lvideoId.setTextColor(Color.parseColor("#B8B9BD"));
    }

    public void cameraButton(View view) {
        lcameraId.setTextColor(Color.parseColor("#2E51F0"));
        lvideoId.setTextColor(Color.parseColor("#B8B9BD"));
        lgalleryId.setTextColor(Color.parseColor("#B8B9BD"));
    }

    public void videoButton(View view) {
        lvideoId.setTextColor(Color.parseColor("#2E51F0"));
        lgalleryId.setTextColor(Color.parseColor("#B8B9BD"));
        lcameraId.setTextColor(Color.parseColor("#B8B9BD"));
    }


    public void takePic(View view) {
        Toast.makeText(this, "Tomar Foto", Toast.LENGTH_SHORT).show();
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }

    public void takeVid(View view) {
        Toast.makeText(this, "Tomar Video", Toast.LENGTH_SHORT).show();
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Toast.makeText(this, "Tome su foto :v", Toast.LENGTH_SHORT).show();

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            images.add(imageBitmap);
        }
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            videos.add(data.getData());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
