package com.example.dmorax.intentionspart2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thirdActivity extends Activity {

    TextView numero;
    TextView nomRue;
    TextView CP;
    TextView ville;
    Button validerThird;
    Button annulerThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        numero = (TextView) findViewById(R.id.editNumero);
        nomRue = (TextView) findViewById(R.id.editNomRue);
        CP = (TextView) findViewById(R.id.editCP);
        ville = (TextView) findViewById(R.id.editVille);

        validerThird = (Button) findViewById(R.id.valider2);
        annulerThird = (Button) findViewById(R.id.annuler2);

        Intent i = getIntent();
        numero.setText(i.getStringExtra("numero"));
        nomRue.setText(i.getStringExtra("nomRue"));
        CP.setText(i.getStringExtra("CP"));
        ville.setText(i.getStringExtra("ville"));

        validerThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validerClic();
            }
        });

        annulerThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                annulerClic();
            }
        });
    }

    public void validerClic(){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("numero",numero.getText().toString());
        i.putExtra("nomRue",nomRue.getText().toString());
        i.putExtra("CP",CP.getText().toString());
        i.putExtra("ville",ville.getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }

    public void annulerClic(){
        Intent i = new Intent(this,MainActivity.class);
        setResult(RESULT_CANCELED,i);
        finish();

    }
}
