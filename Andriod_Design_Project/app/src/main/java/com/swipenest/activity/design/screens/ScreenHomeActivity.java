package com.swipenest.activity.design.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.swipenest.R;
import com.swipenest.activity.design.fragments.adapters.AdapterHomeBase;
import com.swipenest.constants.ProjectConstant;
import com.swipenest.utils.SwipeScreen;

public class ScreenHomeActivity extends AppCompatActivity implements View.OnClickListener, ProjectConstant {

    /*ScrollView scrollView;*/
    String swipeHomeBaseFlag = FLAG_IMAGE;
    TextView applicationNameText;
    LinearLayout homeLayoutFooterId;
    SwitchCompat switcherHeaderId;
    SwitchCompat switcherBodyId;
    ScrollView homeBaseScrollViewId;
    /* RelativeLayout homeScreenStoriesParentId;*/

    SwipeScreen homeBaseViewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_home);
        applicationNameText = findViewById(R.id.applicationNameText);
        homeLayoutFooterId = findViewById(R.id.homeLayoutFooterId);
        switcherHeaderId = findViewById(R.id.switcherHeaderId);
        /*switcherBodyId = findViewById(R.id.switcherBodyId);*/
        switcherHeaderId.setTextOn("Videos");
        switcherHeaderId.setTextOff("Images");
        homeBaseViewPage = findViewById(R.id.homeBaseViewPagerId);
        AdapterHomeBase adapterHomeBase = new AdapterHomeBase(getSupportFragmentManager(), 1);
        homeBaseViewPage.setAdapter(adapterHomeBase);
        homeBaseViewPage.setCurrentItem(0);

       /* switcherHeaderId.setOnClickListener(this);
        switcherBodyId.setOnClickListener(this);
        homeLayoutFooterId.setOnClickListener(this);*/

       /* homeBaseScrollViewId = findViewById(R.id.homeBaseScrollViewId);

        homeBaseScrollViewId.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (homeBaseScrollViewId.getChildAt(0).getBottom() <= (homeBaseScrollViewId.getHeight() + homeBaseScrollViewId.getScrollY())) {
                    applicationNameText.setText("First Condition " + homeBaseScrollViewId.getScrollY());
                } else {
                    applicationNameText.setText("Second Condition " +homeBaseScrollViewId.getScrollY());
                }
            }
        });*/
    }

    @Override
    public void onClick(View v) {

        /*if( v.getId() == homeLayoutFooterId.getId() ) {
            Toast.makeText(getApplicationContext(), applicationNameText.getText(), Toast.LENGTH_SHORT);
        } else if( v.getId() == switcherHeaderId.getId() || v.getId() == switcherBodyId.getId()) {
            if( swipeHomeBaseFlag.equalsIgnoreCase(FLAG_IMAGE)  ) {
                swipeHomeBaseFlag = FLAG_VIDEO;
                homeBaseViewPage.setCurrentItem(1);
            } else {
                swipeHomeBaseFlag = FLAG_IMAGE;
                homeBaseViewPage.setCurrentItem(0);
            }

            if( v.getId() == switcherHeaderId.getId() ) {
                if( switcherHeaderId.isChecked() ) {
                    switcherBodyId.setChecked(CHECKED_TRUE);
                } else {
                    switcherBodyId.setChecked(CHECKED_FALSE);
                }
            } else if( v.getId() == switcherBodyId.getId() ) {
                if( switcherBodyId.isChecked() ) {
                    switcherHeaderId.setChecked(CHECKED_TRUE);
                } else {
                    switcherHeaderId.setChecked(CHECKED_FALSE);
                }
            }
        }*/

    }

}