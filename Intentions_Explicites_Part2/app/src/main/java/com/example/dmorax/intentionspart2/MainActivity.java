package com.example.dmorax.intentionspart2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    TextView nom;
    TextView prenom;
    TextView tel;
    TextView numero;
    TextView nomRue;
    TextView CP;
    TextView ville;
    Button modifier;
    Button modifier22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (TextView) findViewById(R.id.textNom);
        prenom = (TextView) findViewById(R.id.textPrenom);
        tel = (TextView) findViewById(R.id.textTel);
        numero = (TextView) findViewById(R.id.textNumero);
        nomRue = (TextView) findViewById(R.id.textNomRue);
        CP = (TextView) findViewById(R.id.textCP);
        ville = (TextView) findViewById(R.id.textVille);
        modifier = (Button) findViewById(R.id.modifier1);
        modifier22 = (Button) findViewById(R.id.modifier2);

        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifierClicPersonne();
            }
        });

        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifierClicInfos();
            }
        });

        Intent i = getIntent();

        if (i.getStringExtra("nom")!=null){
            nom.setText(i.getStringExtra("nom"));
        }
        if (i.getStringExtra("prenom")!=null){
            prenom.setText(i.getStringExtra("prenom"));
        }
        if (i.getStringExtra("tel")!=null){
            tel.setText(i.getStringExtra("tel"));
        }
        if (i.getStringExtra("numero")!=null){
            numero.setText(i.getStringExtra("numero"));
        }
        if (i.getStringExtra("nomRue")!=null){
            nomRue.setText(i.getStringExtra("nomRue"));
        }
        if (i.getStringExtra("CP")!=null){
            CP.setText(i.getStringExtra("CP"));
        }
        if (i.getStringExtra("ville")!=null){
            ville.setText(i.getStringExtra("ville"));
        }
    }

    public void modifierClicPersonne(){
        Intent i = new Intent(this,secondActivity.class);
        i.putExtra("nom", nom.getText().toString());
        i.putExtra("prenom", prenom.getText().toString());
        i.putExtra("tel", tel.getText().toString());
        this.startActivity(i);
    }

    public void modifierClicInfos(){
        Intent i = new Intent(this,thirdActivity.class);
        i.putExtra("numero", numero.getText().toString());
        i.putExtra("nomRue", nomRue.getText().toString());
        i.putExtra("CP", CP.getText().toString());
        i.putExtra("ville", ville.getText().toString());
        this.startActivity(i);
    }
}
