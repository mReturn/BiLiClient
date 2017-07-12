package com.mreturn.biliclient.adapter.section.base;

import android.support.annotation.LayoutRes;

import com.mreturn.biliclient.adapter.BaseViewHolder;

/**
 * Created by mReturn
 * on 2017/7/10.
 * <p/>
 * Abstract Section to be used with {@link SectionedRecyclerViewAdapter}.
 */

public abstract class Section {
    public enum State {LOADING, LOADED, FAILED}

    private State state = State.LOADED;

    boolean visible = true;
    boolean hasHeader = false;
    boolean hasFooter = false;

    @LayoutRes
    Integer headerResourceId;
    @LayoutRes
    Integer footerResourceId;
    @LayoutRes
    Integer itemResourceId;

    @LayoutRes
    private Integer loadingResourceId;
    @LayoutRes
    private Integer failedResourceId;

    private int spanSize = 1;


    //constructor
    public Section() {
    }

    public Section(Integer itemResourceId, Integer loadingResourceId, Integer failedResourceId) {
        this.itemResourceId = itemResourceId;
        this.loadingResourceId = loadingResourceId;
        this.failedResourceId = failedResourceId;
    }

    public Section(Integer headerResourceId, Integer itemResourceId, Integer loadingResourceId, Integer failedResourceId) {
        this(itemResourceId, loadingResourceId, failedResourceId);
        this.headerResourceId = headerResourceId;
        hasHeader = true;
    }

    public Section(Integer headerResourceId, Integer footerResourceId, Integer itemResourceId, Integer loadingResourceId, Integer failedResourceId) {
        this(headerResourceId, itemResourceId, loadingResourceId, failedResourceId);
        this.footerResourceId = footerResourceId;
        hasFooter = true;
    }

    //item count
    public final int getSectionItemsCount() {
        int contentItemsCount;
        switch (state) {
            case LOADING:
                contentItemsCount = 1;
                break;
            case LOADED:
                contentItemsCount = getContentItemsCount();
                break;
            case FAILED:
                contentItemsCount = 1;
                break;
            default:
                throw new IllegalStateException("illegal state");

        }
        return contentItemsCount + (hasHeader ? 1 : 0) + (hasFooter ? 1 : 0);
    }

    protected abstract int getContentItemsCount();

    //bind view
    public final void bindContentView(BaseViewHolder holder, int position) {
        switch (state) {
            case LOADING:
                bindLoadingView(holder);
                break;
            case LOADED:
                bindItemView(holder, position);
                break;
            case FAILED:
                bindFailedView(holder);
                break;
            default:
                throw new IllegalStateException("illegal state");
        }
    }

    public void bindLoadingView(BaseViewHolder holder) {
    }

    public  void bindItemView(BaseViewHolder holder, int position){
    }

    public void bindFailedView(BaseViewHolder holder) {
    }

    public void bindHeaderView(BaseViewHolder holder) {
    }


    public void bindFooterView(BaseViewHolder holder) {
    }


    // get & set
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isHasHeader() {
        return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    public boolean isHasFooter() {
        return hasFooter;
    }

    public void setHasFooter(boolean hasFooter) {
        this.hasFooter = hasFooter;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    //get
    public Integer getHeaderResourceId() {
        return headerResourceId;
    }

    public Integer getFooterResourceId() {
        return footerResourceId;
    }

    public Integer getItemResourceId() {
        return itemResourceId;
    }

    public Integer getLoadingResourceId() {
        return loadingResourceId;
    }

    public Integer getFailedResourceId() {
        return failedResourceId;
    }
}
