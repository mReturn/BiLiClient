package com.mreturn.biliclient.widget.banner;

import android.text.TextUtils;

public class BannerBean {
  private String title;
  private String img;
  private String remark;
  private String link;

  //recommend
  private String value;
  private String image;
  private int type;
  private int weight;
  private String hash;

  //bangumi
  private int id;
  private int is_ad;
  private String pub_time;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIs_ad() {
    return is_ad;
  }

  public void setIs_ad(int is_ad) {
    this.is_ad = is_ad;
  }

  public String getPub_time() {
    return pub_time;
  }

  public void setPub_time(String pub_time) {
    this.pub_time = pub_time;
  }



  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImg() {
    if (TextUtils.isEmpty(img)){
      return image;
    }
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}