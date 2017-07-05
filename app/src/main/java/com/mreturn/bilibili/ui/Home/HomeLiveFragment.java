package com.mreturn.bilibili.ui.Home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.mreturn.bilibili.R;
import com.mreturn.bilibili.api.RetrofitHelper;
import com.mreturn.bilibili.bean.LiveAppIndexInfo;
import com.mreturn.bilibili.ui.base.BaseLazyFragment;
import com.mreturn.bilibili.utils.ToastUtil;
import com.mreturn.bilibili.widget.CustomEmptyView;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

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
//        RetrofitHelper.getLiveApi()
//                .getLiveAppIndex()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(liveAppIndexInfo -> {
//                    ToastUtil.show("成功");
//                }, throwable -> {
//                    ToastUtil.show("失败");
//                });
    }

    private void initRecycleView() {
    }
}
