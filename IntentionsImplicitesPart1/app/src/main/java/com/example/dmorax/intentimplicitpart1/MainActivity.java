package com.example.dmorax.intentimplicitpart1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    Button sms;
    Button mms;
    Button appel;
    Button web;
    Button map;

    EditText phoneN;
    EditText urlWebSite;
    EditText longi;
    EditText lat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sms = (Button) findViewById(R.id.buttonSms);
        mms = (Button) findViewById(R.id.buttonMms);
        appel = (Button) findViewById(R.id.buttonAppel);
        web = (Button) findViewById(R.id.buttonWeb);
        map = (Button) findViewById(R.id.buttonMap);

        phoneN = (EditText) findViewById(R.id.editPhone);
        urlWebSite = (EditText) findViewById(R.id.editUrl);
        longi = (EditText) findViewById(R.id.editLongitude);
        lat = (EditText) findViewById(R.id.editLatitude);

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
        Uri smsU = Uri.parse("smsto:"+ phoneN.getText().toString()) ;
        Intent i = new Intent(Intent.ACTION_SENDTO,smsU) ;
        i.putExtra("sms_body","Enter your sms here..");
        startActivity(i);
        finish();
    }

    public void onClickButtonMms(){
        Uri smsU = Uri.parse("smsto:"+phoneN.getText().toString()) ;
        Intent i = new Intent(Intent.ACTION_SENDTO,smsU) ;
        i.putExtra("sms_body","Put your image here..");
        startActivity(i);
        finish();
    }

    public void onClickButtonCall(){
        Uri call = Uri.parse("tel:" + phoneN.getText().toString()) ;
        Intent intention = new Intent(Intent.ACTION_DIAL,call) ;
        startActivity(intention);
        finish();
    }

    public void onClickButtonWeb(){
        String url = urlWebSite.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        finish();
    }

    public void onClickButtonMap(){
        Uri loc = Uri.parse("geo:" + lat.getText().toString() +","+ longi.getText().toString()) ;
        Intent i = new Intent(Intent.ACTION_VIEW,loc) ;
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
        finish();
    }
}
