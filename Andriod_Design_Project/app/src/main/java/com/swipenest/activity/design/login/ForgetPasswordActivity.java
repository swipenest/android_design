package com.swipenest.activity.design.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.swipenest.R;

public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    Button brnFotgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forget_password);
        brnFotgetPassword = findViewById(R.id.brnFotgetPassword);
        brnFotgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if( v.getId() == brnFotgetPassword.getId() ) {
            startActivity(new Intent(this, LoginConfirmOtp.class));
        }
    }
}