package com.mreturn.bilibili.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mReturn
 * on 2017/7/5.
 */

public abstract class BaseLazyFragment extends Fragment {

    View parentView;
    protected boolean isPrepared; //是否初始化完成
    protected boolean isVisible;  //是否可见
    Unbinder bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutId(), container, false);
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        initView(savedInstanceState);

    }


    public Context getApplicationContext() {
        return getActivity() == null ? null : getActivity().getApplicationContext();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (bind != null)
            bind.unbind();
    }

    /**
     * 数据懒加载
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void lazyLoad() {
    }

    protected void onInvisible() {
    }


    @SuppressWarnings("unchecked")
    public <T extends View> T $(int id) {
        return (T) parentView.findViewById(id);
    }

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle state);
}
