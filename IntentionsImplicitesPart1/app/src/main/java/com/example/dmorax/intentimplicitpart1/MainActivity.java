package com.example.dmorax.intentimplicitpart1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button sms;
    Button mms;
    Button appel;
    Button web;
    Button map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sms = (Button) findViewById(R.id.buttonSms);
        mms = (Button) findViewById(R.id.buttonMms);
        appel = (Button) findViewById(R.id.buttonAppel);
        web = (Button) findViewById(R.id.buttonWeb);
        map = (Button) findViewById(R.id.buttonMap);

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonSms();
            }
        });
        mms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(mms);
            }
        });
        appel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(appel);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(web);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(map);
            }
        });
    }

    public void onClickButton(Button b){
        System.out.println(b.getText().toString());
    }

    public void onClickButtonSms(){
        Intent intention = new Intent(Intent.ACTION_SENDTO) ;
        Uri smsU = Uri.parse("sms:06000007") ;
        intention.setData(smsU);
        startActivity(intention);
    }
}
