package com.mreturn.biliclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mreturn.biliclient.R;

import java.util.List;


/**
 * Created by mReturn
 * on 2017/7/19.
 */

public abstract class LoadMoreRvAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;
    private static final int STATE_LOADING = -1;
    private static final int STATE_NO_FOOTER = -2;

    protected Context mContext;
    private int layoutId;
    protected List<T> mDatas;

    protected View mFootView;
    private int mFooterState;

    public void setFooterState(int mFooterState) {
        this.mFooterState = mFooterState;
    }

    public LoadMoreRvAdapter(Context mContext, int layoutId, List<T> mDatas) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.layoutId = layoutId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case TYPE_ITEM:
                view = getItemView(parent);
                return new BaseViewHolder(view);
            case TYPE_FOOTER:
                view = getFooterView(parent);
                return new BaseViewHolder(view);
            default:
                return null;
        }
    }

    protected View getItemView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
    }
    protected View getFooterView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_load_more, parent, false);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_ITEM){
            bindData(holder,position);
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addFooter(){
        FootBean footerBean = new FootBean();
        mDatas.add((T) footerBean);
        setFooterState(STATE_LOADING);
        notifyDataSetChanged();
    }

    public void removeFooter(){
        int lastPos = mDatas.size()-1;
        int type = getItemViewType(lastPos);
        if (type == TYPE_FOOTER){
            mDatas.remove(lastPos);
            setFooterState(STATE_NO_FOOTER);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position) instanceof FootBean){
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    static class FootBean {

    }


    protected abstract void bindData(BaseViewHolder holder, int position);
}
