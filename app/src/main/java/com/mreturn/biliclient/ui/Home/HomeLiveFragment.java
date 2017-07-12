package com.mreturn.biliclient.ui.Home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.home.HomeLiveAdapter;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.bean.LiveAppIndexInfo;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/5.
 * 直播
 */

public class HomeLiveFragment extends BaseHomeContentFragment {

    HomeLiveAdapter liveAdapter;

    @Override
    protected void initRefreshLayout() {
        swipRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipRefreshLayout.setOnRefreshListener(this::getData);
        swipRefreshLayout.post(() -> {
            swipRefreshLayout.setRefreshing(true);
            getData();
        });
    }

    @Override
    protected void initRecyclerView() {
        liveAdapter = new HomeLiveAdapter(getActivity());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),10);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                return liveAdapter.getSpanSize(position);
            }
        });
        recycleView.setLayoutManager(layoutManager);
        recycleView.setHasFixedSize(true);
        recycleView.setAdapter(liveAdapter);

    }

    private void getData() {
        RetrofitHelper.getLiveApi()
                .getLiveAppIndex()
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<LiveAppIndexInfo>() {
                    @Override
                    protected void onSuccess(LiveAppIndexInfo liveAppIndexInfo) {
                        swipRefreshLayout.setRefreshing(false);
                        emptyView.setVisibility(View.GONE);
                        recycleView.setVisibility(View.VISIBLE);
                        liveAdapter.setLiveInfo(liveAppIndexInfo);
                        liveAdapter.notifyDataSetChanged();
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
