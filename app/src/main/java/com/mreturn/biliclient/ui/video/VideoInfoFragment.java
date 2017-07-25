package com.mreturn.biliclient.ui.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseRecycleViewAdapter;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.VideoDetailsInfo;
import com.mreturn.biliclient.ui.base.BaseRxLazyFragment;
import com.mreturn.biliclient.ui.user.UserInfoActivity;
import com.mreturn.biliclient.utils.ImageLoader;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mReturn
 * on 2017/7/24.
 */

public class VideoInfoFragment extends BaseRxLazyFragment {

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

    VideoDetailsInfo.VideoDetail detailData;
    int mid = -1;

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
        mid = detailData.getOwner().getMid();

        //基本信息
        tvTitle.setText(detailData.getTitle());
        tvPlayTime.setText(detailData.getStat().getView() + "");
        tvReviewCount.setText(detailData.getStat().getDanmaku() + "");
        tvDescription.setText(detailData.getDesc());
        ImageLoader.displayCircleImg(ivUserAvatar, detailData.getOwner().getFace(), R.drawable.ico_user_default);
        tvUserName.setText(detailData.getOwner().getName());
        //分享 收藏 投币数量
        tvShareNum.setText(detailData.getStat().getShare() + "");
        tvFavNum.setText(detailData.getStat().getFavorite() + "");
        tvCoinNum.setText(detailData.getStat().getCoin() + "");
        setVideoRelatedView(detailData.getRelates());
    }

    private void setVideoRelatedView(List<VideoDetailsInfo.VideoDetail.RelatesBean> relates) {
        if (relates == null || relates.size() == 0)
            return;
        recycleView.setHasFixedSize(true);
        recycleView.setNestedScrollingEnabled(false); //不加的话滑动不流畅
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        recycleView.setAdapter(new BaseRecycleViewAdapter<VideoDetailsInfo.VideoDetail.RelatesBean>(getActivity(), relates) {
            @Override
            public int getItemLayoutId(int layoutID) {
                return R.layout.item_video_info;
            }

            @Override
            public void bindData(BaseViewHolder holder, int position) {
                VideoDetailsInfo.VideoDetail.RelatesBean relate = relates.get(position);
                holder.setText(R.id.tv_title, relate.getTitle());
                holder.setText(R.id.tv_play, relate.getStat().getView() + "");
                holder.setText(R.id.tv_review, relate.getStat().getDanmaku() + "");
                holder.setText(R.id.tv_user_name, relate.getOwner().getName());
                ImageLoader.display(holder.getImageView(R.id.iv_img), relate.getPic(), R.drawable.bili_default_image_tv);
                holder.setSimClickListener(v ->
                                VideoDetailActivity.launch(mContext, relate.getAid(), relate.getPic())
                        ,R.id.iv_img,R.id.rl_content);
            }
        });
    }

    @OnClick(R.id.iv_user_avatar)
    void toUserDeatil(){
        UserInfoActivity.launch(getContext(),mid);
    }


}
