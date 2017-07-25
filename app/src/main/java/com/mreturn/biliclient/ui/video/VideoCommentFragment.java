package com.mreturn.biliclient.ui.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.LoadMoreRvAdapter;
import com.mreturn.biliclient.adapter.helper.CustomerOnScrollListener;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.VideoCommentInfo;
import com.mreturn.biliclient.ui.base.BaseRxLazyFragment;
import com.mreturn.biliclient.ui.user.UserInfoActivity;
import com.mreturn.biliclient.utils.DateUtils;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.MyLog;
import com.mreturn.biliclient.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/24.
 */

public class VideoCommentFragment extends BaseRxLazyFragment {
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    int aid;
    int pageNum = 1;
    int pageSize = 20;
    LoadMoreRvAdapter adapter;
    List<VideoCommentInfo.ListBean> commentList = new ArrayList<>();

    public static VideoCommentFragment newInstance(int aid) {
        VideoCommentFragment fragment = new VideoCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.AID, aid);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_comment;
    }

    @Override
    protected void initView(Bundle state) {
        aid = getArguments().getInt(Constant.AID);
        initRecycleView();
        getData();
    }

    private void initRecycleView() {
        initAdapter();
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleView.setAdapter(adapter);
        recycleView.addOnScrollListener(new CustomerOnScrollListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                adapter.addFooter();
                recycleView.scrollToPosition(adapter.getItemCount() - 1);
                getData();
            }
        });

    }

    private void initAdapter() {
        if (adapter == null){
            adapter = new LoadMoreRvAdapter<VideoCommentInfo.ListBean>(getActivity(),R.layout.item_video_comment,commentList) {
                @Override
                protected void bindData(BaseViewHolder holder, int position) {
                    VideoCommentInfo.ListBean comment = commentList.get(position);

                    LinearLayout llHot = holder.getView(R.id.ll_hot);
                    if (position == 2){
                        llHot.setVisibility(View.VISIBLE);
                    }else {
                        llHot.setVisibility(View.GONE);
                    }
                    ImageLoader.displayCircleImg(holder.getImageView(R.id.iv_user_avatar),comment.getFace(),
                            R.drawable.ico_user_default);
                    holder.setText(R.id.tv_user_name,comment.getNick());
                    setLevel(holder.getImageView(R.id.iv_user_lever),comment.getLevel_info().getCurrent_level());
                    ImageView ivUserSex = holder.getImageView(R.id.iv_user_sex);
                    switch (comment.getSex()){
                        case "男":
                            ivUserSex.setImageResource(R.drawable.ic_user_male);
                            break;
                        case "女":
                            ivUserSex.setImageResource(R.drawable.ic_user_female);
                            break;
                        default:
                            ivUserSex.setImageResource(R.drawable.ic_user_gay_border);
                            break;
                    }
                    holder.setText(R.id.tv_comment_num,comment.getReply_count()+"");
                    holder.setText(R.id.tv_comment_spot,comment.getGood()+"");
                    long lTime = DateUtils.stringToLong(comment.getCreate_at(),"yyy-MM-dd HH:mm");
                    String timeStr = DateUtils.getDescFromTimeStamp(lTime);
                    holder.setText(R.id.tv_comment_time,timeStr);
                    holder.setText(R.id.tv_comment_content,comment.getMsg());
                    holder.setText(R.id.tv_comment_floor,"#"+comment.getLv());
                    holder.setClickListener(R.id.iv_user_avatar,v ->
                            UserInfoActivity.launch(getContext(),comment.getMid())
                    );

                }
            };
        }
    }

    private void setLevel(ImageView ivLevel, int current_level) {
        switch (current_level) {
            case 0:
                ivLevel.setImageResource(R.drawable.ic_lv0);
                break;
            case 1:
                ivLevel.setImageResource(R.drawable.ic_lv1);
                break;
            case 2:
                ivLevel.setImageResource(R.drawable.ic_lv2);
                break;
            case 3:
                ivLevel.setImageResource(R.drawable.ic_lv3);
                break;
            case 4:
                ivLevel.setImageResource(R.drawable.ic_lv4);
                break;
            case 5:
                ivLevel.setImageResource(R.drawable.ic_lv5);
                break;
            case 6:
                ivLevel.setImageResource(R.drawable.ic_lv6);
                break;
            default:
                break;
        }
    }

    private void getData() {
        int ver = 3;
        RetrofitHelper.getApi()
                .getVideoComment(aid, pageNum, pageSize, ver)
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<VideoCommentInfo>() {
                    @Override
                    protected void onSuccess(VideoCommentInfo videoCommentInfo) {
                        adapter.removeFooter();
                        setCommentData(videoCommentInfo);
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                        adapter.removeFooter();
                        ToastUtil.show(e.toString());
                        MyLog.e("comment error :",e.toString());
                    }
                });
    }

    private void setCommentData(VideoCommentInfo videoCommentInfo) {
        if (pageNum == 1) {
            commentList.clear();
            if (videoCommentInfo.getHotList() != null) commentList.addAll(videoCommentInfo.getHotList());
        }
        if (videoCommentInfo.getList() != null) commentList.addAll(videoCommentInfo.getList());
        adapter.notifyDataSetChanged();
    }


}
