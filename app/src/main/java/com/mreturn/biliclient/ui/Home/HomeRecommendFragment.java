package com.mreturn.biliclient.ui.Home;

import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.home.RecommendBannerInfo;
import com.mreturn.biliclient.adapter.home.RecommendInfo;
import com.mreturn.biliclient.adapter.section.RecommendActivityCenterSection;
import com.mreturn.biliclient.adapter.section.RecommendBannerSection;
import com.mreturn.biliclient.adapter.section.RecommendTopicSection;
import com.mreturn.biliclient.adapter.section.base.RecommendSection;
import com.mreturn.biliclient.adapter.section.base.SectionedRecyclerViewAdapter;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.widget.banner.BannerBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/10.
 */

public class HomeRecommendFragment extends BaseHomeContentFragment {


    List<BannerBean> bannerList = new ArrayList<>();
    SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected void initRefreshLayout() {
        swipRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipRefreshLayout.post(() -> {
            swipRefreshLayout.setRefreshing(true);
            getData();
        });

        swipRefreshLayout.setOnRefreshListener(() -> {
            getData();
        });

    }

    @Override
    protected void initRecyclerView() {
        sectionAdapter = new SectionedRecyclerViewAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (sectionAdapter.getSectionItemViewType(position)){
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 2;
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_FOOTER:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        recycleView.setLayoutManager(gridLayoutManager);
        recycleView.setHasFixedSize(true);
        recycleView.setAdapter(sectionAdapter);
    }

    private void getData() {
        RetrofitHelper.getAppApi()
                .getRecommendedBannerInfo()
                .compose(bindToLifecycle())
                .map(RecommendBannerInfo::getData)
                .flatMap(new Function<List<BannerBean>, ObservableSource<RecommendInfo>>() {
                    @Override
                    public ObservableSource<RecommendInfo> apply(@NonNull List<BannerBean> bannerBeen) throws Exception {
                        bannerList.clear();
                        bannerList.addAll(bannerBeen);
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
                        recycleView.setVisibility(View.VISIBLE);
                        setRecommendData(resultBeen);
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                        swipRefreshLayout.setRefreshing(false);
                        recycleView.setVisibility(View.GONE);
                        emptyView.setVisibility(View.VISIBLE);
                    }
                });
    }

    private void setRecommendData(List<RecommendInfo.ResultBean> resultBeen) {
        //banner
        sectionAdapter.addSection(new RecommendBannerSection(bannerList));
        //item
        for (int i=0; i<resultBeen.size();i++){
            String type = resultBeen.get(i).getType();
            if (!TextUtils.isEmpty(type)){
                switch (type){
                    case Constant.TYPE_TOPIC:
                        //话题
                        RecommendInfo.ResultBean.BodyBean bodyBean = resultBeen.get(i).getBody().get(0);
                        sectionAdapter.addSection(new RecommendTopicSection(bodyBean.getCover(),
                                bodyBean.getTitle(),bodyBean.getParam()));
                        break;
                    case Constant.TYPE_ACTIVITY_CENTER:
                        sectionAdapter.addSection(new RecommendActivityCenterSection(resultBeen.get(i).getBody()));
                        break;
                    default:
                        sectionAdapter.addSection(new RecommendSection(getActivity(),
                                resultBeen.get(i).getHead().getTitle(),
                                resultBeen.get(i).getType(),
                                resultBeen.get(i).getHead().getCount(),
                                resultBeen.get(i).getBody()));
                        break;
                }
            }
        }

        sectionAdapter.notifyDataSetChanged();
    }
}
