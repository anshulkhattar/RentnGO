package com.example.hp.rentngo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button rentyourself=(Button)findViewById(R.id.rentYourself);
    Button rentyourride=(Button)findViewById(R.id.rentYourRide);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rentyourself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,UserLogin.class);
                startActivity(i);

            }
        });
        rentyourride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,OwnerLogin.class);
                startActivity(i);
            }
        });
    }
}
