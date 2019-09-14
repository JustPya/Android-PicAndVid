package com.moviles.proof;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.VideoView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Bitmap> imageList;
    private ArrayList<Uri> videoList;
    private boolean isPictureGrid;

    public GridAdapter(Context context, ArrayList<Bitmap> imageList, ArrayList<Uri> videoList) {

        this.context = context;

        if (videoList == null) {
            this.imageList = imageList;
            this.isPictureGrid = true;
        } else {
            this.videoList = videoList;
            this.isPictureGrid = false;
        }
    }

    @Override
    public int getCount() {
        return isPictureGrid ? imageList.size() : videoList.size();
    }

    @Override
    public Object getItem(int i) {
        return isPictureGrid ? imageList.get(i) : videoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = isPictureGrid ? layoutInflater.inflate(R.layout.item_grid_image, null) : layoutInflater.inflate(R.layout.item_grid_video, null);
        }

        if (isPictureGrid) {
            ImageView imageItem = (ImageView) view.findViewById(R.id.imageItem);
            imageItem.setImageBitmap(imageList.get(i));
        } else {
            VideoView videoItem = (VideoView) view.findViewById(R.id.videoItem);
            videoItem.setVideoURI(videoList.get(i));
            videoItem.start();
        }


        return view;
    }
}
