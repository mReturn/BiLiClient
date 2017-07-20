package com.mreturn.biliclient.adapter.helper;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by mReturn
 * on 2017/7/20.
 */

public abstract class CustomerOnScrollListener extends RecyclerView.OnScrollListener {
    private int previousCount = 0;
    private boolean isLoading = true;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (dy == 0)
            return;
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int visiableItemCount = recyclerView.getChildCount();
        int totleCount = layoutManager.getItemCount();
        int lastVisiablePos = layoutManager.findLastCompletelyVisibleItemPosition();
        if (isLoading && totleCount > previousCount) {
            isLoading = false;
            previousCount = totleCount;
        }

        if (!isLoading && visiableItemCount > 0 && lastVisiablePos >= totleCount - 1) {
            onLoadMore();
            isLoading = false;
        }
    }

    public void reset(){
        isLoading = true;
        previousCount = 0;
    }

    public abstract void onLoadMore();
}
