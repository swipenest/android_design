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

import com.swipenest.R;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtResetPassword, txtResetConfirmPassword;
    boolean passwordFlag = false, cPasswordFlag = false;
    ImageView show_txt_reset_pass_btn, show_txt_confirm_reset_pass_btn;
    Button btnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reset_password);

        txtResetPassword = findViewById(R.id.txtResetPassword);
        txtResetConfirmPassword = findViewById(R.id.txtResetConfirmPassword);
        show_txt_reset_pass_btn = findViewById(R.id.show_txt_reset_pass_btn);
        show_txt_confirm_reset_pass_btn = findViewById(R.id.show_txt_confirm_reset_pass_btn);
        btnResetPassword = findViewById(R.id.btnResetPassword);

        btnResetPassword.setOnClickListener(this);
        show_txt_reset_pass_btn.setOnClickListener(this);
        show_txt_confirm_reset_pass_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if( v.getId() == show_txt_reset_pass_btn.getId()) {
            if( !passwordFlag ) {
                passwordFlag = !passwordFlag;
                txtResetPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                passwordFlag = !passwordFlag;
                txtResetPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            txtResetPassword.setSelection(txtResetPassword.getText().toString().length());
        } else if ( v.getId() == show_txt_confirm_reset_pass_btn.getId()) {
            if( !cPasswordFlag ) {
                cPasswordFlag = !cPasswordFlag;
                txtResetConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                cPasswordFlag = !cPasswordFlag;
                txtResetConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            txtResetConfirmPassword.setSelection(txtResetConfirmPassword.getText().toString().length());
        } else if( v.getId() == btnResetPassword.getId() ) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}