package com.mreturn.biliclient.adapter.section;

import android.content.Context;
import android.view.View;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.bean.BangumiRecommendInfo;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.ToastUtil;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/12.
 */

public class BangumiRecommendSection extends StatelessSection {
    private Context context;
    private List<BangumiRecommendInfo.ResultBean> recommendList;

    public BangumiRecommendSection(Context context, List<BangumiRecommendInfo.ResultBean> recommendList) {
        super(R.layout.item_bangumi_recommend);
        this.context = context;
        this.recommendList = recommendList;
        this.setSpanSize(3);
    }

    @Override
    protected int getContentItemsCount() {
        return recommendList.size();
    }

    @Override
    public void bindItemView(BaseViewHolder holder, int position) {
        if (position == 0){
            holder.setVisibility(View.VISIBLE,R.id.tv_top);
        }else{
            holder.setVisibility(View.GONE,R.id.tv_top);
        }

        ImageLoader.display(holder.getImageView(R.id.iv_cover),recommendList.get(position).getCover(),
                R.drawable.bili_default_image_tv);
        holder.setText(R.id.tv_title,recommendList.get(position).getTitle());
        holder.setText(R.id.tv_desc,recommendList.get(position).getDesc());
        if (recommendList.get(position).getIs_new() == 1){
            holder.setVisibility(View.VISIBLE,R.id.iv_new);
        }else {
            holder.setVisibility(View.GONE,R.id.iv_new);
        }

        holder.setClickListener(R.id.card_view,v -> {
            //TODO click
            ToastUtil.show("recommend");
        });
    }
}
