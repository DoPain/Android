package com.example.dmorax.tachesasynchrones;

import android.app.Activity;
import android.graphics.Region;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {

    Button aff ;
    TextView met;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aff = (Button) findViewById(R.id.buttonAfficher);
        met = (TextView) findViewById(R.id.textMeteo);
        edit = (EditText) findViewById(R.id.editNomVille);


        aff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=7406e2aebc924fee9ca84039192102&q=" + edit.getText().toString() + "&num_of_days=2&tp=3&format=json";
                GetData gt = new GetData();
                try {
                    String jsonData = gt.execute(s).get();
                    JSONObject data = new JSONObject(jsonData).getJSONObject("data");
                    JSONObject currentCondition = data.getJSONArray("current_condition").getJSONObject(0);
                    JSONObject tommorowCondition = data.getJSONArray("weather").getJSONObject(1);
                    JSONObject weatherDesc = data.getJSONArray("current_condition").getJSONObject(0).getJSONArray("weatherDesc").getJSONObject(0);
                    JSONObject location = data.getJSONArray("request").getJSONObject(0);

                    met.setText("Localisation : "+ location.getString("query") + "\n" + "\n"
                              +"Aujourd'hui : " + "\n" +" - Température : " + currentCondition.getString("temp_C") + "°C" + "\n"
                              +" - Humidité : " + currentCondition.getString("humidity") + "%" +"\n"
                              +" - Heure d'observation : " + currentCondition.getString("observation_time") + "\n"
                              +" - Description : " + weatherDesc.getString("value") + "\n" + "\n"
                              +"Demain : " + "\n"
                              +" - Température maximale : " + tommorowCondition.getString("maxtempC") + "°C" + "\n"
                              +" - Température minimale : " + tommorowCondition.getString("mintempC") + "°C" + "\n");

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
