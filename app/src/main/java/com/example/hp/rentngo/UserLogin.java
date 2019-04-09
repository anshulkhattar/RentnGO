package com.example.hp.rentngo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLogin extends AppCompatActivity {
    private EditText email,password;
    private Button login;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


            email=(EditText)findViewById(R.id.email);
            password=(EditText)findViewById(R.id.password);
            login=(Button)findViewById(R.id.login);
            FirebaseApp.initializeApp(this);
            firebaseAuth= FirebaseAuth.getInstance();
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validate()) {
                        String user_email = email.getText().toString().trim();
                        String user_password = password.getText().toString().trim();
                        firebaseAuth.signInWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(UserLogin.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(UserLogin.this, shopsList.class));
                                } else {
                                    Toast.makeText(UserLogin.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        Toast.makeText(UserLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        public boolean validate()
        {
            Boolean result=false;

            String Useremail=email.getText().toString();
            String Userpass=email.getText().toString();

            if(Useremail.isEmpty() || Userpass.isEmpty() )
            {
                Toast.makeText(this,"Invalid input",Toast.LENGTH_SHORT).show();
            }
            else
                result=true;

            return result;
        }
    }

