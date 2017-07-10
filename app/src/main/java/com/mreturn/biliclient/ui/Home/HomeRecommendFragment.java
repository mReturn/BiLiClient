package com.mreturn.biliclient.ui.Home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.home.RecommendBannerInfo;
import com.mreturn.biliclient.adapter.home.RecommendInfo;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.ui.base.BaseLazyFragment;
import com.mreturn.biliclient.widget.CustomEmptyView;
import com.mreturn.biliclient.widget.banner.BannerBean;

import java.util.List;

import butterknife.BindView;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/10.
 */

public class HomeRecommendFragment extends BaseLazyFragment {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.empty_view)
    CustomEmptyView emptyView;
    @BindView(R.id.swip_refresh_layout)
    SwipeRefreshLayout swipRefreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_live;
    }

    @Override
    protected void initView(Bundle state) {
        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible)
            return;
        initRefreshLayout();
        initRecyclerView();
        isPrepared = false;
    }

    private void initRefreshLayout() {
        swipRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipRefreshLayout.post(() -> {
            swipRefreshLayout.setRefreshing(true);
            getData();
        });

        swipRefreshLayout.setOnRefreshListener(() -> {
            getData();
        });

    }

    private void initRecyclerView() {

    }

    private void getData() {
        RetrofitHelper.getAppApi()
                .getRecommendedBannerInfo()
                .compose(bindToLifecycle())
                .map(RecommendBannerInfo::getData)
                .flatMap(new Function<List<BannerBean>, ObservableSource<RecommendInfo>>() {
                    @Override
                    public ObservableSource<RecommendInfo> apply(@NonNull List<BannerBean> bannerBeen) throws Exception {
                        return RetrofitHelper.getAppApi().getRecommendedInfo();
                    }
                })
                .compose(bindToLifecycle())
                .map(RecommendInfo::getResult)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<List<RecommendInfo.ResultBean>>() {
                    @Override
                    protected void onSuccess(List<RecommendInfo.ResultBean> resultBeen) {
                        swipRefreshLayout.setRefreshing(false);
                        emptyView.setVisibility(View.GONE);
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                        swipRefreshLayout.setRefreshing(false);
                        emptyView.setVisibility(View.VISIBLE);
                    }
                });
    }
}
