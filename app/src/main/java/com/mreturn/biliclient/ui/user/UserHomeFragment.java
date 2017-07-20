package com.mreturn.biliclient.ui.user;

import android.os.Bundle;

import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.UserInfo;

/**
 * Created by mReturn
 * on 2017/7/20.
 */

public class UserHomeFragment extends BaseUserFragment {
    private UserInfo userInfo;

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
        mRecycleView.setHasFixedSize(true);

    }
}
