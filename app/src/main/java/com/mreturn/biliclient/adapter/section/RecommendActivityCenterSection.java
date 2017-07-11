package com.mreturn.biliclient.adapter.section;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.home.RecommendInfo;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.ToastUtil;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/11.
 */

public class RecommendActivityCenterSection extends StatelessSection{
    private List<RecommendInfo.ResultBean.BodyBean> activitys;

    public RecommendActivityCenterSection( List<RecommendInfo.ResultBean.BodyBean> activitys) {
        super(R.layout.item_activitycenter_header, R.layout.item_activitycenter_item);
        this.activitys = activitys;
    }

    @Override
    protected int getContentItemsCount() {
        return activitys.size();
    }


    @Override
    public void bindItemView(BaseViewHolder holder, int position) {
        ImageLoader.display(holder.getImageView(R.id.iv_cover),activitys.get(position).getCover());
        holder.setText(R.id.tv_title,activitys.get(position).getTitle());
        holder.setClickListener(R.id.card_view,v -> {
            ToastUtil.show(activitys.get(position).getTitle());
        });

    }
}
