package com.example.elearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText signUpEmail, signUpPassword, signupRegistration, signUpName;
    private Button signUpButtom;
    private TextView loginRedirecttext;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        signUpEmail = findViewById(R.id.signup_email);
        signUpName = findViewById(R.id.signup_name);
        signupRegistration = findViewById(R.id.signup_registrationNo);
        signUpPassword = findViewById(R.id.signup_password);
        loginRedirecttext = findViewById(R.id.login_text);
        signUpButtom = findViewById(R.id.signup_button);

        signUpButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = signUpEmail.getText().toString().trim();
                String name = signUpName.getText().toString().trim();
                String regno = signupRegistration.getText().toString().trim();
                String password = signUpPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    signUpEmail.setError("Email Cannot be empty");
                }
                if (name.isEmpty()) {
                    signUpName.setError("Name Cannot Be empty");
                }
                if (regno.isEmpty()) {
                    signupRegistration.setError("Regno Cannot be Empty");
                }
                if (password.isEmpty()) {
                    signUpPassword.setError("Password Cannot be Empty");
                } else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                                   @Override
                                                                                                   public void onComplete(@NonNull Task<AuthResult> task) {
                                                                                                       if (task.isSuccessful()) {
                                                                                                           Toast.makeText(SignUp.this, "Succesfully Registered", Toast.LENGTH_LONG).show();
                                                                                                           startActivity(new Intent(SignUp.this, login.class));

                                                                                                       } else {
                                                                                                           Toast.makeText(SignUp.this, "Sign Up failed " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                                                                                       }
                                                                                                   }
                                                                                               }
                    );
                }

            }
        });
        loginRedirecttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, login.class));
            }
        });
    }
}