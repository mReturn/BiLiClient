package com.mreturn.biliclient.widget.banner;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;

public class BannerAdapter extends PagerAdapter {

  private List<ImageView> mList;

  private int pos;

  private ViewPagerOnItemClickListener mViewPagerOnItemClickListener;


  void setmViewPagerOnItemClickListener(ViewPagerOnItemClickListener mViewPagerOnItemClickListener) {

    this.mViewPagerOnItemClickListener = mViewPagerOnItemClickListener;
  }


  BannerAdapter(List<ImageView> list) {

    this.mList = list;
  }


  @Override
  public int getCount() {
//    return mList.size()
    if (mList.size()>1){
      return Integer.MAX_VALUE;
    }else {
      return mList.size();
    }
  }


  @Override
  public boolean isViewFromObject(View arg0, Object arg1) {

    return arg0 == arg1;
  }


  @Override
  public Object instantiateItem(ViewGroup container, int position) {

    //对ViewPager页号求模取出View列表中要显示的项
    position %= mList.size();
    if (position < 0) {
      position = mList.size() + position;
    }
    ImageView v = mList.get(position);
    pos = position;
    v.setScaleType(ImageView.ScaleType.CENTER);
    //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
    ViewParent vp = v.getParent();
    if (vp != null) {
      ViewGroup parent = (ViewGroup) vp;
      parent.removeView(v);
    }
    v.setOnClickListener(v1 -> {

      if (mViewPagerOnItemClickListener != null) {
        mViewPagerOnItemClickListener.onItemClick();
      }
    });

    container.addView(v);
    return v;
  }


  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {

  }


  interface ViewPagerOnItemClickListener {

    void onItemClick();
  }
}
