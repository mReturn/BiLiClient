package com.mreturn.biliclient.ui.video;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.VideoDetailsInfo;
import com.mreturn.biliclient.ui.base.BaseRxLazyFragment;
import com.mreturn.biliclient.utils.ImageLoader;
import com.zhy.view.flowlayout.TagFlowLayout;

import butterknife.BindView;

/**
 * Created by mReturn
 * on 2017/7/24.
 */

public class VideoInfoFragment extends BaseRxLazyFragment {

    VideoDetailsInfo.VideoDetail detailData;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_play_time)
    TextView tvPlayTime;
    @BindView(R.id.tv_review_count)
    TextView tvReviewCount;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_share_num)
    TextView tvShareNum;
    @BindView(R.id.btn_share)
    LinearLayout btnShare;
    @BindView(R.id.tv_coin_num)
    TextView tvCoinNum;
    @BindView(R.id.btn_coin)
    LinearLayout btnCoin;
    @BindView(R.id.tv_fav_num)
    TextView tvFavNum;
    @BindView(R.id.btn_fav)
    LinearLayout btnFav;
    @BindView(R.id.btn_download)
    LinearLayout btnDownload;
    @BindView(R.id.iv_user_avatar)
    ImageView ivUserAvatar;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tags_layout)
    TagFlowLayout tagsLayout;
    @BindView(R.id.layout_video_related)
    RelativeLayout layoutVideoRelated;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    public static VideoInfoFragment newInstance(VideoDetailsInfo.VideoDetail detail) {
        VideoInfoFragment fragment = new VideoInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.EXTRA_DATA, detail);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frament_video_info;
    }

    @Override
    protected void initView(Bundle state) {
        detailData = getArguments().getParcelable(Constant.EXTRA_DATA);

        //基本信息
        tvTitle.setText(detailData.getTitle());
        tvPlayTime.setText(detailData.getStat().getView()+"");
        tvReviewCount.setText(detailData.getStat().getDanmaku()+"");
        tvDescription.setText(detailData.getDesc());
        ImageLoader.display(ivUserAvatar,detailData.getOwner().getFace(),R.drawable.ico_user_default);
        tvUserName.setText(detailData.getOwner().getName());
        //分享 收藏 投币数量
        tvShareNum.setText(detailData.getStat().getShare()+"");
        tvFavNum.setText(detailData.getStat().getFavorite()+"");
        tvCoinNum.setText(detailData.getStat().getCoin());

    }
}
