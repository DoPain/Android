package com.example.dmorax.cascade;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapteur extends BaseAdapter{

    private Context mContext;
    Integer[][] tab_jeu ;
    private int size;



    public ImageAdapteur(Context c, int size, Integer[][] tab_jeu) {
        this.tab_jeu = tab_jeu;
        this.size = size;
        mContext = c;

    }

    public int getCount() {
        return size*size;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        int i = position / this.size;
        int j = position % this.size ;
        return tab_jeu[i][j];

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setAdjustViewBounds(true);

        } else {
            imageView = (ImageView) convertView;

        }
        int i = position / this.size;
        int j = position % this.size ;
        imageView.setImageResource(tab_jeu[i][j]);
        return imageView;
    }





}
