package com.swipenest.activity.design.reg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.swipenest.R;
import com.swipenest.activity.design.login.LoginActivity;

public class UserCreationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText password, cPassword;
    boolean passwordFlag = false, cPasswordFlag = false;
    ImageView imgShowPass, imgShowConfirmPass;
    Button btnCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user_creation);

        password = findViewById(R.id.password);
        cPassword = findViewById(R.id.confirmPassword);
        imgShowPass = findViewById(R.id.show_pass_btn);
        imgShowConfirmPass = findViewById(R.id.show_confirm_pass_btn);
        btnCreateUser = findViewById(R.id.btnCreateUser);

        imgShowPass.setOnClickListener(this);
        imgShowConfirmPass.setOnClickListener(this);
        btnCreateUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if( v.getId() == R.id.show_pass_btn ) {
            if( !passwordFlag ) {
                passwordFlag = !passwordFlag;
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                Toast.makeText(getApplicationContext(),"show", Toast.LENGTH_SHORT).show();
            } else {
                passwordFlag = !passwordFlag;
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            password.setSelection(password.getText().toString().length());
        } else if ( v.getId() == R.id.show_confirm_pass_btn ) {
            if( !cPasswordFlag ) {
                cPasswordFlag = !cPasswordFlag;
                cPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                cPasswordFlag = !cPasswordFlag;
                cPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            cPassword.setSelection(cPassword.getText().toString().length());
        } else if( v.getId() == btnCreateUser.getId() ) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int[] sourceCoordinates = new int[2];
            v.getLocationOnScreen(sourceCoordinates);
            float x = ev.getRawX() + v.getLeft() - sourceCoordinates[0];
            float y = ev.getRawY() + v.getTop() - sourceCoordinates[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom()) {
                hideKeyboard(this);
            }

        }
        return super.dispatchTouchEvent(ev);
    }

    private void hideKeyboard(UserCreationActivity activity) {
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().getDecorView();
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }
}