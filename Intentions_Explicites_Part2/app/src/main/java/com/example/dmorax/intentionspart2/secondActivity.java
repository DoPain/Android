package com.example.dmorax.intentionspart2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends Activity {


    TextView nom;
    TextView prenom;
    TextView tel;
    Button validerSecond;
    Button annulerSecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nom = (TextView) findViewById(R.id.editNom);
        prenom = (TextView) findViewById(R.id.editPrenom);
        tel = (TextView) findViewById(R.id.editTel);

        validerSecond = (Button) findViewById(R.id.valider);
        annulerSecond = (Button) findViewById(R.id.annuler);

        Intent i = getIntent();
        nom.setText(i.getStringExtra("nom"));
        prenom.setText(i.getStringExtra("prenom"));
        tel.setText(i.getStringExtra("tel"));

        validerSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validerClic();
            }
        });

        annulerSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                annulerClic();
            }
        });
    }

    public void validerClic(){
        Intent i = new Intent();
        i.putExtra("nom",nom.getText().toString());
        i.putExtra("prenom",prenom.getText().toString());
        i.putExtra("tel",tel.getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }

    public void annulerClic(){
        Intent i = new Intent();
        setResult(RESULT_CANCELED,i);
        finish();
    }
}
