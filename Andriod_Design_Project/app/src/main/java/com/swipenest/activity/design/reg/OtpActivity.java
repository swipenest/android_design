package com.swipenest.activity.design.reg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.swipenest.R;
import com.swipenest.constants.ProjectConstant;

public class OtpActivity extends AppCompatActivity implements View.OnKeyListener, View.OnClickListener, ProjectConstant {

    private EditText otpText1, otpText2, otpText3, otpText4, otpText5;
    private Button confirmOtp;
    private TextView resendOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_otp);

        otpText1 = findViewById(R.id.otpBox1);
        otpText2 = findViewById(R.id.otpBox2);
        otpText3 = findViewById(R.id.otpBox3);
        otpText4 = findViewById(R.id.otpBox4);
        otpText5 = findViewById(R.id.otpBox5);

        resendOtp = findViewById(R.id.resendOtp);
        resendOtp.setOnClickListener(this);

        confirmOtp = findViewById(R.id.confirmOtp);
        confirmOtp.setOnClickListener(this);

        otpText1.setOnKeyListener((View.OnKeyListener) this);
        otpText2.setOnKeyListener((View.OnKeyListener) this);
        otpText3.setOnKeyListener((View.OnKeyListener) this);
        otpText4.setOnKeyListener((View.OnKeyListener) this);
        otpText5.setOnKeyListener((View.OnKeyListener) this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirmOtp:
                Toast.makeText(getApplicationContext(),"confirm otp",Toast.LENGTH_SHORT).show();
                loadPersonalInfoScreen();
                break;
            case R.id.resendOtp:
                clearOtpEntry();
                break;
            default:
                break;
        }
    }

    private void clearOtpEntry() {
        Toast.makeText(getApplicationContext(),"OTP Regenerated Successfully!!",Toast.LENGTH_SHORT).show();
        otpText1.getText().clear();
        otpText2.getText().clear();
        otpText3.getText().clear();
        otpText4.getText().clear();
        otpText5.getText().clear();
        otpText1.requestFocus();
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        EditText otpText = (EditText) v;
        String txt = String.valueOf(keyCode);

        if( (keyCode >= 7 && keyCode <= 16) ) {
            if( otpText.getId() == otpText1.getId() && !otpText1.getText().toString().equalsIgnoreCase(BLANK_STRING) ) {
                otpText2.requestFocus();
            } else if( otpText.getId() == otpText2.getId() && !otpText2.getText().toString().equalsIgnoreCase(BLANK_STRING) ) {
                otpText3.requestFocus();
            } else if( otpText.getId() == otpText3.getId() && !otpText3.getText().toString().equalsIgnoreCase(BLANK_STRING) ) {
                otpText4.requestFocus();
            } else if( otpText.getId() == otpText4.getId() && !otpText4.getText().toString().equalsIgnoreCase(BLANK_STRING) ) {
                otpText5.requestFocus();
            }
            return false;
        } else if ( keyCode == KeyEvent.KEYCODE_DEL ){
            return false;
        } else {
            return true;
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

    private void hideKeyboard(OtpActivity activity) {
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().getDecorView();
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }

    private void loadPersonalInfoScreen() {
        Intent regIntent = new Intent(this, PersonalInfo.class);
        startActivity(regIntent);
    }
}