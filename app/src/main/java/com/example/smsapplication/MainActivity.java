package com.example.smsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
    }
    public void sendSMS(View view){

        MapsActivity m =new MapsActivity();
        Double lat=m.latitude();
        Double longitude=m.longitude();
        String latitude=lat.toString();
        String longti=longitude.toString();
        String mobileNo="0787609563";
        String message="hi i'm thuva and location : latitude- "+latitude+", longtitude -" +longti;
        try{
            if(!mobileNo.equals("") && !message.equals("")){
                SmsManager smgr = SmsManager.getDefault();
                smgr.sendTextMessage(mobileNo,null,message,null,null);
                Toast.makeText(getApplicationContext(),"SMS Sent to "+mobileNo,Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"SMS Sending Failed",Toast.LENGTH_LONG).show();
        }
    }


}

