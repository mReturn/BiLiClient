package com.mreturn.biliclient.ui.Home;

import android.view.View;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.bean.BangumiAppIndexInfo;
import com.mreturn.biliclient.bean.BangumiRecommendInfo;

import java.util.List;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/11.
 */

public class HomeBangumiFragment extends BaseHomeContentFragment {


    @Override
    protected void initRefreshLayout() {
        swipRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipRefreshLayout.post(() -> {
            swipRefreshLayout.setRefreshing(true);
            getBangumiData();
        });
        swipRefreshLayout.setOnRefreshListener(this::getBangumiData);
    }

    @Override
    protected void initRecyclerView() {

    }

    private void getBangumiData() {
        RetrofitHelper.getBangumiApi()
                .getBangumiAppIndex()
                .compose(bindToLifecycle())
                .flatMap(new Function<BangumiAppIndexInfo, ObservableSource<BangumiRecommendInfo>>() {
                    @Override
                    public ObservableSource<BangumiRecommendInfo> apply(@NonNull BangumiAppIndexInfo bangumiAppIndexInfo) throws Exception {
                        return RetrofitHelper.getBangumiApi().getBangumiRecommended();
                    }
                })
                .compose(bindToLifecycle())
                .map(BangumiRecommendInfo::getResult)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<List<BangumiRecommendInfo.ResultBean>>() {
                    @Override
                    protected void onSuccess(List<BangumiRecommendInfo.ResultBean> resultBeen) {
                        swipRefreshLayout.setRefreshing(false);
                        emptyView.setVisibility(View.GONE);
                        recycleView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                        swipRefreshLayout.setRefreshing(false);
                        emptyView.setVisibility(View.VISIBLE);
                        recycleView.setVisibility(View.GONE);
                    }
                });
    }
}
