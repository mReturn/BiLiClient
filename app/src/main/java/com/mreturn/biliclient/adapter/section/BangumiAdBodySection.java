package com.mreturn.biliclient.adapter.section;

import android.content.Context;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.bean.BangumiAppIndexInfo;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.ToastUtil;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/12.
 */

public class BangumiAdBodySection extends StatelessSection {

    private Context context;
    private List<BangumiAppIndexInfo.ResultBean.AdBean.BodyBean> bodyList;

    public BangumiAdBodySection(Context context, List<BangumiAppIndexInfo.ResultBean.AdBean.BodyBean> bodyList) {
        super(R.layout.item_bangumi_ad_body, R.layout.layout_none_view);
        this.context = context;
        this.bodyList = bodyList;
    }

    @Override
    protected int getContentItemsCount() {
        return 1;
    }

    @Override
    public void bindHeaderView(BaseViewHolder holder) {
        BangumiAppIndexInfo.ResultBean.AdBean.BodyBean bodyBean = bodyList.get(0);
        ImageLoader.display(holder.getImageView(R.id.iv_bangumi_boby),bodyBean.getImg());
        holder.setClickListener(R.id.iv_bangumi_boby,v -> {
            //TODO click
            ToastUtil.show("ad body");
        });
    }
}
