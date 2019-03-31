package com.example.dmorax.cascade;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
public class JeuActivity extends AppCompatActivity {

    SharedPreferences.Editor edit;
    private Integer blanc=R.drawable.tuile0;
    private GridView gridview;
    private  TextView txt_score;
    private Button button_retry;
    private TextView txt_diff;
    private int difficulte;
    private Integer[] tab = {R.drawable.tuile1, R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4};
    private Integer tab_jeu [][];
    private int size ;
    private double score_final;
    private int combo;
    private Context that = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        txt_diff = (TextView) findViewById(R.id.textView3);
        button_retry = (Button) findViewById(R.id.button_retry);
        txt_score = (TextView) findViewById(R.id.score);
        gridview = (GridView) findViewById(R.id.Grid_View);


        combo =0;
        score_final =0;

        Intent intent= getIntent();
        float a = intent.getFloatExtra("1",0);

        difficulte=(int)a;
        String Diff_string = Float.toString(difficulte);
        this.size=difficulte*5;
        gridview.setNumColumns(size);

        this.tab_jeu=new Integer[this.size+1][this.size+1];

        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++) {
                Random rand = new Random();
                this.tab_jeu[i][j] = tab[rand.nextInt(4)];
            }
        }

        txt_score.setText(""+score_final);

        txt_diff.setText(Diff_string);

        gridview.setAdapter(new ImageAdapteur(that,size,tab_jeu));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                int i = position / size;
                int j = position % size ;
                boolean first = true;

                    if (id == blanc) {
                        Toast.makeText(JeuActivity.this, "Cliquez sur une case remplie. ",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        click(i,j,id,first);
                        calcul_score(combo);
                        combo=0;
                        deplacerCouleur();
                        txt_score.setText(""+(int)score_final);
                        if (verifiergagner()){
                            Toast.makeText(JeuActivity.this, "vous ne pouvez plus jouer, votre score est de : "+(int)score_final,Toast.LENGTH_SHORT).show();
                        }
                        deplacerColonne();
                    }

                gridview.setAdapter(new ImageAdapteur(that,size,tab_jeu));

            }
        });

        button_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enregistrerScore();
                for(int i=0;i<size;i++){
                    for(int j=0;j<size;j++) {
                        Random rand = new Random();
                        tab_jeu[i][j] = tab[rand.nextInt(4)];
                    }
                }
                score_final=0;
                txt_score.setText(""+0);
                gridview.setAdapter(new ImageAdapteur(that,size,tab_jeu));
            }
        });
    }

    private void calcul_score(int x){
        if(x!=0) {
            score_final = score_final + Math.exp(x) * 10;
        }
    }


    private void click(int i, int j, long id, boolean first){

        if(!first){
            tab_jeu[i][j]=blanc;
        }
        else{
            first=false;
            combo=0;
        }
        try {
            if (id == tab_jeu[i + 1][j]) {
                click(i + 1, j,id, first);
                combo++;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("1"+e);
        }

        try {
            if (id == tab_jeu[i - 1][j]) {
                click(i - 1, j,id, first);
                combo++;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("2"+e);
        }
        try {
            if (id == tab_jeu[i][j+1]) {
                click(i, j+1,id, first);
                combo++;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("3"+e);
        }
        try {
            if (id == tab_jeu[i][j-1]) {
                click(i, j-1,id, first);
                combo++;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("4"+e);
        }
    }

    private boolean verifierColonneVide(int i){
        int cpt=0;
        for (int j = 0; j < size; j++) {

            if(tab_jeu[j][i]==blanc){
                cpt++;
            }
        }
        if(cpt==size){
            return true;
        }
        else {return false;}
    }

    private void deplacerColonne(){
        for (int i = 0; i < size; i++) {
            if (verifierColonneVide(i)){
                int z=1;
                while(verifierColonneVide(i+z))
                {
                    z++;
                }
                for (int j = 0; j < size; j++) {
                    try {
                        tab_jeu[j][i] = tab_jeu[j][i + z];
                        tab_jeu[j][i + z] = blanc;
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("5"+e);
                    }
                }
            }

        }

    }

    private boolean verifiergagner() {
        boolean ok=true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                try {
                    if (tab_jeu[i][j]!=blanc && tab_jeu[i][j] == tab_jeu[i + 1][j]) {
                        ok=false;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("7"+e);
                }

                try {
                    if (tab_jeu[i][j]!=blanc &&tab_jeu[i][j]  == tab_jeu[i - 1][j]) {
                        ok=false;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("8"+e);
                }
                try {
                    if (tab_jeu[i][j]!=blanc &&tab_jeu[i][j]  == tab_jeu[i][j+1]) {
                        ok=false;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("9"+e);
                }
                try {
                    if (tab_jeu[i][j]!=blanc && tab_jeu[i][j]  == tab_jeu[i][j-1]) {
                        ok=false;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("10"+e);
                }
            }
        }
        return ok;
    }

    private void deplacerCouleur(){

        for (int i=0;i<size;i++) {
            ArrayList<Integer>color=new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if(tab_jeu[j][i]!=blanc){
                    color.add(tab_jeu[j][i]);
                    tab_jeu[j][i]=blanc;
                }
            }
            int diff=size-color.size();
            int pos=0;
            for (int j = diff; j <size; j++) {
                tab_jeu[j][i]=color.get(pos);
                pos++;
            }

        }
    }
    private void enregistrerScore(){
        String sco;
        sco=txt_score.getText().toString();

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        int d=1;

        switch(difficulte){
            case 1:
                d=1;
                break;
            case 2:
                d=2;
                break;
            case 3:
                d=3;
                break;
            case 4:
                d=4;
                break;
            case 5:
                d=5;
                break;
            default:
        }
        String comp=prefs.getString("score"+d,"");
        double compT=Double.parseDouble(comp);
        if(score_final>compT) {
            edit=prefs.edit();
            edit.putString("score" + d, sco);
            edit.commit();
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        enregistrerScore();
    }
}
