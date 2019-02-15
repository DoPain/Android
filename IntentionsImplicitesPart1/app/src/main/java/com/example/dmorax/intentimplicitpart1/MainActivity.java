package com.example.dmorax.intentimplicitpart1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
                onClickButtonMms();
            }
        });
        appel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonCall();
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonWeb();
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonMap();
            }
        });
    }


    public void onClickButtonSms(){
        Uri smsU = Uri.parse("sms:06000007") ;
        Intent i = new Intent(Intent.ACTION_SENDTO,smsU) ;
        i.putExtra("sms_body","Enter your sms here..");
        startActivity(i);
        finish();
    }

    public void onClickButtonMms(){
        Uri smsU = Uri.parse("sms:06000007") ;
        Intent i = new Intent(Intent.ACTION_SENDTO,smsU) ;
        i.putExtra("sms_body","Put your image here..");
        startActivity(i);
        finish();
    }

    public void onClickButtonCall(){
        String number = "0671021541";
        Uri call = Uri.parse("tel:" + number) ;
        Intent intention = new Intent(Intent.ACTION_DIAL,call) ;
        startActivity(intention);
        finish();
    }

    public void onClickButtonWeb(){
        String url = "http://www.facebook.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        finish();
    }

    public void onClickButtonMap(){
        String location = "geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+CA+94043";
        Uri loc = Uri.parse(location) ;
        Intent i = new Intent(Intent.ACTION_VIEW,loc) ;
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
        finish();
    }
}
