package com.mreturn.biliclient.ui.Home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.bean.HotSearchTag;
import com.mreturn.biliclient.ui.base.BaseRxLazyFragment;
import com.mreturn.biliclient.utils.ToastUtil;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/17.
 */

public class HomeDiscoverFragment extends BaseRxLazyFragment {
    @BindView(R.id.tags_layout)
    TagFlowLayout mTagFlowLayout;

    @BindView(R.id.hide_scroll_view)
    NestedScrollView mScrollView;

    @BindView(R.id.hide_tags_layout)
    TagFlowLayout mHideTagLayout;

    @BindView(R.id.more_layout)
    LinearLayout mMoreLayout;

    @BindView(R.id.tv_more)
    TextView mMoreText;

    boolean isShowMore = true;
    List<HotSearchTag.ListBean> hotSearchTags = new ArrayList<>();
    TagAdapter<HotSearchTag.ListBean> tagAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView(Bundle state) {
        getTagsData();
    }

    private void getTagsData() {
        RetrofitHelper.getSearchApi()
                .getHotSearchTags()
                .compose(bindToLifecycle())
                .map(HotSearchTag::getList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<List<HotSearchTag.ListBean>>() {
                    @Override
                    protected void onSuccess(List<HotSearchTag.ListBean> listBeen) {
                        hotSearchTags.clear();
                        hotSearchTags.addAll(listBeen);
                        showTagView();
                    }

                    @Override
                    protected void onFailure(Throwable e) {

                    }
                });

    }

    private void showTagView() {
        List<HotSearchTag.ListBean> partList = hotSearchTags.subList(0,8);
        mTagFlowLayout.setAdapter(new TagAdapter<HotSearchTag.ListBean>(partList) {
            @Override
            public View getView(FlowLayout parent, int position, HotSearchTag.ListBean listBean) {
                TextView tv = (TextView) LayoutInflater.from(getActivity()).
                        inflate(R.layout.layout_tags_item, parent, false);
                tv.setText(listBean.getKeyword());
                tv.setOnClickListener(v -> {
                    //TODO click
                    ToastUtil.show(tv.getText().toString());
                });
                return tv;
            }
        });
        mHideTagLayout.setAdapter(new TagAdapter<HotSearchTag.ListBean>(hotSearchTags) {
            @Override
            public View getView(FlowLayout parent, int position, HotSearchTag.ListBean listBean) {
                TextView tv = (TextView) LayoutInflater.from(getActivity()).
                        inflate(R.layout.layout_tags_item, parent, false);
                tv.setText(listBean.getKeyword());
                tv.setOnClickListener(v -> {
                    //TODO click
                    ToastUtil.show(tv.getText().toString());
                });
                return tv;
            }
        });
    }

    @OnClick(R.id.more_layout)
    void chageTagViewShow() {
        if (isShowMore) {
            mScrollView.setVisibility(View.VISIBLE);
            mTagFlowLayout.setVisibility(View.GONE);
            mMoreText.setText("收起");
            Drawable upDrawable = getResources().getDrawable(R.drawable.ic_arrow_up_gray_round);
            upDrawable.setBounds(0, 0, upDrawable.getMinimumWidth(), upDrawable.getMinimumHeight());
            mMoreText.setCompoundDrawables(upDrawable, null, null, null);
        } else {
            mScrollView.setVisibility(View.GONE);
            mTagFlowLayout.setVisibility(View.VISIBLE);
            mMoreText.setText("查看更多");
            Drawable downDrawable = getResources().getDrawable(R.drawable.ic_arrow_down_gray_round);
            downDrawable.setBounds(0, 0, downDrawable.getMinimumWidth(), downDrawable.getMinimumHeight());
            mMoreText.setCompoundDrawables(downDrawable, null, null, null);
        }
        isShowMore = !isShowMore;
    }

}
