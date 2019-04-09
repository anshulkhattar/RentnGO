package com.example.hp.rentngo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class userRegister extends AppCompatActivity {
    public EditText user_email=(EditText)findViewById(R.id.email);
    public EditText user_password=(EditText)findViewById(R.id.password);
    Button signup=(Button)findViewById(R.id.signup);
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        FirebaseApp.initializeApp(this);
        mAuth= FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String email= user_email.getText().toString().trim();
                    String password=user_password.getText().toString().trim();

                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(userRegister.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(userRegister.this,UserLogin.class));
                            } else {
                                Toast.makeText(userRegister.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
    public boolean validate()
    {
        Boolean result=false;


        String Useremail=user_password.getText().toString();
        String Userpass=user_email.getText().toString();

        if(Userpass.isEmpty() || Useremail.isEmpty())
        {
            Toast.makeText(this,"Invalid input",Toast.LENGTH_SHORT).show();
        }
        else
            result=true;

        return result;
    }

}


