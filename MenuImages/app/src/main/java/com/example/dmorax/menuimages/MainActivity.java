package com.example.dmorax.menuimages;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private int Turn_V = 1;
    private int Turn_H = 2;
    Button chargerImage1;
    Button turnH1;
    Button turnV1;
    ImageView imagePlace1;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chargerImage1 = findViewById(R.id.chargerImage);
        turnH1 = findViewById(R.id.turnH);
        turnV1 = findViewById(R.id.turnV);
        imagePlace1 = findViewById(R.id.imagePlace);

        chargerImage1.setOnClickListener(chargerImageListener);
        turnH1.setOnClickListener(turnHListener);
        turnV1.setOnClickListener(turnVListener);
    }

    private View.OnClickListener chargerImageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("console", "Charger image");

            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(i, "Choisir une image"), 100);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        int request_Code = 100;
        if (requestCode == request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imagePlace1.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private View.OnClickListener turnHListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imagePlace1.setImageBitmap(flipImage(Turn_H));
        }
    };

    private View.OnClickListener turnVListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imagePlace1.setImageBitmap(flipImage(Turn_V));
        }
    };

    public Bitmap flipImage(int type) {
        Matrix matrix = new Matrix();
        if(type == Turn_V) {
            matrix.preScale(1.0f, -1.0f);
        }
        else if(type == Turn_H) {
            matrix.preScale(-1.0f, 1.0f);
        } else {
            return null;
        }
        BitmapDrawable drawable = (BitmapDrawable) imagePlace1.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}