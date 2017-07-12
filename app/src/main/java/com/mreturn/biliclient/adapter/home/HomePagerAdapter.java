package com.mreturn.biliclient.adapter.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.ui.Home.HomeBangumiFragment;
import com.mreturn.biliclient.ui.Home.HomeLiveFragment;
import com.mreturn.biliclient.ui.Home.HomeRecommendFragment;
import com.mreturn.biliclient.ui.Home.HomeRegionFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/5.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private String[] titles;

    private List<Fragment> fragments;

    public HomePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        titles = context.getResources().getStringArray(R.array.sections);
        fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            switch (i){
                case 1:
                    fragments.add(new HomeRecommendFragment());
                    break;
                case 2:
                    fragments.add(new HomeBangumiFragment());
                    break;
                case 3:
                    fragments.add(new HomeRegionFragment());
                    break;
                default:
                    fragments.add(new HomeLiveFragment());
                    break;
            }
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
