package com.swipenest.activity.design.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.swipenest.R;
import com.swipenest.activity.design.reg.MainActivity;
import com.swipenest.activity.design.reg.PersonalInfo;
import com.swipenest.activity.design.screens.ScreenHomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText loginUsername, loginPassword;
    Button btnLoginSignIn;
    TextView txtLoginForgetPassword, txtLoginRegister;
    ImageView login_show_pass_btn;
    boolean passwordFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);
        txtLoginForgetPassword = findViewById(R.id.txtLoginForgetPassword);
        txtLoginRegister = findViewById(R.id.txtLoginRegister);
        btnLoginSignIn = findViewById(R.id.btnLoginSignIn);
        login_show_pass_btn = findViewById(R.id.login_show_pass_btn);

        txtLoginForgetPassword.setOnClickListener(this);
        txtLoginRegister.setOnClickListener(this);
        btnLoginSignIn.setOnClickListener(this);
        login_show_pass_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if( v.getId() == txtLoginForgetPassword.getId()) {
            startActivity( new Intent(this, ForgetPasswordActivity.class));
        } else if ( v.getId() == login_show_pass_btn.getId() ) {
            if( !passwordFlag ) {
                passwordFlag = !passwordFlag;
                loginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                Toast.makeText(getApplicationContext(),"show", Toast.LENGTH_SHORT).show();
            } else {
                passwordFlag = !passwordFlag;
                loginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            loginPassword.setSelection(loginPassword.getText().toString().length());

        } else if( v.getId() == btnLoginSignIn.getId() ) {
            startActivity( new Intent(this, ScreenHomeActivity.class));
        } else if( v.getId() == txtLoginRegister.getId() ) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}