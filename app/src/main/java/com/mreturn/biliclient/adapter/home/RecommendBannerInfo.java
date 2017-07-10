package com.mreturn.biliclient.adapter.home;

import com.mreturn.biliclient.widget.banner.BannerBean;

import java.util.List;

/**
 * 首页Banner推荐
 */

public class RecommendBannerInfo {

  private int code;

  private List<BannerBean> data;


  public int getCode() {

    return code;
  }


  public void setCode(int code) {

    this.code = code;
  }


  public List<BannerBean> getData() {

    return data;
  }


  public void setData(List<BannerBean> data) {

    this.data = data;
  }


}
