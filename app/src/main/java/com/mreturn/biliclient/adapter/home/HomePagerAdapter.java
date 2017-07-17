package com.mreturn.biliclient.adapter.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.ui.Home.HomeBangumiFragment;
import com.mreturn.biliclient.ui.Home.HomeDiscoverFragment;
import com.mreturn.biliclient.ui.Home.HomeLiveFragment;
import com.mreturn.biliclient.ui.Home.HomeRecommendFragment;
import com.mreturn.biliclient.ui.Home.HomeRegionFragment;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/5.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private String[] titles;

    private List<Fragment> fragments;
    private Fragment[] mFragments;

    public HomePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        titles = context.getResources().getStringArray(R.array.sections);
        mFragments = new Fragment[titles.length];

//        fragments = new ArrayList<>();
//        for (int i = 0; i < titles.length; i++) {
//            switch (i){
//                case 1:
//                    fragments.add(new HomeRecommendFragment());
//                    break;
//                case 2:
//                    fragments.add(new HomeBangumiFragment());
//                    break;
//                case 3:
//                    fragments.add(new HomeRegionFragment());
//                    break;
//                default:
//                    fragments.add(new HomeDiscoverFragment());
//                    break;
//            }
//        }
    }


    @Override
    public Fragment getItem(int position) {
        if (mFragments[position] == null) {
            switch (position) {
                case 0:
                    mFragments[position] = new HomeLiveFragment();
                    break;
                case 1:
                    mFragments[position] = new HomeRecommendFragment();
                    break;
                case 2:
                    mFragments[position] = new HomeBangumiFragment();
                    break;
                case 3:
                    mFragments[position] = new HomeRegionFragment();
                    break;
                case 4:
                    mFragments[position] = new HomeDiscoverFragment();
                    break;
                default:
                    break;
            }
        }
        return mFragments[position];

//        return fragments.get(position);
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
