package com.example.dmorax.intentionspart2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends Activity {


    TextView nom;
    TextView prenom;
    TextView tel;
    Button valider1;
    Button annuler1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nom = (TextView) findViewById(R.id.editNom);
        prenom = (TextView) findViewById(R.id.editPrenom);
        tel = (TextView) findViewById(R.id.editTel);

        valider1 = (Button) findViewById(R.id.valider);
        annuler1 = (Button) findViewById(R.id.annuler);

        Intent i = getIntent();
        nom.setText(i.getStringExtra("nom"));
        prenom.setText(i.getStringExtra("prenom"));
        tel.setText(i.getStringExtra("tel"));

        valider1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validerClic();
            }
        });

        annuler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                annulerClic();
            }
        });
    }

    public void validerClic(){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("nom",nom.getText().toString());
        i.putExtra("prenom",prenom.getText().toString());
        i.putExtra("tel",tel.getText().toString());
    }

    public void annulerClic(){

    }
}
