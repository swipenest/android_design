package com.swipenest.activity.design.reg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.swipenest.R;

public class DobActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDobNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_dob);
        btnDobNext = findViewById(R.id.btnDobNext);
        btnDobNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if( v.getId() == btnDobNext.getId() ) {
            startActivity(new Intent(this, UserCreationActivity.class));
        }
    }
}