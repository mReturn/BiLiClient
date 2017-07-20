package com.mreturn.biliclient.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mReturn
 * on 2017/7/20.
 */

public class UserArchiveInfo implements Parcelable{

    /**
     * code : 0
     * data : {"count":56,"item":[{"cover":"http://i0.hdslb.com/bfs/archive/c4bcec0eab6d7f7a78e171e8e9c382d2bc1ae4b0.jpg","ctime":1497428021,"danmaku":496,"duration":182,"goto":"av","param":"9270468","play":61187,"title":"【热碱实验】将一条蓝白胖次放入热碱溶液中会怎样？","uri":"bilibili://video/9270468"},{"cover":"http://i0.hdslb.com/bfs/archive/d7a2275d1119272f13ed1c36beb59e50806d44bd.jpg","ctime":1497428021,"danmaku":1194,"duration":98,"goto":"av","param":"9162312","play":337996,"title":"【热碱实验】将一条鱼放入热碱溶液中会怎样？","uri":"bilibili://video/9162312"},{"cover":"http://i2.hdslb.com/bfs/archive/c0a70085c9c5336a1566711ca73d27eb4522f50f.jpg","ctime":1497428021,"danmaku":722,"duration":169,"goto":"av","param":"9051945","play":77380,"title":"见过喂蛇吃乳鼠，那你见过喂蛇吃乳猪么？","uri":"bilibili://video/9051945"},{"cover":"http://i1.hdslb.com/bfs/archive/b21fda930a605f54e44cd423d2baa2765d61bb94.jpg","ctime":1497428021,"danmaku":202,"duration":398,"goto":"av","param":"8850240","play":14672,"title":"神奇香蕉水，把泡沫变成了精华！","uri":"bilibili://video/8850240"},{"cover":"http://i2.hdslb.com/bfs/archive/85b2855a36fee1a0ad240db752f90965f1a2c81e.jpg","ctime":1497428021,"danmaku":3892,"duration":540,"goto":"av","param":"8417698","play":186157,"title":"【Taxidermy】有史以来制作最失败的二十个标本","uri":"bilibili://video/8417698"},{"cover":"http://i0.hdslb.com/bfs/archive/b4efb4918517ae07b21c7daa931fff0f11df470e.jpg","ctime":1497428021,"danmaku":104,"duration":187,"goto":"av","param":"8376525","play":28393,"title":"看完这个视频再也不敢忘记给主子掏耳朵了！","uri":"bilibili://video/8376525"},{"cover":"http://i1.hdslb.com/bfs/archive/919beeaa9fce760981afa2193349f013c70481ca.jpg","ctime":1497428021,"danmaku":578,"duration":670,"goto":"av","param":"7953809","play":24562,"title":"听说王者蜥很炫酷，那我们就愉快的解剖它吧！","uri":"bilibili://video/7953809"},{"cover":"http://i0.hdslb.com/bfs/archive/e0508493a07df3217204f99b559dd808488524f8.jpg","ctime":1497428021,"danmaku":101,"duration":106,"goto":"av","param":"7806885","play":9858,"title":"鸡年教你用鸡蛋画画吧","uri":"bilibili://video/7806885"},{"cover":"http://i1.hdslb.com/bfs/archive/8ba5f78de7f5b4772817a5397f82a4839897b137.jpg","ctime":1497428021,"danmaku":160,"duration":214,"goto":"av","param":"7617074","play":13864,"title":"变色龙是怎样射出舌头的？标本师带你解剖变色龙","uri":"bilibili://video/7617074"},{"cover":"http://i1.hdslb.com/bfs/archive/e53d4bb7e80c59d3f3ad8495b4b8bdf2fb3df13e.jpg","ctime":1497428021,"danmaku":484,"duration":480,"goto":"av","param":"7587318","play":19376,"title":"你男神的头骨标本是如何制作的","uri":"bilibili://video/7587318"}]}
     * message :
     * ttl : 1
     */

    private int code;
    private UserInfo.DataBean.ArchiveBean data;
    private String message;
    private int ttl;

    protected UserArchiveInfo(Parcel in) {
        code = in.readInt();
        data = in.readParcelable(UserInfo.DataBean.ArchiveBean.class.getClassLoader());
        message = in.readString();
        ttl = in.readInt();
    }

    public static final Creator<UserArchiveInfo> CREATOR = new Creator<UserArchiveInfo>() {
        @Override
        public UserArchiveInfo createFromParcel(Parcel in) {
            return new UserArchiveInfo(in);
        }

        @Override
        public UserArchiveInfo[] newArray(int size) {
            return new UserArchiveInfo[size];
        }
    };

    public UserInfo.DataBean.ArchiveBean getData() {
        return data;
    }

    public void setData(UserInfo.DataBean.ArchiveBean data) {
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
