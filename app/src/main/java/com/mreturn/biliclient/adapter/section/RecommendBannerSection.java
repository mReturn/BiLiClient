package com.mreturn.biliclient.adapter.section;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.widget.banner.BannerBean;
import com.mreturn.biliclient.widget.banner.BannerView;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/11.
 */

public class RecommendBannerSection extends StatelessSection {

    List<BannerBean> bannerList ;

    public RecommendBannerSection(List<BannerBean> bannerList) {
        super(R.layout.layout_banner_view,R.layout.layout_none_view);
        this.bannerList = bannerList;
    }

    @Override
    protected int getContentItemsCount() {
        return 1;
    }

    @Override
    public void bindItemView(BaseViewHolder holder, int position) {
    }

    @Override
    public void bindHeaderView(BaseViewHolder holder) {
        BannerView bannerView = holder.getView(R.id.banner_view);
        bannerView.delayTime(5).build(bannerList);
    }
}
