package com.ambisave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sendBtn;
    EditText txtphoneNo;
    EditText txtMessage;
    Button clearBtn;
    Button mapBtn;
    //TextView Txt;
    Button ALERT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button) findViewById(R.id.btnSendSMS);
        txtphoneNo = (EditText) findViewById(R.id.editText);
        txtMessage = (EditText) findViewById(R.id.editText2);
        clearBtn = (Button) findViewById(R.id.btnClearSMS);
        mapBtn = (Button) findViewById(R.id.btnMaps);
        ALERT=(Button) findViewById(R.id.ALERT);
       // Txt=(TextView) findViewById(R.id.textView3);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
                txtMessage.setText("");
                txtphoneNo.setText("");
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v2) {

                txtMessage.setText("");
                txtphoneNo.setText("");


            }
        });
        mapBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v3) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        ALERT.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v4) {
                sendSMSMessage1();
            }
        });
    }

    public void  sendSMSMessage1() {
        Log.i("ACK SENT", "");
        String phoneNo1 = txtphoneNo.getText().toString();
        String message1 ="Will be in 5 mins";

        try {
            SmsManager smsManager1 = SmsManager.getDefault();
            smsManager1.sendTextMessage(phoneNo1, null, message1, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG);
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Please Enter The Details.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        String phoneNo = txtphoneNo.getText().toString();
        String message = txtMessage.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Please Enter The Details.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}