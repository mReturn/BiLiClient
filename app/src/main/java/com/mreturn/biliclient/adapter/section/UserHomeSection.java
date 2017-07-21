package com.mreturn.biliclient.adapter.section;

import android.content.Context;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.bean.UserInfo;
import com.mreturn.biliclient.ui.user.UserInfoActivity;
import com.mreturn.biliclient.utils.ImageLoader;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/20.
 */

public class UserHomeSection<T> extends StatelessSection {
    private Context context;
    private List<T> list;
    private int type;
    private int count;

    public static final int TYPE_ARCHIVE = 1;
    public static final int TYPE_FAVOURITE = 2;
    public static final int TYPE_SEASON = 3;
    public static final int TYPE_COMMUNITY = 4;
    public static final int TYPE_COIN = 5;
    public static final int TYPE_GAME = 6;

    public UserHomeSection(int itemResourceId, Context context, List<T> list, int type, int count) {
        super(R.layout.item_user_home_header, itemResourceId);
        this.context = context;
        this.list = list;
        this.type = type;
        this.count = count;
        setSpanSize(getItemSpanSize());
    }

    private int getItemSpanSize() {
        switch (type) {
            case TYPE_ARCHIVE:
            case TYPE_COIN:
                return 3;
            case TYPE_FAVOURITE:
            case TYPE_SEASON:
                return 2;
            default:
                return 6;
        }
    }


    @Override
    protected int getContentItemsCount() {
        switch (type) {
            case TYPE_FAVOURITE:
            case TYPE_SEASON:
                if (list.size()>3){
                    return 3;
                }else {
                    return list.size();
                }
            default:
                if (list.size()>2){
                    return 2;
                }else {
                    return list.size();
                }
        }
    }

    @Override
    public void bindHeaderView(BaseViewHolder holder) {
        holder.setText(R.id.tv_count, count + "");
        switch (type) {
            case TYPE_ARCHIVE:
                holder.setText(R.id.tv_title, "全部投稿");
                break;
            case TYPE_FAVOURITE:
                holder.setText(R.id.tv_title, "TA的收藏夹");
                break;
            case TYPE_COMMUNITY:
                holder.setText(R.id.tv_title, "TA的圈子");
                break;
            case TYPE_SEASON:
                holder.setText(R.id.tv_title, "TA的追番");
                break;
            case TYPE_COIN:
                holder.setText(R.id.tv_title, "最近投币的视频");
                break;
            case TYPE_GAME:
                holder.setText(R.id.tv_title, "TA玩的游戏");
                break;
            default:
                break;
        }

        holder.setClickListener(R.id.root_view,v ->
            ((UserInfoActivity)context).switchPage(type)
        );
    }

    @Override
    public void bindItemView(BaseViewHolder holder, int position) {
        switch (type) {
            case TYPE_ARCHIVE:
                UserInfo.DataBean.ArchiveBean.ArchiveItemBean archiveItemBean =
                        (UserInfo.DataBean.ArchiveBean.ArchiveItemBean) list.get(position);
                ImageLoader.display(holder.getImageView(R.id.iv_img), archiveItemBean.getCover()
                        , R.drawable.bili_default_image_tv);
                holder.setText(R.id.tv_title, archiveItemBean.getTitle());
                holder.setText(R.id.tv_play, archiveItemBean.getPlay() + "");
                holder.setText(R.id.tv_danmaku, archiveItemBean.getDanmaku() + "");
                break;
            case TYPE_FAVOURITE:
                UserInfo.DataBean.FavouriteBean.FavouriteItemBean favouriteItemBean =
                        (UserInfo.DataBean.FavouriteBean.FavouriteItemBean) list.get(position);
                List<UserInfo.DataBean.FavouriteBean.FavouriteItemBean.CoverBean> coverBean = favouriteItemBean.getCover();
                if (coverBean != null){
                    if (coverBean.size()>0){
                        ImageLoader.display(holder.getImageView(R.id.iv_top), coverBean.get(0).getPic(),
                                R.drawable.bili_default_image_tv);
                    }
                    if (coverBean.size()>1){
                        ImageLoader.display(holder.getImageView(R.id.iv_left), coverBean.get(1).getPic(),
                                R.drawable.bili_default_image_tv);
                    }
                    if (coverBean.size()>2){
                        ImageLoader.display(holder.getImageView(R.id.iv_right), coverBean.get(2).getPic(),
                                R.drawable.bili_default_image_tv);
                    }
                }
                holder.setText(R.id.tv_count, favouriteItemBean.getCur_count() + "");
                holder.setText(R.id.tv_name, favouriteItemBean.getName());
                break;
            case TYPE_COMMUNITY:
                UserInfo.DataBean.CommunityBean.CommunityItemBean communityItemBean =
                        (UserInfo.DataBean.CommunityBean.CommunityItemBean) list.get(position);
                ImageLoader.display(holder.getImageView(R.id.iv_img),communityItemBean.getThumb(),R.drawable.bili_default_image_tv);
                holder.setText(R.id.tv_title,communityItemBean.getName());
                holder.setText(R.id.tv_desc,communityItemBean.getDesc());
                holder.setText(R.id.tv_post_nickname,communityItemBean.getPost_nickname());
                holder.setText(R.id.tv_post_count,communityItemBean.getPost_count()+"");
                holder.setText(R.id.tv_member_nickname,communityItemBean.getMember_nickname());
                holder.setText(R.id.tv_member_count,communityItemBean.getMember_count()+"");
                break;
            case TYPE_SEASON:
                UserInfo.DataBean.SeasonBean.SeasonItemBean seasonItemBean =
                        (UserInfo.DataBean.SeasonBean.SeasonItemBean) list.get(position);
                ImageLoader.display(holder.getImageView(R.id.iv_img), seasonItemBean.getCover(), R.drawable.bili_default_image_tv);
                holder.setText(R.id.tv_title, seasonItemBean.getTitle());
                String updateStr;
                if (seasonItemBean.getFinish() == 1) {
                    updateStr = "全" + seasonItemBean.getTotal_count() + "话";
                } else {
                    updateStr = "更新至第" + seasonItemBean.getNewest_ep_index() + "话";
                }
                holder.setText(R.id.tv_update, updateStr);
                break;
            case TYPE_COIN:
                UserInfo.DataBean.CoinArchiveBean.CoinItemBean coinItemBean =
                        (UserInfo.DataBean.CoinArchiveBean.CoinItemBean) list.get(position);
                ImageLoader.display(holder.getImageView(R.id.iv_img), coinItemBean.getCover()
                        , R.drawable.bili_default_image_tv);
                holder.setText(R.id.tv_title, coinItemBean.getTitle());
                holder.setText(R.id.tv_play, coinItemBean.getPlay() + "");
                holder.setText(R.id.tv_danmaku, coinItemBean.getDanmaku() + "");
                break;
            case TYPE_GAME:
                UserInfo.DataBean.GameBean.GameItemBean item =
                        (UserInfo.DataBean.GameBean.GameItemBean) list.get(position);
                ImageLoader.display(holder.getImageView(R.id.iv_img),item.getIcon(),R.drawable.bili_default_image_tv);
                holder.setText(R.id.tv_title,item.getName());
                holder.setText(R.id.tv_desc,item.getSummary());
                break;
            default:
                break;
        }
    }

}
