package com.example.dmorax.calculatrice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {


    Button bouton0;
    Button bouton1;
    Button bouton2;
    Button bouton3;
    Button bouton4;
    Button bouton5;
    Button bouton6;
    Button bouton7;
    Button bouton8;
    Button bouton9;
    Button boutonPlus;
    Button boutonMoins;
    Button boutonPoint;
    Button boutonDiv;
    Button boutonMul;
    Button boutonEgal;
    Button boutonC;
    TextView textEcran;

    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton0 = (Button) findViewById(R.id.button0);
        bouton1 = (Button) findViewById(R.id.button1);
        bouton2 = (Button) findViewById(R.id.button2);
        bouton3 = (Button) findViewById(R.id.button3);
        bouton4 = (Button) findViewById(R.id.button4);
        bouton5 = (Button) findViewById(R.id.button5);
        bouton6 = (Button) findViewById(R.id.button6);
        bouton7 = (Button) findViewById(R.id.button7);
        bouton8 = (Button) findViewById(R.id.button8);
        bouton9 = (Button) findViewById(R.id.button9);
        boutonPoint = (Button) findViewById(R.id.buttonPoint);
        boutonPlus = (Button) findViewById(R.id.buttonPlus);
        boutonMoins = (Button) findViewById(R.id.buttonMoins);
        boutonDiv = (Button) findViewById(R.id.buttonDiv);
        boutonMul = (Button) findViewById(R.id.buttonMul);
        boutonC = (Button) findViewById(R.id.buttonClear);
        boutonEgal = (Button) findViewById(R.id.buttonEgal);
        textEcran = (TextView) findViewById(R.id.textEcran);

        boutonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        boutonMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });

        boutonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        boutonMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }
        });

        boutonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        boutonEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        boutonPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });

        bouton0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        bouton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        bouton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        bouton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        bouton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        bouton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        bouton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        bouton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        bouton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        bouton9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });
    }

    public void chiffreClick(String s){
        if(update){
            update = false;
        }
        else if(!textEcran.getText().equals("0")){
            s = textEcran.getText()+s;
        }
        textEcran.setText(s);
    }

    public void plusClick(){
        if(clicOperateur){
            calcul();
            textEcran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(textEcran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }

    public void moinsClick(){
        if(clicOperateur){
            calcul();
            textEcran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(textEcran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }


    public void mulClick(){
        if(clicOperateur){
            calcul();
            textEcran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(textEcran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }


    public void divClick(){
        if(clicOperateur){
            calcul();
            textEcran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(textEcran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }


    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }


    public void resetClick(){
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        textEcran.setText("");
    }

    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(textEcran.getText().toString()).doubleValue();
            textEcran.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(textEcran.getText().toString()).doubleValue();
            textEcran.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(textEcran.getText().toString()).doubleValue();
            textEcran.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.valueOf(textEcran.getText().toString()).doubleValue();
                textEcran.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                textEcran.setText("0");
            }
        }
    }
}

