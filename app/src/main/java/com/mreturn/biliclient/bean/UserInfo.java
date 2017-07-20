package com.mreturn.biliclient.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/19.
 */

public class UserInfo implements Parcelable{

    /**
     * code : 0
     * data : {"relation":-999,"setting":{"submited_video":1,"tags":1,"fav_video":1,"coins_video":1,"bangumi":1,"played_game":1,"groups":1},"card":{"mid":"682508","name":"超心塞的十六","approve":false,"sex":"保密","rank":"","face":"http://i1.hdslb.com/bfs/face/a42f5bf0c5a1db51f520b9e86fd646378f917867.jpg","DisplayRank":"","regtime":0,"spacesta":0,"birthday":"","place":"","description":"","article":0,"attentions":null,"fans":229332,"friend":0,"attention":35,"sign":"粉丝交流群：554842701直播通知群：146140572 微博：http://weibo.com/sexteen16","level_info":{"current_level":6,"current_min":28800,"current_exp":183728,"next_exp":"-"},"pendant":{"pid":0,"name":"","image":"","expire":0},"nameplate":{"nid":0,"name":"","image":"","image_small":"","level":"","condition":""},"official_verify":{"type":-1,"desc":""},"vip":{"vipType":2,"vipDueDate":1531843200000,"dueRemark":"","accessStatus":1,"vipStatus":1,"vipStatusWarn":""}},"images":{"imgUrl":""},"live":{"roomStatus":1,"liveStatus":1,"url":"http://live.bilibili.com/10313","title":"我的世界 你建我哭","cover":"http://i0.hdslb.com/bfs/live/8d879eec269c5e3b6dbd582380bbb4c92d12607b.jpg","online":44100,"roomid":10313,"roundStatus":0},"elec":{"show":false,"total":606,"count":8,"elec_num":0,"list":[{"pay_mid":1631076,"rank":1,"uname":"超爱肾的猫籍","avatar":"http://i2.hdslb.com/bfs/face/cef0542db5cf4a0874e842911014dc20f641368a.jpg"},{"pay_mid":107647014,"rank":2,"uname":"琴梨酱のかれし","avatar":"http://i1.hdslb.com/bfs/face/04089a8cd43bc0eb013af97e38324db1649fcd2c.jpg"},{"pay_mid":10895028,"rank":3,"uname":"超心塞的小狼","avatar":"http://i0.hdslb.com/bfs/face/d3f478ab43948cb987357824e5b141baee3e8ad1.jpg"},{"pay_mid":8097859,"rank":4,"uname":"新月觉","avatar":"http://i2.hdslb.com/bfs/face/6b9c0b072b3546d1f37f456ed4166848c97979aa.jpg"},{"pay_mid":103447526,"rank":5,"uname":"金都北苑","avatar":"http://i2.hdslb.com/bfs/face/ed2c9df24f653a59bbbff6c71afbc0505697187f.jpg"},{"pay_mid":13514198,"rank":6,"uname":"超心塞的九黎","avatar":"http://i1.hdslb.com/bfs/face/a8df1c038607ad00cfaa2689b31aa2b3483d9f28.jpg"},{"pay_mid":11746927,"rank":7,"uname":"从前有个喵叽叽","avatar":"http://i0.hdslb.com/bfs/face/dded277ba850c90b8fc392c148ca3d5bfa2516f1.jpg"},{"pay_mid":64682074,"rank":8,"uname":"尴尬R","avatar":"http://i0.hdslb.com/bfs/face/d30ce4f329de10c8ce70040a0a7ea92fed24eb94.jpg"}],"elec_set":{"elec_theme":0,"rmb_rate":10,"integrity_rate":10,"round_mode":0,"elec_list":[{"title":"20电池","elec_num":20,"is_customize":0},{"title":"60电池","elec_num":60,"is_customize":0},{"title":"450电池","elec_num":450,"is_customize":0},{"title":"880电池","elec_num":880,"is_customize":0},{"title":"自定义","elec_num":0,"is_customize":1,"min_elec":20,"max_elec":99999}]}},"archive":{"count":116,"item":[{"title":"横版守望先锋？你没看错！","cover":"http://i0.hdslb.com/bfs/archive/881c836aadaab6b5f132681ce594ce896c17c901.jpg","uri":"bilibili://video/12289892","param":"12289892","goto":"av","duration":941,"play":33934,"danmaku":367,"ctime":1500282936},{"title":"十六.《嘣战纪》131连见证奇迹的时刻。","cover":"http://i0.hdslb.com/bfs/archive/def27078a478563e5a3524ae5ddff3a3edec59dd.jpg","uri":"bilibili://video/12222408","param":"12222408","goto":"av","duration":874,"play":11655,"danmaku":286,"ctime":1500103517},{"title":"十六.七分钟教你玩懂《Bong-嘣战纪》","cover":"http://i2.hdslb.com/bfs/archive/39d749f6813b0385154edfefd6c6bb40996423e9.jpg","uri":"bilibili://video/12134093","param":"12134093","goto":"av","duration":426,"play":21604,"danmaku":181,"ctime":1499857058},{"title":"《装甲战争》游戏区UP们的疯狂打炮互gay","cover":"http://i2.hdslb.com/bfs/archive/3aedc7a684b679bc2fe4bb1fe25fcfd9ea02641b.jpg","uri":"bilibili://video/11441884","param":"11441884","goto":"av","duration":3524,"play":27535,"danmaku":155,"ctime":1497857428},{"title":"十六.《守望先锋》四分钟教你玩法鸡","cover":"http://i2.hdslb.com/bfs/archive/23277d5c986eab7ccf7cb6ff0a572f29d1ddf359.jpg","uri":"bilibili://video/11414676","param":"11414676","goto":"av","duration":264,"play":99104,"danmaku":595,"ctime":1497754803},{"title":"委屈！小学生竟然给我戴绿帽子！","cover":"http://i2.hdslb.com/bfs/archive/4f7dedd2fca7c03016b967b1e20b53d83030524a.jpg","uri":"bilibili://video/11372713","param":"11372713","goto":"av","duration":654,"play":33594,"danmaku":268,"ctime":1497609569},{"title":"【十六】雪糕歌","cover":"http://i1.hdslb.com/bfs/archive/495c0324c1f0c66c0f8c43eb40021f3670f4bdac.jpg","uri":"bilibili://video/11020891","param":"11020891","goto":"av","duration":188,"play":52165,"danmaku":855,"ctime":1497424772},{"title":"十六.【我的世界】《和风mod》半自动竹子机","cover":"http://i1.hdslb.com/bfs/archive/2bb71f07374d246cc711b558edc12d07b53c22ca.jpg","uri":"bilibili://video/10982649","param":"10982649","goto":"av","duration":526,"play":12157,"danmaku":181,"ctime":1497424772},{"title":"道德沦丧！4399下限再度突破！岛田兄弟惨遭变性！","cover":"http://i1.hdslb.com/bfs/archive/d25e4c348ae338696e1a7eadda99f0a0bd5d643e.jpg","uri":"bilibili://video/10839894","param":"10839894","goto":"av","duration":745,"play":60583,"danmaku":644,"ctime":1497424772},{"title":"【十六】你以为《汐》只是个跳跳乐？","cover":"http://i1.hdslb.com/bfs/archive/87de1d76c9de50fa273a0ba8e09215fd532a7c7e.jpg","uri":"bilibili://video/10446067","param":"10446067","goto":"av","duration":1894,"play":16293,"danmaku":326,"ctime":1497424772}]},"article":{"count":0},"favourite":{"count":2,"item":[{"fid":1827014,"mid":682508,"name":"默认收藏夹","max_count":100000,"cur_count":3,"atten_count":0,"state":0,"ctime":1438922096,"mtime":1497398043,"cover":[{"aid":7604530,"pic":"http://i1.hdslb.com/bfs/archive/f5d91dd8b54096c29799fd8563f84c7ac8c9c3c0.png"},{"aid":5848068,"pic":"http://i2.hdslb.com/bfs/archive/2d793dd068ea9cb9b73a9e49fc12940b9bfd3529.jpg"},{"aid":3685610,"pic":"http://i0.hdslb.com/bfs/archive/359f7d14832fda4da1d2778c040dfd9e3b381f24.jpg"}]},{"fid":714487,"mid":682508,"name":"收藏了个夹","max_count":999,"cur_count":9,"atten_count":0,"state":2,"ctime":1436867644,"mtime":1486640057,"cover":[{"aid":4909431,"pic":"http://i2.hdslb.com/bfs/archive/715dfedac0587f1a8c0e807d59797ae19d648d41.jpg"},{"aid":1002217,"pic":"http://i2.hdslb.com/bfs/archive/66fc6cc085d11b8cb6dff008a4a4e84542b37ba0.jpg"},{"aid":3108488,"pic":"http://i1.hdslb.com/bfs/archive/88a38fd68291d543934a2a67271159675c3e7b4a.jpg"}]}]},"season":{"count":5,"item":[{"title":"第六天魔王","cover":"http://i0.hdslb.com/bfs/bangumi/29d001c8083a224da99b72239be5680c6ac907e7.jpg","uri":"bilibili://bangumi/season/6043","param":"6043","goto":"bangumi","newest_ep_index":"17","is_started":1,"total_count":"-1","attention":"0"},{"title":"Re:CREATORS","cover":"http://i0.hdslb.com/bfs/bangumi/3944fe0b84a5763cde6b0573773b89ba86b4321d.jpg","uri":"bilibili://bangumi/season/5998","param":"5998","goto":"bangumi","newest_ep_index":"15","is_started":1,"total_count":"22","attention":"0"},{"title":"凹凸世界 第一季","cover":"http://i0.hdslb.com/bfs/bangumi/0322eb656e2d745b9cd118bbe6297b82a1b13c08.jpg","uri":"bilibili://bangumi/season/3043","param":"3043","goto":"bangumi","finish":1,"newest_ep_index":"番外","is_started":1,"total_count":"32","attention":"0"},{"title":"夏目友人帐 陆","cover":"http://i0.hdslb.com/bfs/bangumi/39716626d611a765c44ca27054f3526210c4d5cb.jpg","uri":"bilibili://bangumi/season/5977","param":"5977","goto":"bangumi","finish":1,"newest_ep_index":"11","is_started":1,"total_count":"11","attention":"0"},{"title":"全职高手","cover":"http://i0.hdslb.com/bfs/bangumi/958cffa5054239ae9695469708949de0caaeabe4.jpg","uri":"bilibili://bangumi/season/5852","param":"5852","goto":"bangumi","finish":1,"newest_ep_index":"12","is_started":1,"total_count":"12","attention":"0"}]},"coin_archive":{"count":1,"item":[{"title":"【凯玟桑】Arrow","cover":"http://i2.hdslb.com/bfs/archive/c837490efb9d702095b48c76cffd52a85a0dc9b6.png","uri":"bilibili://video/11899326","param":"11899326","goto":"av","duration":235,"play":8528,"danmaku":323,"ctime":1499220561}]},"game":{"count":5,"item":[{"id":75,"name":"仙剑奇侠传幻璃镜","icon":"http://i0.hdslb.com/bfs/game/914f8c00352afe5a2d99a62863634baf1db3d5c7.jpg","summary":"入境成妖，破界重生！","uri":"com.shangruan.huanlijing.bili"},{"id":55,"name":"阴阳师","icon":"http://i0.hdslb.com/bfs/game/36ee7db87a0d27aa5bb4672fffc22fb5ff8ec68c.png","summary":"唯美如樱，百鬼物语","uri":"com.netease.onmyoji.bili"},{"id":76,"name":"刀剑乱舞","icon":"http://i0.hdslb.com/bfs/game/2950e1d94aa49a740f0d69a6ca64d60f97b68564.png","summary":"刀剑男士，即刻出阵！","uri":"com.youzu.djlw.bili"},{"id":26,"name":"克鲁赛德战记","icon":"http://i2.hdslb.com/u_user/503113dc29417f5c53abfeb9b520dbeb.png","summary":"日式萌系像素风RPG","uri":"com.nhnst.SKCQCN.bili"},{"id":61,"name":"命运-冠位指定（Fate/GO）","icon":"http://i0.hdslb.com/bfs/game/0a114c837d9f8fae8f2489a4bf91bf912c61edae.png","summary":"全平台公测开启！","uri":"com.bilibili.fatego"}]},"community":{"count":2,"item":[{"id":863,"name":"Minecraft","desc":"众多史蒂夫在Bilibili兴趣圈的聚集地","thumb":"http://img.yo9.com/478e25e09fc511e59d8700163e00043c","post_count":696,"member_count":23395,"post_nickname":"帖子","member_nickname":"史蒂夫"},{"id":136,"name":"我的世界","desc":"《我的世界》中国版7月14日上线","thumb":"http://img.yo9.com/730e591084c611e6a2b400163e00043c","post_count":1232,"member_count":61423,"post_nickname":"方块","member_nickname":"史蒂夫"}]}}
     * message :
     * ttl : 1
     */

    private int code;
    private DataBean data;
    private String message;
    private int ttl;

    protected UserInfo(Parcel in) {
        code = in.readInt();
        message = in.readString();
        ttl = in.readInt();
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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
        dest.writeString(message);
        dest.writeInt(ttl);
    }

    public static class DataBean implements Parcelable{
        /**
         * relation : -999
         * setting : {"submited_video":1,"tags":1,"fav_video":1,"coins_video":1,"bangumi":1,"played_game":1,"groups":1}
         * card : {"mid":"682508","name":"超心塞的十六","approve":false,"sex":"保密","rank":"","face":"http://i1.hdslb.com/bfs/face/a42f5bf0c5a1db51f520b9e86fd646378f917867.jpg","DisplayRank":"","regtime":0,"spacesta":0,"birthday":"","place":"","description":"","article":0,"attentions":null,"fans":229332,"friend":0,"attention":35,"sign":"粉丝交流群：554842701直播通知群：146140572 微博：http://weibo.com/sexteen16","level_info":{"current_level":6,"current_min":28800,"current_exp":183728,"next_exp":"-"},"pendant":{"pid":0,"name":"","image":"","expire":0},"nameplate":{"nid":0,"name":"","image":"","image_small":"","level":"","condition":""},"official_verify":{"type":-1,"desc":""},"vip":{"vipType":2,"vipDueDate":1531843200000,"dueRemark":"","accessStatus":1,"vipStatus":1,"vipStatusWarn":""}}
         * images : {"imgUrl":""}
         * live : {"roomStatus":1,"liveStatus":1,"url":"http://live.bilibili.com/10313","title":"我的世界 你建我哭","cover":"http://i0.hdslb.com/bfs/live/8d879eec269c5e3b6dbd582380bbb4c92d12607b.jpg","online":44100,"roomid":10313,"roundStatus":0}
         * elec : {"show":false,"total":606,"count":8,"elec_num":0,"list":[{"pay_mid":1631076,"rank":1,"uname":"超爱肾的猫籍","avatar":"http://i2.hdslb.com/bfs/face/cef0542db5cf4a0874e842911014dc20f641368a.jpg"},{"pay_mid":107647014,"rank":2,"uname":"琴梨酱のかれし","avatar":"http://i1.hdslb.com/bfs/face/04089a8cd43bc0eb013af97e38324db1649fcd2c.jpg"},{"pay_mid":10895028,"rank":3,"uname":"超心塞的小狼","avatar":"http://i0.hdslb.com/bfs/face/d3f478ab43948cb987357824e5b141baee3e8ad1.jpg"},{"pay_mid":8097859,"rank":4,"uname":"新月觉","avatar":"http://i2.hdslb.com/bfs/face/6b9c0b072b3546d1f37f456ed4166848c97979aa.jpg"},{"pay_mid":103447526,"rank":5,"uname":"金都北苑","avatar":"http://i2.hdslb.com/bfs/face/ed2c9df24f653a59bbbff6c71afbc0505697187f.jpg"},{"pay_mid":13514198,"rank":6,"uname":"超心塞的九黎","avatar":"http://i1.hdslb.com/bfs/face/a8df1c038607ad00cfaa2689b31aa2b3483d9f28.jpg"},{"pay_mid":11746927,"rank":7,"uname":"从前有个喵叽叽","avatar":"http://i0.hdslb.com/bfs/face/dded277ba850c90b8fc392c148ca3d5bfa2516f1.jpg"},{"pay_mid":64682074,"rank":8,"uname":"尴尬R","avatar":"http://i0.hdslb.com/bfs/face/d30ce4f329de10c8ce70040a0a7ea92fed24eb94.jpg"}],"elec_set":{"elec_theme":0,"rmb_rate":10,"integrity_rate":10,"round_mode":0,"elec_list":[{"title":"20电池","elec_num":20,"is_customize":0},{"title":"60电池","elec_num":60,"is_customize":0},{"title":"450电池","elec_num":450,"is_customize":0},{"title":"880电池","elec_num":880,"is_customize":0},{"title":"自定义","elec_num":0,"is_customize":1,"min_elec":20,"max_elec":99999}]}}
         * archive : {"count":116,"item":[{"title":"横版守望先锋？你没看错！","cover":"http://i0.hdslb.com/bfs/archive/881c836aadaab6b5f132681ce594ce896c17c901.jpg","uri":"bilibili://video/12289892","param":"12289892","goto":"av","duration":941,"play":33934,"danmaku":367,"ctime":1500282936},{"title":"十六.《嘣战纪》131连见证奇迹的时刻。","cover":"http://i0.hdslb.com/bfs/archive/def27078a478563e5a3524ae5ddff3a3edec59dd.jpg","uri":"bilibili://video/12222408","param":"12222408","goto":"av","duration":874,"play":11655,"danmaku":286,"ctime":1500103517},{"title":"十六.七分钟教你玩懂《Bong-嘣战纪》","cover":"http://i2.hdslb.com/bfs/archive/39d749f6813b0385154edfefd6c6bb40996423e9.jpg","uri":"bilibili://video/12134093","param":"12134093","goto":"av","duration":426,"play":21604,"danmaku":181,"ctime":1499857058},{"title":"《装甲战争》游戏区UP们的疯狂打炮互gay","cover":"http://i2.hdslb.com/bfs/archive/3aedc7a684b679bc2fe4bb1fe25fcfd9ea02641b.jpg","uri":"bilibili://video/11441884","param":"11441884","goto":"av","duration":3524,"play":27535,"danmaku":155,"ctime":1497857428},{"title":"十六.《守望先锋》四分钟教你玩法鸡","cover":"http://i2.hdslb.com/bfs/archive/23277d5c986eab7ccf7cb6ff0a572f29d1ddf359.jpg","uri":"bilibili://video/11414676","param":"11414676","goto":"av","duration":264,"play":99104,"danmaku":595,"ctime":1497754803},{"title":"委屈！小学生竟然给我戴绿帽子！","cover":"http://i2.hdslb.com/bfs/archive/4f7dedd2fca7c03016b967b1e20b53d83030524a.jpg","uri":"bilibili://video/11372713","param":"11372713","goto":"av","duration":654,"play":33594,"danmaku":268,"ctime":1497609569},{"title":"【十六】雪糕歌","cover":"http://i1.hdslb.com/bfs/archive/495c0324c1f0c66c0f8c43eb40021f3670f4bdac.jpg","uri":"bilibili://video/11020891","param":"11020891","goto":"av","duration":188,"play":52165,"danmaku":855,"ctime":1497424772},{"title":"十六.【我的世界】《和风mod》半自动竹子机","cover":"http://i1.hdslb.com/bfs/archive/2bb71f07374d246cc711b558edc12d07b53c22ca.jpg","uri":"bilibili://video/10982649","param":"10982649","goto":"av","duration":526,"play":12157,"danmaku":181,"ctime":1497424772},{"title":"道德沦丧！4399下限再度突破！岛田兄弟惨遭变性！","cover":"http://i1.hdslb.com/bfs/archive/d25e4c348ae338696e1a7eadda99f0a0bd5d643e.jpg","uri":"bilibili://video/10839894","param":"10839894","goto":"av","duration":745,"play":60583,"danmaku":644,"ctime":1497424772},{"title":"【十六】你以为《汐》只是个跳跳乐？","cover":"http://i1.hdslb.com/bfs/archive/87de1d76c9de50fa273a0ba8e09215fd532a7c7e.jpg","uri":"bilibili://video/10446067","param":"10446067","goto":"av","duration":1894,"play":16293,"danmaku":326,"ctime":1497424772}]}
         * article : {"count":0}
         * favourite : {"count":2,"item":[{"fid":1827014,"mid":682508,"name":"默认收藏夹","max_count":100000,"cur_count":3,"atten_count":0,"state":0,"ctime":1438922096,"mtime":1497398043,"cover":[{"aid":7604530,"pic":"http://i1.hdslb.com/bfs/archive/f5d91dd8b54096c29799fd8563f84c7ac8c9c3c0.png"},{"aid":5848068,"pic":"http://i2.hdslb.com/bfs/archive/2d793dd068ea9cb9b73a9e49fc12940b9bfd3529.jpg"},{"aid":3685610,"pic":"http://i0.hdslb.com/bfs/archive/359f7d14832fda4da1d2778c040dfd9e3b381f24.jpg"}]},{"fid":714487,"mid":682508,"name":"收藏了个夹","max_count":999,"cur_count":9,"atten_count":0,"state":2,"ctime":1436867644,"mtime":1486640057,"cover":[{"aid":4909431,"pic":"http://i2.hdslb.com/bfs/archive/715dfedac0587f1a8c0e807d59797ae19d648d41.jpg"},{"aid":1002217,"pic":"http://i2.hdslb.com/bfs/archive/66fc6cc085d11b8cb6dff008a4a4e84542b37ba0.jpg"},{"aid":3108488,"pic":"http://i1.hdslb.com/bfs/archive/88a38fd68291d543934a2a67271159675c3e7b4a.jpg"}]}]}
         * season : {"count":5,"item":[{"title":"第六天魔王","cover":"http://i0.hdslb.com/bfs/bangumi/29d001c8083a224da99b72239be5680c6ac907e7.jpg","uri":"bilibili://bangumi/season/6043","param":"6043","goto":"bangumi","newest_ep_index":"17","is_started":1,"total_count":"-1","attention":"0"},{"title":"Re:CREATORS","cover":"http://i0.hdslb.com/bfs/bangumi/3944fe0b84a5763cde6b0573773b89ba86b4321d.jpg","uri":"bilibili://bangumi/season/5998","param":"5998","goto":"bangumi","newest_ep_index":"15","is_started":1,"total_count":"22","attention":"0"},{"title":"凹凸世界 第一季","cover":"http://i0.hdslb.com/bfs/bangumi/0322eb656e2d745b9cd118bbe6297b82a1b13c08.jpg","uri":"bilibili://bangumi/season/3043","param":"3043","goto":"bangumi","finish":1,"newest_ep_index":"番外","is_started":1,"total_count":"32","attention":"0"},{"title":"夏目友人帐 陆","cover":"http://i0.hdslb.com/bfs/bangumi/39716626d611a765c44ca27054f3526210c4d5cb.jpg","uri":"bilibili://bangumi/season/5977","param":"5977","goto":"bangumi","finish":1,"newest_ep_index":"11","is_started":1,"total_count":"11","attention":"0"},{"title":"全职高手","cover":"http://i0.hdslb.com/bfs/bangumi/958cffa5054239ae9695469708949de0caaeabe4.jpg","uri":"bilibili://bangumi/season/5852","param":"5852","goto":"bangumi","finish":1,"newest_ep_index":"12","is_started":1,"total_count":"12","attention":"0"}]}
         * coin_archive : {"count":1,"item":[{"title":"【凯玟桑】Arrow","cover":"http://i2.hdslb.com/bfs/archive/c837490efb9d702095b48c76cffd52a85a0dc9b6.png","uri":"bilibili://video/11899326","param":"11899326","goto":"av","duration":235,"play":8528,"danmaku":323,"ctime":1499220561}]}
         * game : {"count":5,"item":[{"id":75,"name":"仙剑奇侠传幻璃镜","icon":"http://i0.hdslb.com/bfs/game/914f8c00352afe5a2d99a62863634baf1db3d5c7.jpg","summary":"入境成妖，破界重生！","uri":"com.shangruan.huanlijing.bili"},{"id":55,"name":"阴阳师","icon":"http://i0.hdslb.com/bfs/game/36ee7db87a0d27aa5bb4672fffc22fb5ff8ec68c.png","summary":"唯美如樱，百鬼物语","uri":"com.netease.onmyoji.bili"},{"id":76,"name":"刀剑乱舞","icon":"http://i0.hdslb.com/bfs/game/2950e1d94aa49a740f0d69a6ca64d60f97b68564.png","summary":"刀剑男士，即刻出阵！","uri":"com.youzu.djlw.bili"},{"id":26,"name":"克鲁赛德战记","icon":"http://i2.hdslb.com/u_user/503113dc29417f5c53abfeb9b520dbeb.png","summary":"日式萌系像素风RPG","uri":"com.nhnst.SKCQCN.bili"},{"id":61,"name":"命运-冠位指定（Fate/GO）","icon":"http://i0.hdslb.com/bfs/game/0a114c837d9f8fae8f2489a4bf91bf912c61edae.png","summary":"全平台公测开启！","uri":"com.bilibili.fatego"}]}
         * community : {"count":2,"item":[{"id":863,"name":"Minecraft","desc":"众多史蒂夫在Bilibili兴趣圈的聚集地","thumb":"http://img.yo9.com/478e25e09fc511e59d8700163e00043c","post_count":696,"member_count":23395,"post_nickname":"帖子","member_nickname":"史蒂夫"},{"id":136,"name":"我的世界","desc":"《我的世界》中国版7月14日上线","thumb":"http://img.yo9.com/730e591084c611e6a2b400163e00043c","post_count":1232,"member_count":61423,"post_nickname":"方块","member_nickname":"史蒂夫"}]}
         */

        private int relation;
        private SettingBean setting;
        private CardBean card;
        private ImagesBean images;
        private LiveBean live;
        private ElecBean elec;
        private ArchiveBean archive;
        private ArticleBean article;
        private FavouriteBean favourite;
        private SeasonBean season;
        private CoinArchiveBean coin_archive;
        private GameBean game;
        private CommunityBean community;

        protected DataBean(Parcel in) {
            relation = in.readInt();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public int getRelation() {
            return relation;
        }

        public void setRelation(int relation) {
            this.relation = relation;
        }

        public SettingBean getSetting() {
            return setting;
        }

        public void setSetting(SettingBean setting) {
            this.setting = setting;
        }

        public CardBean getCard() {
            return card;
        }

        public void setCard(CardBean card) {
            this.card = card;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public LiveBean getLive() {
            return live;
        }

        public void setLive(LiveBean live) {
            this.live = live;
        }

        public ElecBean getElec() {
            return elec;
        }

        public void setElec(ElecBean elec) {
            this.elec = elec;
        }

        public ArchiveBean getArchive() {
            return archive;
        }

        public void setArchive(ArchiveBean archive) {
            this.archive = archive;
        }

        public ArticleBean getArticle() {
            return article;
        }

        public void setArticle(ArticleBean article) {
            this.article = article;
        }

        public FavouriteBean getFavourite() {
            return favourite;
        }

        public void setFavourite(FavouriteBean favourite) {
            this.favourite = favourite;
        }

        public SeasonBean getSeason() {
            return season;
        }

        public void setSeason(SeasonBean season) {
            this.season = season;
        }

        public CoinArchiveBean getCoin_archive() {
            return coin_archive;
        }

        public void setCoin_archive(CoinArchiveBean coin_archive) {
            this.coin_archive = coin_archive;
        }

        public GameBean getGame() {
            return game;
        }

        public void setGame(GameBean game) {
            this.game = game;
        }

        public CommunityBean getCommunity() {
            return community;
        }

        public void setCommunity(CommunityBean community) {
            this.community = community;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(relation);
        }

        public static class SettingBean {
            /**
             * submited_video : 1
             * tags : 1
             * fav_video : 1
             * coins_video : 1
             * bangumi : 1
             * played_game : 1
             * groups : 1
             */

            private int submited_video;
            private int tags;
            private int fav_video;
            private int coins_video;
            private int bangumi;
            private int played_game;
            private int groups;

            public int getSubmited_video() {
                return submited_video;
            }

            public void setSubmited_video(int submited_video) {
                this.submited_video = submited_video;
            }

            public int getTags() {
                return tags;
            }

            public void setTags(int tags) {
                this.tags = tags;
            }

            public int getFav_video() {
                return fav_video;
            }

            public void setFav_video(int fav_video) {
                this.fav_video = fav_video;
            }

            public int getCoins_video() {
                return coins_video;
            }

            public void setCoins_video(int coins_video) {
                this.coins_video = coins_video;
            }

            public int getBangumi() {
                return bangumi;
            }

            public void setBangumi(int bangumi) {
                this.bangumi = bangumi;
            }

            public int getPlayed_game() {
                return played_game;
            }

            public void setPlayed_game(int played_game) {
                this.played_game = played_game;
            }

            public int getGroups() {
                return groups;
            }

            public void setGroups(int groups) {
                this.groups = groups;
            }
        }

        public static class CardBean {
            /**
             * mid : 682508
             * name : 超心塞的十六
             * approve : false
             * sex : 保密
             * rank :
             * face : http://i1.hdslb.com/bfs/face/a42f5bf0c5a1db51f520b9e86fd646378f917867.jpg
             * DisplayRank :
             * regtime : 0
             * spacesta : 0
             * birthday :
             * place :
             * description :
             * article : 0
             * attentions : null
             * fans : 229332
             * friend : 0
             * attention : 35
             * sign : 粉丝交流群：554842701直播通知群：146140572 微博：http://weibo.com/sexteen16
             * level_info : {"current_level":6,"current_min":28800,"current_exp":183728,"next_exp":"-"}
             * pendant : {"pid":0,"name":"","image":"","expire":0}
             * nameplate : {"nid":0,"name":"","image":"","image_small":"","level":"","condition":""}
             * official_verify : {"type":-1,"desc":""}
             * vip : {"vipType":2,"vipDueDate":1531843200000,"dueRemark":"","accessStatus":1,"vipStatus":1,"vipStatusWarn":""}
             */

            private String mid;
            private String name;
            private boolean approve;
            private String sex;
            private String rank;
            private String face;
            private String DisplayRank;
            private int regtime;
            private int spacesta;
            private String birthday;
            private String place;
            private String description;
            private int article;
            private Object attentions;
            private int fans;
            private int friend;
            private int attention;
            private String sign;
            private LevelInfoBean level_info;
            private PendantBean pendant;
            private NameplateBean nameplate;
            private OfficialVerifyBean official_verify;
            private VipBean vip;

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isApprove() {
                return approve;
            }

            public void setApprove(boolean approve) {
                this.approve = approve;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public String getDisplayRank() {
                return DisplayRank;
            }

            public void setDisplayRank(String DisplayRank) {
                this.DisplayRank = DisplayRank;
            }

            public int getRegtime() {
                return regtime;
            }

            public void setRegtime(int regtime) {
                this.regtime = regtime;
            }

            public int getSpacesta() {
                return spacesta;
            }

            public void setSpacesta(int spacesta) {
                this.spacesta = spacesta;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getPlace() {
                return place;
            }

            public void setPlace(String place) {
                this.place = place;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getArticle() {
                return article;
            }

            public void setArticle(int article) {
                this.article = article;
            }

            public Object getAttentions() {
                return attentions;
            }

            public void setAttentions(Object attentions) {
                this.attentions = attentions;
            }

            public int getFans() {
                return fans;
            }

            public void setFans(int fans) {
                this.fans = fans;
            }

            public int getFriend() {
                return friend;
            }

            public void setFriend(int friend) {
                this.friend = friend;
            }

            public int getAttention() {
                return attention;
            }

            public void setAttention(int attention) {
                this.attention = attention;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public LevelInfoBean getLevel_info() {
                return level_info;
            }

            public void setLevel_info(LevelInfoBean level_info) {
                this.level_info = level_info;
            }

            public PendantBean getPendant() {
                return pendant;
            }

            public void setPendant(PendantBean pendant) {
                this.pendant = pendant;
            }

            public NameplateBean getNameplate() {
                return nameplate;
            }

            public void setNameplate(NameplateBean nameplate) {
                this.nameplate = nameplate;
            }

            public OfficialVerifyBean getOfficial_verify() {
                return official_verify;
            }

            public void setOfficial_verify(OfficialVerifyBean official_verify) {
                this.official_verify = official_verify;
            }

            public VipBean getVip() {
                return vip;
            }

            public void setVip(VipBean vip) {
                this.vip = vip;
            }

            public static class LevelInfoBean {
                /**
                 * current_level : 6
                 * current_min : 28800
                 * current_exp : 183728
                 * next_exp : -
                 */

                private int current_level;
                private int current_min;
                private int current_exp;
                private String next_exp;

                public int getCurrent_level() {
                    return current_level;
                }

                public void setCurrent_level(int current_level) {
                    this.current_level = current_level;
                }

                public int getCurrent_min() {
                    return current_min;
                }

                public void setCurrent_min(int current_min) {
                    this.current_min = current_min;
                }

                public int getCurrent_exp() {
                    return current_exp;
                }

                public void setCurrent_exp(int current_exp) {
                    this.current_exp = current_exp;
                }

                public String getNext_exp() {
                    return next_exp;
                }

                public void setNext_exp(String next_exp) {
                    this.next_exp = next_exp;
                }
            }

            public static class PendantBean {
                /**
                 * pid : 0
                 * name :
                 * image :
                 * expire : 0
                 */

                private int pid;
                private String name;
                private String image;
                private int expire;

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public int getExpire() {
                    return expire;
                }

                public void setExpire(int expire) {
                    this.expire = expire;
                }
            }

            public static class NameplateBean {
                /**
                 * nid : 0
                 * name :
                 * image :
                 * image_small :
                 * level :
                 * condition :
                 */

                private int nid;
                private String name;
                private String image;
                private String image_small;
                private String level;
                private String condition;

                public int getNid() {
                    return nid;
                }

                public void setNid(int nid) {
                    this.nid = nid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getImage_small() {
                    return image_small;
                }

                public void setImage_small(String image_small) {
                    this.image_small = image_small;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getCondition() {
                    return condition;
                }

                public void setCondition(String condition) {
                    this.condition = condition;
                }
            }

            public static class OfficialVerifyBean {
                /**
                 * type : -1
                 * desc :
                 */

                private int type;
                private String desc;

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }

            public static class VipBean {
                /**
                 * vipType : 2
                 * vipDueDate : 1531843200000
                 * dueRemark :
                 * accessStatus : 1
                 * vipStatus : 1
                 * vipStatusWarn :
                 */

                private int vipType;
                private long vipDueDate;
                private String dueRemark;
                private int accessStatus;
                private int vipStatus;
                private String vipStatusWarn;

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }

                public long getVipDueDate() {
                    return vipDueDate;
                }

                public void setVipDueDate(long vipDueDate) {
                    this.vipDueDate = vipDueDate;
                }

                public String getDueRemark() {
                    return dueRemark;
                }

                public void setDueRemark(String dueRemark) {
                    this.dueRemark = dueRemark;
                }

                public int getAccessStatus() {
                    return accessStatus;
                }

                public void setAccessStatus(int accessStatus) {
                    this.accessStatus = accessStatus;
                }

                public int getVipStatus() {
                    return vipStatus;
                }

                public void setVipStatus(int vipStatus) {
                    this.vipStatus = vipStatus;
                }

                public String getVipStatusWarn() {
                    return vipStatusWarn;
                }

                public void setVipStatusWarn(String vipStatusWarn) {
                    this.vipStatusWarn = vipStatusWarn;
                }
            }
        }

        public static class ImagesBean {
            /**
             * imgUrl :
             */

            private String imgUrl;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
        }

        public static class LiveBean {
            /**
             * roomStatus : 1
             * liveStatus : 1
             * url : http://live.bilibili.com/10313
             * title : 我的世界 你建我哭
             * cover : http://i0.hdslb.com/bfs/live/8d879eec269c5e3b6dbd582380bbb4c92d12607b.jpg
             * online : 44100
             * roomid : 10313
             * roundStatus : 0
             */

            private int roomStatus;
            private int liveStatus;
            private String url;
            private String title;
            private String cover;
            private int online;
            private int roomid;
            private int roundStatus;

            public int getRoomStatus() {
                return roomStatus;
            }

            public void setRoomStatus(int roomStatus) {
                this.roomStatus = roomStatus;
            }

            public int getLiveStatus() {
                return liveStatus;
            }

            public void setLiveStatus(int liveStatus) {
                this.liveStatus = liveStatus;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public int getRoomid() {
                return roomid;
            }

            public void setRoomid(int roomid) {
                this.roomid = roomid;
            }

            public int getRoundStatus() {
                return roundStatus;
            }

            public void setRoundStatus(int roundStatus) {
                this.roundStatus = roundStatus;
            }
        }

        public static class ElecBean {
            /**
             * show : false
             * total : 606
             * count : 8
             * elec_num : 0
             * list : [{"pay_mid":1631076,"rank":1,"uname":"超爱肾的猫籍","avatar":"http://i2.hdslb.com/bfs/face/cef0542db5cf4a0874e842911014dc20f641368a.jpg"},{"pay_mid":107647014,"rank":2,"uname":"琴梨酱のかれし","avatar":"http://i1.hdslb.com/bfs/face/04089a8cd43bc0eb013af97e38324db1649fcd2c.jpg"},{"pay_mid":10895028,"rank":3,"uname":"超心塞的小狼","avatar":"http://i0.hdslb.com/bfs/face/d3f478ab43948cb987357824e5b141baee3e8ad1.jpg"},{"pay_mid":8097859,"rank":4,"uname":"新月觉","avatar":"http://i2.hdslb.com/bfs/face/6b9c0b072b3546d1f37f456ed4166848c97979aa.jpg"},{"pay_mid":103447526,"rank":5,"uname":"金都北苑","avatar":"http://i2.hdslb.com/bfs/face/ed2c9df24f653a59bbbff6c71afbc0505697187f.jpg"},{"pay_mid":13514198,"rank":6,"uname":"超心塞的九黎","avatar":"http://i1.hdslb.com/bfs/face/a8df1c038607ad00cfaa2689b31aa2b3483d9f28.jpg"},{"pay_mid":11746927,"rank":7,"uname":"从前有个喵叽叽","avatar":"http://i0.hdslb.com/bfs/face/dded277ba850c90b8fc392c148ca3d5bfa2516f1.jpg"},{"pay_mid":64682074,"rank":8,"uname":"尴尬R","avatar":"http://i0.hdslb.com/bfs/face/d30ce4f329de10c8ce70040a0a7ea92fed24eb94.jpg"}]
             * elec_set : {"elec_theme":0,"rmb_rate":10,"integrity_rate":10,"round_mode":0,"elec_list":[{"title":"20电池","elec_num":20,"is_customize":0},{"title":"60电池","elec_num":60,"is_customize":0},{"title":"450电池","elec_num":450,"is_customize":0},{"title":"880电池","elec_num":880,"is_customize":0},{"title":"自定义","elec_num":0,"is_customize":1,"min_elec":20,"max_elec":99999}]}
             */

            private boolean show;
            private int total;
            private int count;
            private int elec_num;
            private ElecSetBean elec_set;
            private List<ListBean> list;

            public boolean isShow() {
                return show;
            }

            public void setShow(boolean show) {
                this.show = show;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getElec_num() {
                return elec_num;
            }

            public void setElec_num(int elec_num) {
                this.elec_num = elec_num;
            }

            public ElecSetBean getElec_set() {
                return elec_set;
            }

            public void setElec_set(ElecSetBean elec_set) {
                this.elec_set = elec_set;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ElecSetBean {
                /**
                 * elec_theme : 0
                 * rmb_rate : 10.0
                 * integrity_rate : 10.0
                 * round_mode : 0
                 * elec_list : [{"title":"20电池","elec_num":20,"is_customize":0},{"title":"60电池","elec_num":60,"is_customize":0},{"title":"450电池","elec_num":450,"is_customize":0},{"title":"880电池","elec_num":880,"is_customize":0},{"title":"自定义","elec_num":0,"is_customize":1,"min_elec":20,"max_elec":99999}]
                 */

                private int elec_theme;
                private double rmb_rate;
                private double integrity_rate;
                private int round_mode;
                private List<ElecListBean> elec_list;

                public int getElec_theme() {
                    return elec_theme;
                }

                public void setElec_theme(int elec_theme) {
                    this.elec_theme = elec_theme;
                }

                public double getRmb_rate() {
                    return rmb_rate;
                }

                public void setRmb_rate(double rmb_rate) {
                    this.rmb_rate = rmb_rate;
                }

                public double getIntegrity_rate() {
                    return integrity_rate;
                }

                public void setIntegrity_rate(double integrity_rate) {
                    this.integrity_rate = integrity_rate;
                }

                public int getRound_mode() {
                    return round_mode;
                }

                public void setRound_mode(int round_mode) {
                    this.round_mode = round_mode;
                }

                public List<ElecListBean> getElec_list() {
                    return elec_list;
                }

                public void setElec_list(List<ElecListBean> elec_list) {
                    this.elec_list = elec_list;
                }

                public static class ElecListBean {
                    /**
                     * title : 20电池
                     * elec_num : 20
                     * is_customize : 0
                     * min_elec : 20
                     * max_elec : 99999
                     */

                    private String title;
                    private int elec_num;
                    private int is_customize;
                    private int min_elec;
                    private int max_elec;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public int getElec_num() {
                        return elec_num;
                    }

                    public void setElec_num(int elec_num) {
                        this.elec_num = elec_num;
                    }

                    public int getIs_customize() {
                        return is_customize;
                    }

                    public void setIs_customize(int is_customize) {
                        this.is_customize = is_customize;
                    }

                    public int getMin_elec() {
                        return min_elec;
                    }

                    public void setMin_elec(int min_elec) {
                        this.min_elec = min_elec;
                    }

                    public int getMax_elec() {
                        return max_elec;
                    }

                    public void setMax_elec(int max_elec) {
                        this.max_elec = max_elec;
                    }
                }
            }

            public static class ListBean {
                /**
                 * pay_mid : 1631076
                 * rank : 1
                 * uname : 超爱肾的猫籍
                 * avatar : http://i2.hdslb.com/bfs/face/cef0542db5cf4a0874e842911014dc20f641368a.jpg
                 */

                private int pay_mid;
                private int rank;
                private String uname;
                private String avatar;

                public int getPay_mid() {
                    return pay_mid;
                }

                public void setPay_mid(int pay_mid) {
                    this.pay_mid = pay_mid;
                }

                public int getRank() {
                    return rank;
                }

                public void setRank(int rank) {
                    this.rank = rank;
                }

                public String getUname() {
                    return uname;
                }

                public void setUname(String uname) {
                    this.uname = uname;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }
            }
        }

        public static class ArchiveBean implements Parcelable{
            /**
             * count : 116
             * item : [{"title":"横版守望先锋？你没看错！","cover":"http://i0.hdslb.com/bfs/archive/881c836aadaab6b5f132681ce594ce896c17c901.jpg","uri":"bilibili://video/12289892","param":"12289892","goto":"av","duration":941,"play":33934,"danmaku":367,"ctime":1500282936},{"title":"十六.《嘣战纪》131连见证奇迹的时刻。","cover":"http://i0.hdslb.com/bfs/archive/def27078a478563e5a3524ae5ddff3a3edec59dd.jpg","uri":"bilibili://video/12222408","param":"12222408","goto":"av","duration":874,"play":11655,"danmaku":286,"ctime":1500103517},{"title":"十六.七分钟教你玩懂《Bong-嘣战纪》","cover":"http://i2.hdslb.com/bfs/archive/39d749f6813b0385154edfefd6c6bb40996423e9.jpg","uri":"bilibili://video/12134093","param":"12134093","goto":"av","duration":426,"play":21604,"danmaku":181,"ctime":1499857058},{"title":"《装甲战争》游戏区UP们的疯狂打炮互gay","cover":"http://i2.hdslb.com/bfs/archive/3aedc7a684b679bc2fe4bb1fe25fcfd9ea02641b.jpg","uri":"bilibili://video/11441884","param":"11441884","goto":"av","duration":3524,"play":27535,"danmaku":155,"ctime":1497857428},{"title":"十六.《守望先锋》四分钟教你玩法鸡","cover":"http://i2.hdslb.com/bfs/archive/23277d5c986eab7ccf7cb6ff0a572f29d1ddf359.jpg","uri":"bilibili://video/11414676","param":"11414676","goto":"av","duration":264,"play":99104,"danmaku":595,"ctime":1497754803},{"title":"委屈！小学生竟然给我戴绿帽子！","cover":"http://i2.hdslb.com/bfs/archive/4f7dedd2fca7c03016b967b1e20b53d83030524a.jpg","uri":"bilibili://video/11372713","param":"11372713","goto":"av","duration":654,"play":33594,"danmaku":268,"ctime":1497609569},{"title":"【十六】雪糕歌","cover":"http://i1.hdslb.com/bfs/archive/495c0324c1f0c66c0f8c43eb40021f3670f4bdac.jpg","uri":"bilibili://video/11020891","param":"11020891","goto":"av","duration":188,"play":52165,"danmaku":855,"ctime":1497424772},{"title":"十六.【我的世界】《和风mod》半自动竹子机","cover":"http://i1.hdslb.com/bfs/archive/2bb71f07374d246cc711b558edc12d07b53c22ca.jpg","uri":"bilibili://video/10982649","param":"10982649","goto":"av","duration":526,"play":12157,"danmaku":181,"ctime":1497424772},{"title":"道德沦丧！4399下限再度突破！岛田兄弟惨遭变性！","cover":"http://i1.hdslb.com/bfs/archive/d25e4c348ae338696e1a7eadda99f0a0bd5d643e.jpg","uri":"bilibili://video/10839894","param":"10839894","goto":"av","duration":745,"play":60583,"danmaku":644,"ctime":1497424772},{"title":"【十六】你以为《汐》只是个跳跳乐？","cover":"http://i1.hdslb.com/bfs/archive/87de1d76c9de50fa273a0ba8e09215fd532a7c7e.jpg","uri":"bilibili://video/10446067","param":"10446067","goto":"av","duration":1894,"play":16293,"danmaku":326,"ctime":1497424772}]
             */

            private int count;
            private List<ArchiveItemBean> item;

            protected ArchiveBean(Parcel in) {
                count = in.readInt();
            }

            public static final Creator<ArchiveBean> CREATOR = new Creator<ArchiveBean>() {
                @Override
                public ArchiveBean createFromParcel(Parcel in) {
                    return new ArchiveBean(in);
                }

                @Override
                public ArchiveBean[] newArray(int size) {
                    return new ArchiveBean[size];
                }
            };

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<ArchiveItemBean> getItem() {
                return item;
            }

            public void setItem(List<ArchiveItemBean> item) {
                this.item = item;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(count);
            }

            public static class ArchiveItemBean {
                /**
                 * title : 横版守望先锋？你没看错！
                 * cover : http://i0.hdslb.com/bfs/archive/881c836aadaab6b5f132681ce594ce896c17c901.jpg
                 * uri : bilibili://video/12289892
                 * param : 12289892
                 * goto : av
                 * duration : 941
                 * play : 33934
                 * danmaku : 367
                 * ctime : 1500282936
                 */

                private String title;
                private String cover;
                private String uri;
                private String param;
                @SerializedName("goto")
                private String gotoX;
                private int duration;
                private int play;
                private int danmaku;
                private int ctime;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }

                public String getGotoX() {
                    return gotoX;
                }

                public void setGotoX(String gotoX) {
                    this.gotoX = gotoX;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public int getPlay() {
                    return play;
                }

                public void setPlay(int play) {
                    this.play = play;
                }

                public int getDanmaku() {
                    return danmaku;
                }

                public void setDanmaku(int danmaku) {
                    this.danmaku = danmaku;
                }

                public int getCtime() {
                    return ctime;
                }

                public void setCtime(int ctime) {
                    this.ctime = ctime;
                }
            }
        }

        public static class ArticleBean {
            /**
             * count : 0
             */

            private int count;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        public static class FavouriteBean implements Parcelable{
            /**
             * count : 2
             * item : [{"fid":1827014,"mid":682508,"name":"默认收藏夹","max_count":100000,"cur_count":3,"atten_count":0,"state":0,"ctime":1438922096,"mtime":1497398043,"cover":[{"aid":7604530,"pic":"http://i1.hdslb.com/bfs/archive/f5d91dd8b54096c29799fd8563f84c7ac8c9c3c0.png"},{"aid":5848068,"pic":"http://i2.hdslb.com/bfs/archive/2d793dd068ea9cb9b73a9e49fc12940b9bfd3529.jpg"},{"aid":3685610,"pic":"http://i0.hdslb.com/bfs/archive/359f7d14832fda4da1d2778c040dfd9e3b381f24.jpg"}]},{"fid":714487,"mid":682508,"name":"收藏了个夹","max_count":999,"cur_count":9,"atten_count":0,"state":2,"ctime":1436867644,"mtime":1486640057,"cover":[{"aid":4909431,"pic":"http://i2.hdslb.com/bfs/archive/715dfedac0587f1a8c0e807d59797ae19d648d41.jpg"},{"aid":1002217,"pic":"http://i2.hdslb.com/bfs/archive/66fc6cc085d11b8cb6dff008a4a4e84542b37ba0.jpg"},{"aid":3108488,"pic":"http://i1.hdslb.com/bfs/archive/88a38fd68291d543934a2a67271159675c3e7b4a.jpg"}]}]
             */

            private int count;
            private List<FavouriteItemBean> item;

            protected FavouriteBean(Parcel in) {
                count = in.readInt();
            }

            public static final Creator<FavouriteBean> CREATOR = new Creator<FavouriteBean>() {
                @Override
                public FavouriteBean createFromParcel(Parcel in) {
                    return new FavouriteBean(in);
                }

                @Override
                public FavouriteBean[] newArray(int size) {
                    return new FavouriteBean[size];
                }
            };

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<FavouriteItemBean> getItem() {
                return item;
            }

            public void setItem(List<FavouriteItemBean> item) {
                this.item = item;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(count);
            }

            public static class FavouriteItemBean {
                /**
                 * fid : 1827014
                 * mid : 682508
                 * name : 默认收藏夹
                 * max_count : 100000
                 * cur_count : 3
                 * atten_count : 0
                 * state : 0
                 * ctime : 1438922096
                 * mtime : 1497398043
                 * cover : [{"aid":7604530,"pic":"http://i1.hdslb.com/bfs/archive/f5d91dd8b54096c29799fd8563f84c7ac8c9c3c0.png"},{"aid":5848068,"pic":"http://i2.hdslb.com/bfs/archive/2d793dd068ea9cb9b73a9e49fc12940b9bfd3529.jpg"},{"aid":3685610,"pic":"http://i0.hdslb.com/bfs/archive/359f7d14832fda4da1d2778c040dfd9e3b381f24.jpg"}]
                 */

                private int fid;
                private int mid;
                private String name;
                private int max_count;
                private int cur_count;
                private int atten_count;
                private int state;
                private int ctime;
                private int mtime;
                private List<CoverBean> cover;

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getMid() {
                    return mid;
                }

                public void setMid(int mid) {
                    this.mid = mid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getMax_count() {
                    return max_count;
                }

                public void setMax_count(int max_count) {
                    this.max_count = max_count;
                }

                public int getCur_count() {
                    return cur_count;
                }

                public void setCur_count(int cur_count) {
                    this.cur_count = cur_count;
                }

                public int getAtten_count() {
                    return atten_count;
                }

                public void setAtten_count(int atten_count) {
                    this.atten_count = atten_count;
                }

                public int getState() {
                    return state;
                }

                public void setState(int state) {
                    this.state = state;
                }

                public int getCtime() {
                    return ctime;
                }

                public void setCtime(int ctime) {
                    this.ctime = ctime;
                }

                public int getMtime() {
                    return mtime;
                }

                public void setMtime(int mtime) {
                    this.mtime = mtime;
                }

                public List<CoverBean> getCover() {
                    return cover;
                }

                public void setCover(List<CoverBean> cover) {
                    this.cover = cover;
                }

                public static class CoverBean {
                    /**
                     * aid : 7604530
                     * pic : http://i1.hdslb.com/bfs/archive/f5d91dd8b54096c29799fd8563f84c7ac8c9c3c0.png
                     */

                    private int aid;
                    private String pic;

                    public int getAid() {
                        return aid;
                    }

                    public void setAid(int aid) {
                        this.aid = aid;
                    }

                    public String getPic() {
                        return pic;
                    }

                    public void setPic(String pic) {
                        this.pic = pic;
                    }
                }
            }
        }

        public static class SeasonBean implements Parcelable{
            /**
             * count : 5
             * item : [{"title":"第六天魔王","cover":"http://i0.hdslb.com/bfs/bangumi/29d001c8083a224da99b72239be5680c6ac907e7.jpg","uri":"bilibili://bangumi/season/6043","param":"6043","goto":"bangumi","newest_ep_index":"17","is_started":1,"total_count":"-1","attention":"0"},{"title":"Re:CREATORS","cover":"http://i0.hdslb.com/bfs/bangumi/3944fe0b84a5763cde6b0573773b89ba86b4321d.jpg","uri":"bilibili://bangumi/season/5998","param":"5998","goto":"bangumi","newest_ep_index":"15","is_started":1,"total_count":"22","attention":"0"},{"title":"凹凸世界 第一季","cover":"http://i0.hdslb.com/bfs/bangumi/0322eb656e2d745b9cd118bbe6297b82a1b13c08.jpg","uri":"bilibili://bangumi/season/3043","param":"3043","goto":"bangumi","finish":1,"newest_ep_index":"番外","is_started":1,"total_count":"32","attention":"0"},{"title":"夏目友人帐 陆","cover":"http://i0.hdslb.com/bfs/bangumi/39716626d611a765c44ca27054f3526210c4d5cb.jpg","uri":"bilibili://bangumi/season/5977","param":"5977","goto":"bangumi","finish":1,"newest_ep_index":"11","is_started":1,"total_count":"11","attention":"0"},{"title":"全职高手","cover":"http://i0.hdslb.com/bfs/bangumi/958cffa5054239ae9695469708949de0caaeabe4.jpg","uri":"bilibili://bangumi/season/5852","param":"5852","goto":"bangumi","finish":1,"newest_ep_index":"12","is_started":1,"total_count":"12","attention":"0"}]
             */

            private int count;
            private List<SeasonItemBean> item;

            protected SeasonBean(Parcel in) {
                count = in.readInt();
            }

            public static final Creator<SeasonBean> CREATOR = new Creator<SeasonBean>() {
                @Override
                public SeasonBean createFromParcel(Parcel in) {
                    return new SeasonBean(in);
                }

                @Override
                public SeasonBean[] newArray(int size) {
                    return new SeasonBean[size];
                }
            };

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<SeasonItemBean> getItem() {
                return item;
            }

            public void setItem(List<SeasonItemBean> item) {
                this.item = item;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(count);
            }

            public static class SeasonItemBean {
                /**
                 * title : 第六天魔王
                 * cover : http://i0.hdslb.com/bfs/bangumi/29d001c8083a224da99b72239be5680c6ac907e7.jpg
                 * uri : bilibili://bangumi/season/6043
                 * param : 6043
                 * goto : bangumi
                 * newest_ep_index : 17
                 * is_started : 1
                 * total_count : -1
                 * attention : 0
                 * finish : 1
                 */

                private String title;
                private String cover;
                private String uri;
                private String param;
                @SerializedName("goto")
                private String gotoX;
                private String newest_ep_index;
                private int is_started;
                private String total_count;
                private String attention;
                private int finish;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }

                public String getGotoX() {
                    return gotoX;
                }

                public void setGotoX(String gotoX) {
                    this.gotoX = gotoX;
                }

                public String getNewest_ep_index() {
                    return newest_ep_index;
                }

                public void setNewest_ep_index(String newest_ep_index) {
                    this.newest_ep_index = newest_ep_index;
                }

                public int getIs_started() {
                    return is_started;
                }

                public void setIs_started(int is_started) {
                    this.is_started = is_started;
                }

                public String getTotal_count() {
                    return total_count;
                }

                public void setTotal_count(String total_count) {
                    this.total_count = total_count;
                }

                public String getAttention() {
                    return attention;
                }

                public void setAttention(String attention) {
                    this.attention = attention;
                }

                public int getFinish() {
                    return finish;
                }

                public void setFinish(int finish) {
                    this.finish = finish;
                }
            }
        }

        public static class CoinArchiveBean implements Parcelable {
            /**
             * count : 1
             * item : [{"title":"【凯玟桑】Arrow","cover":"http://i2.hdslb.com/bfs/archive/c837490efb9d702095b48c76cffd52a85a0dc9b6.png","uri":"bilibili://video/11899326","param":"11899326","goto":"av","duration":235,"play":8528,"danmaku":323,"ctime":1499220561}]
             */

            private int count;
            private List<CoinItemBean> item;

            protected CoinArchiveBean(Parcel in) {
                count = in.readInt();
            }

            public static final Creator<CoinArchiveBean> CREATOR = new Creator<CoinArchiveBean>() {
                @Override
                public CoinArchiveBean createFromParcel(Parcel in) {
                    return new CoinArchiveBean(in);
                }

                @Override
                public CoinArchiveBean[] newArray(int size) {
                    return new CoinArchiveBean[size];
                }
            };

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<CoinItemBean> getItem() {
                return item;
            }

            public void setItem(List<CoinItemBean> item) {
                this.item = item;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(count);
            }

            public static class CoinItemBean {
                /**
                 * title : 【凯玟桑】Arrow
                 * cover : http://i2.hdslb.com/bfs/archive/c837490efb9d702095b48c76cffd52a85a0dc9b6.png
                 * uri : bilibili://video/11899326
                 * param : 11899326
                 * goto : av
                 * duration : 235
                 * play : 8528
                 * danmaku : 323
                 * ctime : 1499220561
                 */

                private String title;
                private String cover;
                private String uri;
                private String param;
                @SerializedName("goto")
                private String gotoX;
                private int duration;
                private int play;
                private int danmaku;
                private int ctime;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }

                public String getGotoX() {
                    return gotoX;
                }

                public void setGotoX(String gotoX) {
                    this.gotoX = gotoX;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public int getPlay() {
                    return play;
                }

                public void setPlay(int play) {
                    this.play = play;
                }

                public int getDanmaku() {
                    return danmaku;
                }

                public void setDanmaku(int danmaku) {
                    this.danmaku = danmaku;
                }

                public int getCtime() {
                    return ctime;
                }

                public void setCtime(int ctime) {
                    this.ctime = ctime;
                }
            }
        }

        public static class GameBean implements Parcelable {
            /**
             * count : 5
             * item : [{"id":75,"name":"仙剑奇侠传幻璃镜","icon":"http://i0.hdslb.com/bfs/game/914f8c00352afe5a2d99a62863634baf1db3d5c7.jpg","summary":"入境成妖，破界重生！","uri":"com.shangruan.huanlijing.bili"},{"id":55,"name":"阴阳师","icon":"http://i0.hdslb.com/bfs/game/36ee7db87a0d27aa5bb4672fffc22fb5ff8ec68c.png","summary":"唯美如樱，百鬼物语","uri":"com.netease.onmyoji.bili"},{"id":76,"name":"刀剑乱舞","icon":"http://i0.hdslb.com/bfs/game/2950e1d94aa49a740f0d69a6ca64d60f97b68564.png","summary":"刀剑男士，即刻出阵！","uri":"com.youzu.djlw.bili"},{"id":26,"name":"克鲁赛德战记","icon":"http://i2.hdslb.com/u_user/503113dc29417f5c53abfeb9b520dbeb.png","summary":"日式萌系像素风RPG","uri":"com.nhnst.SKCQCN.bili"},{"id":61,"name":"命运-冠位指定（Fate/GO）","icon":"http://i0.hdslb.com/bfs/game/0a114c837d9f8fae8f2489a4bf91bf912c61edae.png","summary":"全平台公测开启！","uri":"com.bilibili.fatego"}]
             */

            private int count;
            private List<GameItemBean> item;

            protected GameBean(Parcel in) {
                count = in.readInt();
            }

            public static final Creator<GameBean> CREATOR = new Creator<GameBean>() {
                @Override
                public GameBean createFromParcel(Parcel in) {
                    return new GameBean(in);
                }

                @Override
                public GameBean[] newArray(int size) {
                    return new GameBean[size];
                }
            };

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<GameItemBean> getItem() {
                return item;
            }

            public void setItem(List<GameItemBean> item) {
                this.item = item;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(count);
            }

            public static class GameItemBean {
                /**
                 * id : 75
                 * name : 仙剑奇侠传幻璃镜
                 * icon : http://i0.hdslb.com/bfs/game/914f8c00352afe5a2d99a62863634baf1db3d5c7.jpg
                 * summary : 入境成妖，破界重生！
                 * uri : com.shangruan.huanlijing.bili
                 */

                private int id;
                private String name;
                private String icon;
                private String summary;
                private String uri;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getSummary() {
                    return summary;
                }

                public void setSummary(String summary) {
                    this.summary = summary;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }
            }
        }

        public static class CommunityBean implements Parcelable {
            /**
             * count : 2
             * item : [{"id":863,"name":"Minecraft","desc":"众多史蒂夫在Bilibili兴趣圈的聚集地","thumb":"http://img.yo9.com/478e25e09fc511e59d8700163e00043c","post_count":696,"member_count":23395,"post_nickname":"帖子","member_nickname":"史蒂夫"},{"id":136,"name":"我的世界","desc":"《我的世界》中国版7月14日上线","thumb":"http://img.yo9.com/730e591084c611e6a2b400163e00043c","post_count":1232,"member_count":61423,"post_nickname":"方块","member_nickname":"史蒂夫"}]
             */

            private int count;
            private List<CommunityItemBean> item;

            protected CommunityBean(Parcel in) {
                count = in.readInt();
            }

            public static final Creator<CommunityBean> CREATOR = new Creator<CommunityBean>() {
                @Override
                public CommunityBean createFromParcel(Parcel in) {
                    return new CommunityBean(in);
                }

                @Override
                public CommunityBean[] newArray(int size) {
                    return new CommunityBean[size];
                }
            };

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<CommunityItemBean> getItem() {
                return item;
            }

            public void setItem(List<CommunityItemBean> item) {
                this.item = item;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(count);
            }

            public static class CommunityItemBean {
                /**
                 * id : 863
                 * name : Minecraft
                 * desc : 众多史蒂夫在Bilibili兴趣圈的聚集地
                 * thumb : http://img.yo9.com/478e25e09fc511e59d8700163e00043c
                 * post_count : 696
                 * member_count : 23395
                 * post_nickname : 帖子
                 * member_nickname : 史蒂夫
                 */

                private int id;
                private String name;
                private String desc;
                private String thumb;
                private int post_count;
                private int member_count;
                private String post_nickname;
                private String member_nickname;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public int getPost_count() {
                    return post_count;
                }

                public void setPost_count(int post_count) {
                    this.post_count = post_count;
                }

                public int getMember_count() {
                    return member_count;
                }

                public void setMember_count(int member_count) {
                    this.member_count = member_count;
                }

                public String getPost_nickname() {
                    return post_nickname;
                }

                public void setPost_nickname(String post_nickname) {
                    this.post_nickname = post_nickname;
                }

                public String getMember_nickname() {
                    return member_nickname;
                }

                public void setMember_nickname(String member_nickname) {
                    this.member_nickname = member_nickname;
                }
            }
        }
    }
}

