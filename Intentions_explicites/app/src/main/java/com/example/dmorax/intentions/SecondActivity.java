package com.example.dmorax.intentions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView nom;
    TextView prenom;
    TextView tel;

    private String n;
    private String p;
    private String t;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        nom = (TextView) findViewById(R.id.nom);
        prenom = (TextView) findViewById(R.id.prenom);
        tel = (TextView) findViewById(R.id.tel);

        Intent i = getIntent();

        n = i.getStringExtra("nom");
        p = i.getStringExtra("prenom");
        t = i.getStringExtra("tel");

        nom.setText(n);
        nom.setText(p);
        nom.setText(t);

    }
}
