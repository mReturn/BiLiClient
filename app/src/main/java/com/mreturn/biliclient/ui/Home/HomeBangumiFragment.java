package com.mreturn.biliclient.ui.Home;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.section.bangumi.BangumiAdBodySection;
import com.mreturn.biliclient.adapter.section.bangumi.BangumiIndexSection;
import com.mreturn.biliclient.adapter.section.bangumi.BangumiRecommendSection;
import com.mreturn.biliclient.adapter.section.bangumi.BangumiSeasonSection;
import com.mreturn.biliclient.adapter.section.bangumi.BangumiSerialSection;
import com.mreturn.biliclient.adapter.section.recommend.RecommendBannerSection;
import com.mreturn.biliclient.adapter.section.base.SectionedRecyclerViewAdapter;
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
 * 番剧
 */

public class HomeBangumiFragment extends BaseHomeContentFragment {

    BangumiAppIndexInfo bangumiIndexInfo;
    SectionedRecyclerViewAdapter sectionAdapter;

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
        sectionAdapter = new SectionedRecyclerViewAdapter();
        GridLayoutManager gridLayoutmanager = new GridLayoutManager(getActivity(),3);
        gridLayoutmanager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (sectionAdapter.getSectionItemViewType(position)){
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 3;
                    default:
                        return sectionAdapter.getSectionSpanSize(position);
                }
            }
        });

        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(gridLayoutmanager);
        recycleView.setAdapter(sectionAdapter);
    }

    private void getBangumiData() {
        RetrofitHelper.getBangumiApi()
                .getBangumiAppIndex()
                .compose(bindToLifecycle())
                .flatMap(new Function<BangumiAppIndexInfo, ObservableSource<BangumiRecommendInfo>>() {
                    @Override
                    public ObservableSource<BangumiRecommendInfo> apply(@NonNull BangumiAppIndexInfo bangumiAppIndexInfo) throws Exception {
                        bangumiIndexInfo = bangumiAppIndexInfo;
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
                        setBangumiData(resultBeen);
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                        swipRefreshLayout.setRefreshing(false);
                        emptyView.setVisibility(View.VISIBLE);
                        recycleView.setVisibility(View.GONE);
                    }
                });
    }

    private void setBangumiData(List<BangumiRecommendInfo.ResultBean> resultBeen) {
        sectionAdapter.removeAllSections();
        BangumiAppIndexInfo.ResultBean indexResultBean = bangumiIndexInfo.getResult();
        if (bangumiIndexInfo != null){
            sectionAdapter.addSection(new RecommendBannerSection(indexResultBean.getAd().getHead()));
            sectionAdapter.addSection(new BangumiIndexSection(getActivity()));
            sectionAdapter.addSection(new BangumiSerialSection(getActivity(),indexResultBean.getSerializing()));
            if (indexResultBean.getAd().getBody() != null && indexResultBean.getAd().getBody().size()>0){
                sectionAdapter.addSection(new BangumiAdBodySection(getActivity(),indexResultBean.getAd().getBody()));
            }
            sectionAdapter.addSection(new BangumiSeasonSection(getActivity(),
                    indexResultBean.getPrevious().getSeason(),indexResultBean.getPrevious().getList()));
        }
        sectionAdapter.addSection(new BangumiRecommendSection(getActivity(),resultBeen));

        sectionAdapter.notifyDataSetChanged();
    }
}
