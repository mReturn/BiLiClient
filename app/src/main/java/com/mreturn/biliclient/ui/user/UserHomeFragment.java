package com.mreturn.biliclient.ui.user;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.section.UserHomeSection;
import com.mreturn.biliclient.adapter.section.base.SectionedRecyclerViewAdapter;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.UserInfo;

/**
 * Created by mReturn
 * on 2017/7/20.
 */

public class UserHomeFragment extends BaseUserFragment {

    private UserInfo userInfo;
    SectionedRecyclerViewAdapter sectionAdapter;

    public static UserHomeFragment newInstance(UserInfo userInfo) {
        UserHomeFragment fragment = new UserHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.EXTRA_DATA, userInfo);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void prepareData() {
        userInfo = getArguments().getParcelable(Constant.EXTRA_DATA);
        if (userInfo == null || userInfo.getData() == null) {
            showEmptyView();
        }

    }

    @Override
    protected void initRecyclerView() {
        sectionAdapter = new SectionedRecyclerViewAdapter();
        mRecycleView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),6);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (sectionAdapter.getSectionItemViewType(position)){
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 6;
                    default:
                        return sectionAdapter.getSectionSpanSize(position);
                }
            }
        });
        mRecycleView.setLayoutManager(gridLayoutManager);
        mRecycleView.setAdapter(sectionAdapter);
        fillData();
    }

    private void fillData() {
        UserInfo.DataBean userData = userInfo.getData();
        UserInfo.DataBean.ArchiveBean archiveBean = userData.getArchive();
        UserInfo.DataBean.FavouriteBean favouriteBean = userData.getFavourite();
        UserInfo.DataBean.SeasonBean seasonBean = userData.getSeason();
        UserInfo.DataBean.CommunityBean communityBean = userData.getCommunity();
        UserInfo.DataBean.CoinArchiveBean coinBean = userData.getCoin_archive();
        UserInfo.DataBean.GameBean gameBean= userData.getGame();
        if (archiveBean != null && archiveBean.getCount()>0){
            sectionAdapter.addSection(new UserHomeSection<>(R.layout.item_user_home_archive,getActivity(),
                    archiveBean.getItem(),UserHomeSection.TYPE_ARCHIVE,archiveBean.getCount()));
        }
        if (coinBean != null && coinBean.getCount()>0){
            sectionAdapter.addSection(new UserHomeSection<>(R.layout.item_user_home_archive,getActivity(),
                    coinBean.getItem(),UserHomeSection.TYPE_COIN,coinBean.getCount()));
        }
        if (favouriteBean != null && favouriteBean.getCount()>0){
            sectionAdapter.addSection(new UserHomeSection<>(R.layout.item_user_home_favourite,getActivity(),
                    favouriteBean.getItem(),UserHomeSection.TYPE_FAVOURITE,favouriteBean.getCount()));
        }
        if (seasonBean != null && seasonBean.getCount()>0){
            sectionAdapter.addSection(new UserHomeSection<>(R.layout.item_user_season,getActivity(),
                    seasonBean.getItem(),UserHomeSection.TYPE_SEASON,seasonBean.getCount()));
        }
        if (communityBean != null && communityBean.getCount()>0){
            sectionAdapter.addSection(new UserHomeSection<>(R.layout.item_user_community,getActivity(),
                    communityBean.getItem(),UserHomeSection.TYPE_COMMUNITY,communityBean.getCount()));
        }
        if (gameBean != null && gameBean.getCount()>0){
            sectionAdapter.addSection(new UserHomeSection<>(R.layout.item_user_game,getActivity(),
                    gameBean.getItem(),UserHomeSection.TYPE_GAME,gameBean.getCount()));
        }

        if (sectionAdapter.getSectionsCount() == 0) showEmptyView();
    }


}
