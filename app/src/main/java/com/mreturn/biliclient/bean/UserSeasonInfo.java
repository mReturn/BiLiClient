package com.mreturn.biliclient.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mReturn
 * on 2017/7/20.
 */

public class UserSeasonInfo implements Parcelable{

    private int code;
    private UserInfo.DataBean.SeasonBean data;
    private String message;
    private int ttl;

    protected UserSeasonInfo(Parcel in) {
        code = in.readInt();
        data = in.readParcelable(UserInfo.DataBean.SeasonBean.class.getClassLoader());
        message = in.readString();
        ttl = in.readInt();
    }

    public static final Creator<UserSeasonInfo> CREATOR = new Creator<UserSeasonInfo>() {
        @Override
        public UserSeasonInfo createFromParcel(Parcel in) {
            return new UserSeasonInfo(in);
        }

        @Override
        public UserSeasonInfo[] newArray(int size) {
            return new UserSeasonInfo[size];
        }
    };

    public UserInfo.DataBean.SeasonBean getData() {
        return data;
    }

    public void setData(UserInfo.DataBean.SeasonBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeParcelable(data, flags);
        dest.writeString(message);
        dest.writeInt(ttl);
    }
}
