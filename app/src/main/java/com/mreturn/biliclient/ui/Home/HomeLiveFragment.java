package com.mreturn.biliclient.ui.Home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.HomeLiveAdapter;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.bean.LiveAppIndexInfo;
import com.mreturn.biliclient.ui.base.BaseLazyFragment;
import com.mreturn.biliclient.widget.CustomEmptyView;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
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

    HomeLiveAdapter liveAdapter;

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
        swipRefreshLayout.setOnRefreshListener(this::getData);
        swipRefreshLayout.post(() -> {
            swipRefreshLayout.setRefreshing(true);
            getData();
        });
    }

    private void initRecycleView() {
        liveAdapter = new HomeLiveAdapter(getActivity());
        recycleView.setAdapter(liveAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),10);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                return liveAdapter.getSpanSize(position);
            }
        });
        recycleView.setLayoutManager(layoutManager);
    }

    private void getData() {
        RetrofitHelper.getLiveApi()
                .getLiveAppIndex()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<LiveAppIndexInfo>() {
                    @Override
                    protected void onSuccess(LiveAppIndexInfo liveAppIndexInfo) {
                        swipRefreshLayout.setRefreshing(false);
                        emptyView.setVisibility(View.GONE);
                        liveAdapter.setLiveInfo(liveAppIndexInfo);
                        liveAdapter.notifyDataSetChanged();
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                        swipRefreshLayout.setRefreshing(false);
                        emptyView.setVisibility(View.VISIBLE);
                    }
                });
    }

}
