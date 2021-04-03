package com.swipenest.activity.design.fragments.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.swipenest.activity.design.fragments.HomeBaseImageSection;
import com.swipenest.activity.design.fragments.HomeBaseVideoSection;

public class AdapterHomeBase extends FragmentPagerAdapter {


    public AdapterHomeBase(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if( position == 0 ) {
            return new HomeBaseImageSection();
        } else {
            return new HomeBaseVideoSection();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
