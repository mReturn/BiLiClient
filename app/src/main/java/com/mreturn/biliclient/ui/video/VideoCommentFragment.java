package com.mreturn.biliclient.ui.video;

import android.os.Bundle;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.ui.base.BaseRxLazyFragment;

/**
 * Created by mReturn
 * on 2017/7/24.
 */

public class VideoCommentFragment extends BaseRxLazyFragment {
    int aid;

    public static VideoCommentFragment newInstance(int aid){
        VideoCommentFragment fragment = new VideoCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.AID,aid);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_comment;
    }

    @Override
    protected void initView(Bundle state) {

    }
}
