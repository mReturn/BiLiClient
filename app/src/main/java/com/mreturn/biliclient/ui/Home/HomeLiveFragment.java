package com.mreturn.biliclient.ui.Home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.bean.LiveAppIndexInfo;
import com.mreturn.biliclient.ui.base.BaseLazyFragment;
import com.mreturn.biliclient.utils.ToastUtil;
import com.mreturn.biliclient.widget.CustomEmptyView;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/5.
 */

public class HomeLiveFragment extends BaseLazyFragment {

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
        initRecycleView();
        isPrepared = false;
    }

    private void initRefreshLayout() {
        swipRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipRefreshLayout.setOnRefreshListener(this ::getData);
        swipRefreshLayout.post( () ->{
            swipRefreshLayout.setRefreshing(true);
            getData();
        });
    }

    private void getData() {
        RetrofitHelper.getLiveApi()
                .getLiveAppIndex()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LiveAppIndexInfo>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull LiveAppIndexInfo liveAppIndexInfo) {
                        ToastUtil.show("成功");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        ToastUtil.show("失败");

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initRecycleView() {
    }
}
