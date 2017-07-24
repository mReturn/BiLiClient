package com.mreturn.biliclient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/5.
 */

public class CommonFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {


    private List<Fragment> fragments;

    public CommonFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
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
