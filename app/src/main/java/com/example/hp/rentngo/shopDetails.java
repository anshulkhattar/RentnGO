package com.example.hp.rentngo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class shopDetails extends AppCompatActivity {
    EditText sname=(EditText)findViewById(R.id.name);
    EditText vnum=(EditText)findViewById(R.id.num);
    EditText avgrate=(EditText)findViewById(R.id.rate);
    Button submit=(Button)findViewById(R.id.submit);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }
    public void sendMail(){
        String emailAddress="anshul070300@gmail.com";
        String subject="Add my shop";
        String shopname=sname.getText().toString();
        String vehiclenum=vnum.getText().toString();
        String averagerate=avgrate.getText().toString();

        String details=shopname+"\n"+vehiclenum+"\n"+averagerate;

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,emailAddress);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,details);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email app"));
    }
}
