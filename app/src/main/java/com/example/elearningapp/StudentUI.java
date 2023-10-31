package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class StudentUI extends AppCompatActivity {

    LinearLayout llSubject;
    ConstraintLayout clSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_ui);
        llSubject = findViewById(R.id.llSubject);
        clSubject = findViewById(R.id.clSubject);

        clSubject.setOnClickListener(
                view ->{
                    llSubject.setVisibility(View.VISIBLE);
                }
        );
    }
}