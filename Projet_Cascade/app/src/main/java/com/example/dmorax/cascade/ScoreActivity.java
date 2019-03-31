package com.example.dmorax.cascade;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView lvl_1 = (TextView) findViewById(R.id.lvl1);
        TextView lvl_2 = (TextView) findViewById(R.id.lvl2);
        TextView lvl_3 = (TextView) findViewById(R.id.lvl3);
        TextView lvl_4 = (TextView) findViewById(R.id.lvl4);
        TextView lvl_5 = (TextView) findViewById(R.id.lvl5);


        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String s1=prefs.getString("score1", "");
        lvl_1.setText(s1);
        String s2=prefs.getString("score2", "");
        lvl_2.setText(s2);
        String s3=prefs.getString("score3", "");
        lvl_3.setText(s3);
        String s4=prefs.getString("score4", "");
        lvl_4.setText(s4);
        String s5=prefs.getString("score5", "");
        lvl_5.setText(s5);

    }
}