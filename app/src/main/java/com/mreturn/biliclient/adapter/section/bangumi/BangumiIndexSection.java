package com.mreturn.biliclient.adapter.section.bangumi;

import android.content.Context;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.utils.ToastUtil;

/**
 * Created by mReturn
 * on 2017/7/12.
 */

public class BangumiIndexSection extends StatelessSection {
    Context context;

    public BangumiIndexSection(Context context) {
        super(R.layout.item_bangumi_index, R.layout.layout_none_view);
        this.context = context;
    }


    @Override
    protected int getContentItemsCount() {
        return 1;
    }

    @Override
    public void bindHeaderView(BaseViewHolder holder) {
        holder.setClickListener(R.id.tv_bangumi,v -> {
            ToastUtil.show("bangumi");
        });
        holder.setClickListener(R.id.tv_schedule,v -> {
            ToastUtil.show("schedule");
        });
        holder.setClickListener(R.id.tv_index,v -> {
            ToastUtil.show("index");
        });
    }
}
