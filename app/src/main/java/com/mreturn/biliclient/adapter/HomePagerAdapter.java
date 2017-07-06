package com.mreturn.biliclient.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.ui.Home.HomeLiveFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/5.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private String [] titles;

    private List<Fragment> fragments;

    public HomePagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        titles = context.getResources().getStringArray(R.array.sections);
        fragments = new ArrayList<>();
        for (int i = 0 ;i<titles.length;i++){
            fragments.add(new HomeLiveFragment());
        }
    }



    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
