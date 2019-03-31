package com.example.dmorax.cascade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    RatingBar bar;
    Button goBtn;
    Button scoreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


           goBtn = (Button) findViewById(R.id.button_Go);
           scoreBtn = (Button) findViewById(R.id.button_Score);



        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar = (RatingBar) findViewById(R.id.barDiff);
                final float diff=bar.getRating();
                Intent intent = new Intent(MainActivity.this,JeuActivity.class);
                intent.putExtra("1",diff);
                startActivity(intent);
            }
        });
        scoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ScoreActivity.class);
                startActivity(intent);
            }
        });
    }

}