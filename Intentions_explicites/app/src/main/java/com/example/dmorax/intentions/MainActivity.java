package com.example.dmorax.intentions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    Button envoyer;
    EditText nom;
    EditText prenom;
    EditText tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        envoyer = (Button) findViewById(R.id.buttonEnvoyer);
        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        tel = (EditText) findViewById(R.id.tel);

        envoyer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                envoyerClic();
            }
        });
    }

    public void envoyerClic(){
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("nom",nom.getText().toString());
        i.putExtra("prenom",prenom.getText().toString());
        i.putExtra("tel",tel.getText().toString());
        this.startActivity(i);
    }
}
