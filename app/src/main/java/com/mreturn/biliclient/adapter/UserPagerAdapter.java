package com.mreturn.biliclient.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/5.
 */

public class UserPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> fragments;

    public UserPagerAdapter(Context context, FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;

    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
